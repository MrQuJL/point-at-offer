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
 * 题目名称：二叉搜索树与双向链表
 * 题目描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution {
    
    /**
     * 思路：
     * 通过中序遍历，遍历到最左边的那个节点即头结点
     * 当回溯到中间的节点的时候，头节点的右即当前节点，当前节点的左即头结点
     */
    TreeNode head = null;
    TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrderTravel(pRootOfTree);
        return realHead;
    }
    
    public void inOrderTravel(TreeNode pRootOfTree) {
        if (pRootOfTree != null) {
            inOrderTravel(pRootOfTree.left);
            if (head == null) {
                head = pRootOfTree;
                realHead = pRootOfTree;
            } else {
                head.right = pRootOfTree;
                pRootOfTree.left = head;
                head = pRootOfTree;
            }
            inOrderTravel(pRootOfTree.right);
        }
    }
}