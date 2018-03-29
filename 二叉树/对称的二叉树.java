/*
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
 * 题目名称：对称的二叉树
 * 题目描述：请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution {
    
    /**
     * 思路1：
     * 生成这颗二叉树的镜像，逐一比对即可
     */
    boolean isSymmetrical(TreeNode pRoot) {
        // 合法性判断
        if (pRoot == null || (pRoot.left == null && pRoot.right == null)) {
            return true;
        }
        // 1.生成一颗镜像二叉树
        TreeNode mirrorTree = buildMirrorTree(pRoot);
        // 2.遍历二叉树，判断两颗二叉树的每个节点的值是否相同
        boolean isMirror = isMirrorTree(pRoot, mirrorTree);
        return isMirror;
    }
    
    /**
     * 创建一颗二叉树的镜像
     */
    public TreeNode buildMirrorTree(TreeNode pNode) {
        TreeNode pRoot = null;
        if (pNode != null) {
            pRoot = new TreeNode(pNode.val);
            pRoot.left = buildMirrorTree(pNode.right);
            pRoot.right = buildMirrorTree(pNode.left);
        }
        return pRoot;
    }
    
    /**
     * 判断两颗二叉树的每个节点的值是否相同
     */
    public boolean isMirrorTree(TreeNode pNode1, TreeNode pNode2) {
        if (pNode1 == null && pNode2 == null) {
            return true;
        }
        if (pNode1 == null || pNode2 == null) {
            return false;
        }
        if (pNode1.val == pNode2.val) {
            return isMirrorTree(pNode1.left, pNode2.left) && isMirrorTree(pNode1.right, pNode2.right);
        }
        return false;
    }
    
}