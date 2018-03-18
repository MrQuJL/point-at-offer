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
 * 题目名称：把二叉树打印成多行
 * 题目描述：从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution {
    /**
     * 思路：
     * 通过一个队列（通过LinkedList实现）来存储遍历到的节点
     * 定义两个变量来记录每一层的节点数
     */
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }
        // 通过保存遍历到的节点
        LinkedList<TreeNode> layer = new LinkedList<TreeNode>();
        // 用来保存每一层的节点
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        // end - star表示当前这一层还有多少个节点
        int start = 0;
        int end = 1;
        layer.addFirst(pRoot);
        while (!layer.isEmpty()) {
            TreeNode pHead = layer.removeLast();
            layerList.add(pHead.val);
            start++;
            if (pHead.left != null) {
                layer.addFirst(pHead.left);
            }
            if (pHead.right != null) {
                layer.addFirst(pHead.right);
            }
            if (start == end) {
                start = 0;
                end = layer.size();
                result.add(layerList);
                // 这里不要clear，因为clear也会把result中的数据清掉
                layerList = new ArrayList<Integer>();
            }
        }
        return result;
    }
}