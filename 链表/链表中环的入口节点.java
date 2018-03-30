import java.util.HashSet;

/*
 public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    /**
     * 思路1：
     * 1.定义两个快慢指针，走的快的能追上走的慢的就说明有环
     * 2.两个指针在相遇的时候，将一个指针重新置为头节点的位置
     * 3.两个指针一起走，相遇的那个点即环的入口节点
     */
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        // 1.定义两个快慢指针，走的快的能追上走的慢的就说明有环
        ListNode pFast = pHead;
        ListNode pSlow = pHead;
        // 2.两个指针在相遇的时候，将一个指针重新置为头节点的位置
        while (pFast != null && pFast.next != null) {
            pSlow = pSlow.next;
            pFast = pFast.next.next;
            if (pFast == pSlow) {
                break;
            }
        }
        // 如果当前节点为空或者它的下一个节点为空就没有环
        if (pFast == null || pFast.next == null) {
            return null;
        }
        // 3.两个指针一起走，相遇的那个点即环的入口节点
        pFast = pHead;
        while (pFast != pSlow) {
            pFast = pFast.next;
            pSlow = pSlow.next;
        }
        return pFast;
    }
    
    /**
     * 思路2：
     * 利用HashSet不能插入相同元素的特点来寻找环的入口
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (pHead != null) {
            if (!set.add(pHead)) {
                return pHead;
            }
            pHead = pHead.next;
        }
        return null;
    }
    
}