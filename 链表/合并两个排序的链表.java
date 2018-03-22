/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * 题目名称：合并两个排序的链表
 * 题目描述：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution {
    /**
     * 思路1：
     * 定义两个指针在两条链表上进行遍历，在定义一个变量保存合并后链表的头节点
     * 两个指针在进行遍历的时候把小的节点作为头节点的引用，递归
     *
     * 运行时间：38ms
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
     * 添加一个伪头部，同样是定义两个指针在链表上进行遍历，把小的节点作为伪头部的next
     * 循环遍历
     *
     * 运行时间：16ms
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
        ListNode pHead = new ListNode(-1); // 添加一个伪头部
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
        // 把剩余的部分追加到pHead
        pHead.next = pa == null ? pb : pa;
        
        return pc.next;
    }
}