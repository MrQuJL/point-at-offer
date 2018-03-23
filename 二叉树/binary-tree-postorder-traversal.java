import java.util.ArrayList;
import java.util.LinkedList;
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
 * 题目名称：binary-tree-postorder-traversal
 * 题目描述：请完成二叉树的后序非递归遍历
 */
public class Solution {
    /**
     * 思路：
     * 要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。
     * 如果P不存在左孩子和右孩子，则可以直接访问它；或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。
     * 若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了每次取栈顶元素的时候，左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        // 记录栈的弹出节点
        TreeNode preNode = null;
        TreeNode currNode = null;
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            currNode = stack.getFirst();
            // 如果当前节点是叶子节点或者当前节点存在左孩子或者右孩子，但是左孩子和右孩子都已经访问过了
            if((currNode.left == null && currNode.right == null) || 
                (preNode != null && (preNode == currNode.left || preNode == currNode.right))) {
                // 将当前节点添加到集合
                list.add(stack.removeFirst().val);
                preNode = currNode;
            } else {
                if (currNode.right != null) {
                    stack.addFirst(currNode.right);
                }
                if (currNode.left != null) {
                    stack.addFirst(currNode.left);
                }
            }
        }
        return list;
    }
}