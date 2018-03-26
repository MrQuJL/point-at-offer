/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/

/**
 * 题目名称：二叉树的下一个节点
 * 题目描述：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Solution {
    
    /**
     * 思路：
     * 1.有右子树就是右子树中最左的那个节点
     * 2.没有右子树，就找到第一个当前节点是父节点左孩子的节点
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 合法性判断
        if (pNode == null) {
            return null;
        }
        // 有右子树就是右子树中最左的那个节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        // 没有右子树，就找到第一个当前节点是父节点左孩子的节点
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}