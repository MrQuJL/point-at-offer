/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * 题目名称：翻转链表
 * 题目描述：输入一个链表，反转链表后，输出链表的所有元素。
 */
public class Solution {
    /**
     * 思路：
     * 1.将当前节点的next指向它的前一个节点
     * 2.要定义一个变量来记录前一个节点
     * 3.为了防止链表断裂，还要记录当前节点的下一个节点
     */
    public ListNode ReverseList(ListNode head) {
        // 合法性判断
        if (head == null) {
            return null;
        }
        // 定义三个变量
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = null;
        while (curNode != null) {
            // 1.记录下一个节点
            nextNode = curNode.next;
            // 2.将当前节点指向它的前一个节点
            curNode.next = preNode;
            // 3.前一个节点指向当前节点
            preNode = curNode;
            // 4.当前节点指向它的下一个节点
            curNode = nextNode;
        }
        // 当前节点为空，返回它的前一个节点
        return preNode;
    }
}