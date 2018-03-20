/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
/**
 * 题目名称：删除链表中重复的节点
 * 题目描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution {
    /**
     * 思路：
     * 1.加一个头结点
     * 2.定义两个指针，分别指向头结点和原链表中的头节点
     * 3.找前后不同的节点
     */
    public static ListNode deleteDuplication(ListNode pHead) {
         
        ListNode first = new ListNode(-1); // 增加一个头指针
 
        first.next = pHead;
        ListNode p = pHead;
        ListNode last = first;
        
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                // 当找到一对相同的节点后继续循环向后查找是否还有相同的节点
                // 直至链表末尾或者遇到第一个不同的节点
                while (p != null && p.val == val)
                    p = p.next;
                // last在不停的移动，first不动
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }
}