/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
*/
/**
 * 题目名称：二叉树的深度
 * 题目描述：输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution {
    /**
     * 思路：
     * 二叉树的深度为左右子树深度最深的那一颗 + 1（递归）
     */
    public int TreeDepth(TreeNode root) {
        if (root != null) {
            int left = TreeDepth(root.left);
            int right = TreeDepth(root.right);
            return left > right ? left + 1 : right + 1;
        }
        return 0;
    }
}