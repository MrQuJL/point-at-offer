/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

/**
 * 题目名称：两个链表的第一个公共节点
 * 题目描述：输入两个链表，找出它们的第一个公共结点。
 */
public class Solution {
    
    /**
     * 思路：
     * 1.统计两个链表的长度LA,LB
     * 2.长的那个链表先走|LA-LB|步
     * 3.两个链表再一起走，第一个相同的节点即所求
	 * 
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = 0, length2 = 0, minus = 0;
        ListNode p1 = pHead1, p2 = pHead2;
        // 1.统计两个链表的长度LA,LB
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                length1++;
                p1 = p1.next;
            } 
            if (p2 != null) {
                length2++;
                p2 = p2.next;
            }
        }
        // 2.长的那个链表先走|LA-LB|步
        if (length1 > length2) {
            minus = length1 - length2;
            while (minus-- > 0) {
                pHead1 = pHead1.next;
            }
        } else {
            minus = length2 - length1;
            while (minus-- > 0) {
                pHead2 = pHead2.next;
            }
        }
        // 3.两个链表再一起走，第一个相同的节点即所求
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
}