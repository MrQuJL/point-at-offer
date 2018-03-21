/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * 题目名称：链表中倒数第k个节点
 * 题目描述：输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution {
    /**
     * 思路：
     * 从头到尾遍历一次链表，计算出链表共有多少个节点，假设是n个
     * 再从头遍历n-k个节点即可
     * 
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        // 合法性判断
        if (head == null || k < 1) {
            return null;
        }
        // 求出链表的长度n，并判断k是否大于链表的总长度，如果大于，说明输入参数k不合法，返回
        int n = 0;
        ListNode pHead = head;
        while (pHead != null) {
            n++;
            pHead = pHead.next;
        }
        if (k > n) {
            return null;
        }
        int step = n - k;
        pHead = head;
        // 走n-k步
        while (step-- > 0) {
            pHead = pHead.next;
        }
        
        return pHead;
    }
}