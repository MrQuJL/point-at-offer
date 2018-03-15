import java.util.ArrayList;
import java.util.LinkedList;
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
 * 题目名称：从上往下打印二叉树
 * 题目描述： 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 考察：二叉树的广度优先遍历
 */
public class Solution {
    /**
     * 思路：用队列来保存遍历到的节点
     * 每次取出一个节点，判断它是否有左右子树，有就放入队列
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // 通过addFirst,removeLast模拟实现队列
        LinkedList<TreeNode> layer = new LinkedList<TreeNode>();
        if (root != null) {
            layer.addFirst(root);
        }
        while (!layer.isEmpty()) {
            TreeNode temp = layer.removeLast();
            result.add(temp.val);
            if (temp.left != null) {
                layer.addFirst(temp.left);
            }
            if (temp.right != null) {
                layer.addFirst(temp.right);
            }
        }
        return result;
    }
}