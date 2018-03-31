import java.util.LinkedList;
import java.util.ArrayList;

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
 * 题目名称：二叉搜索树的第k个结点
 * 题目描述：给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class Solution {
    /**
     * 思路：
     * 通过中序遍历所有的节点，放入list中，获得第k个节点
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        // 合法性判断，0为非法输入
        if (k <= 0) {
            return null;
        }
        // 使用LinkedList模拟一个栈
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        // 记录头节点
        TreeNode pHead = pRoot;
        // 用于保存临时节点
        TreeNode temp = null;
        // 保存中序遍历序列后的元素
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();

        while (pHead != null || !stack.isEmpty()) {
            if (pHead != null) {
                stack.addFirst(pHead);
                pHead = pHead.left;
            } else {
                temp = stack.removeFirst();
                list.add(temp);
                pHead = temp.right;
            }
        }
        // 如果当前二叉搜索树没有k个节点则返回null
        if (list.size() < k) {
            return null;
        }
        return list.get(k - 1);
    }
}