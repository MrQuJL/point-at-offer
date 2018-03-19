import java.util.ArrayList;
import java.util.LinkedList;

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
 * 题目名称：按之字形顺序打印二叉树
 * 题目描述：请实现一个函数按照之字形打印二叉树。
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution {
    /**
     * 思路：
     * 通过队列来保存遍历到的节点。
     * 用一个LinkedList来保存每一层的节点
     * 奇数层后插法插入节点
     * 偶数层前插法插入节点
     */
    // 记录当前的层数
    int index = 1;
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
        // 合法性判断
        if (pRoot == null) {
            return result;
        }
        // 模拟实现队列来保存遍历到的节点
        LinkedList<TreeNode> layer = new LinkedList<TreeNode>();
        // 保存每一层的节点
        LinkedList<Integer> layerList = new LinkedList<Integer>();
        layer.addFirst(pRoot);
        // 记录当前层的节点数
        int start = 0;
        int end = 1;
        while (!layer.isEmpty()) {
            start++;
            TreeNode pHead = layer.removeLast();
            if ((index & 0x1) == 0) { // 位运算，高效，符合条件是偶数
                layerList.addFirst(pHead.val);
            } else { // 否则是奇数
                layerList.addLast(pHead.val);
            }
            if (pHead.left != null) {
                layer.addFirst(pHead.left);
            }
            if (pHead.right != null) {
                layer.addFirst(pHead.right);
            }
            if (start == end) {
                // 到了下一层的时候再index++，而不要每添加一个节点就index++
                index++;
                start = 0;
                end = layer.size();
                result.add(new ArrayList<Integer>(layerList));
                // 这里不能clear，因为layerList中的值也被result引用
                layerList = new LinkedList<Integer>();
            }
        }
        
        return result;
    }

}