/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目名称：从尾到头打印链表
 * 题目描述：输入一个链表，从尾到头打印链表每个节点的值。
 */
public class Solution {
    /**
     * 思路1：
     * 利用 LinkedList 的 addFirst 前插法直接获取从尾部到头部的遍历序列。
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        LinkedList<Integer> temp = new LinkedList<Integer>();
        ListNode pNode = listNode;
        while (pNode != null) {
            temp.addFirst(pNode.val);
            pNode = pNode.next;
        }
        return new ArrayList<Integer>(temp);
    }
    
    /**
     * 思路2：
     * 利用递归，达到到尾节点的时候才开始添加
     */
    public ArrayList<Integer> nodeList = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ListNode pNode = listNode;
        if (pNode != null) {
            printListFromTailToHead(pNode.next);
            nodeList.add(pNode.val);
        }
        return nodeList;
    }
}