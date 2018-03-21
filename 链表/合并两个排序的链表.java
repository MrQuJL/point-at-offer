/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    /**
     * 思路1：
     * 递归
     */
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        
        ListNode pa = list1;
        ListNode pb = list2;
        ListNode pHead = null;
        if (list1.val <= list2.val) {
            pHead = list1;
            pHead.next = Merge(list1.next, list2);
        } else {
            pHead = list2;
            pHead.next = Merge(list2.next, list1);
        }
        
        return pHead;
    }
    
    /**
     * 思路二：
     * 非递归
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        
        ListNode pa = list1;
        ListNode pb = list2;
        ListNode pHead = new ListNode(-1);
		ListNode pc = pHead;
        while (pa != null && pb != null) {
            if (pa.val <= pb.val) {
                pHead.next = pa;
                pHead = pa;
                pa = pa.next;
            } else {
                pHead.next = pb;
                pHead = pb;
                pb = pb.next;
            }
        }
        pHead.next = pa == null ? pb : pa;
        
        return pc.next;
    }
}