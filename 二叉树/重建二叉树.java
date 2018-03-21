/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * 题目名称：重建二叉树
 * 题目描述：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution {
    /**
     * 思路：
     * 1.在先序遍历序列中创建根节点
     * 2.在中序遍历序列中找到根节点左右子树的范围
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // 合法性判断
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
    
    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        // 在先序遍历序列中创建根节点
        TreeNode root = new TreeNode(pre[startPre]);
        // 在中序遍历序列中找到根节点左右子树的范围
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                // 左子树在先序遍历序列中的范围：[startPre + 1, startPre + i - startIn]
                // 左子树在中序遍历序列中的范围：[startIn, i - 1]
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                // 右子树在先序遍历序列中的范围：[startPre + i - startIn + 1, endPre]
                // 右子树在中序遍历序列中的范围：[i + 1, endIn]
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                // 后面的业务逻辑由递归来完成，这里退出就可以
                break;
            }
        }
        return root;
    }
    
}