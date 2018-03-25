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
 * 题目名称：数的子结构
 * 题目描述：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution {

    /**
     * 思路：
     * 1.在A树中先序遍历，找到第一个与B树根节点相同的节点
     * 2.以此节点为根基，判断B树的每个节点是否与A树中对应的节点相同
     * 3.相同则返回true
     * 4.不同则继续先序遍历
	 *
	 * 考察：二叉树的先序遍历序列
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        // 空树不是任意一个树的子树，只要有一个为空，就返回false
        if (root1 == null || root2 == null) return false;
        
        // 开始先序遍历
        if (searchSubTree(root1, root2)) return true;
        // 左右子树中只要有一边的结构与B数相同就返回true
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    /**
     * 以root为根节点的树是否包含subTree
     */
    public boolean searchSubTree(TreeNode root, TreeNode subTree) {
        if (subTree == null) return true;
        if (root == null) return false;
        
        if (root.val == subTree.val) {
            boolean left = searchSubTree(root.left, subTree.left);
            boolean right = searchSubTree(root.right, subTree.right);
            return left && right;
        }
        return false;
    }
}