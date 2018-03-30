/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;
    RandomListNode(int label) {
        this.label = label;
    }
}
*/
/**
 * 题目名称：复杂链表的复制
 * 题目描述：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 * 返回结果为复制后复杂链表的head（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution {
    /**
     * 思路：
     * 1.遍历原链表，把创建的新节点连接在原链表每个节点的后面
     * 2.设置新节点的random的指向为原节点的下一个节点
     * 3.把整个链表拆分成两个链表
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
     */
    public RandomListNode Clone(RandomListNode pHead) {
        // 1.遍历原链表，把创建的新节点连接在原链表每个节点的后面
        cloneNodes(pHead);
        // 2.设置新节点的random的指向为原节点的下一个节点
        connectRandomNodes(pHead);
        // 3.把整个链表拆分成两个链表
        RandomListNode copyList = reconnectNodes(pHead);
        // 返回复制后的链表
        return copyList;
    }
    
    // 1.遍历原链表，把创建的新节点连接在原链表每个节点的后面
    public void cloneNodes(RandomListNode pHead) {
        while (pHead != null) {
            RandomListNode tempNode = new RandomListNode(pHead.label);
            RandomListNode next = pHead.next;
            pHead.next = tempNode;
            tempNode.next = next;
            pHead = pHead.next.next;
        }
    }
    
    // 2.设置新节点的random的指向为原节点的下一个节点
    public void connectRandomNodes(RandomListNode pHead) {
        while (pHead != null) {
            // 获取拷贝的节点
            RandomListNode copyNode = pHead.next;
            // 获取当前节点的random
            RandomListNode originRandomNode = pHead.random;
            if (originRandomNode != null) {
                copyNode.random = originRandomNode.next;
            }
            pHead = pHead.next.next;
        }
    }
    
    // 3.把整个链表拆分成两个链表
    public RandomListNode reconnectNodes(RandomListNode pHead) {
        // 建立一个trick
        RandomListNode returnNode = new RandomListNode(-1);
        RandomListNode retNode = returnNode;
        while (pHead != null) {
            returnNode.next = pHead.next;
            returnNode = returnNode.next;
            pHead.next = pHead.next.next;
            pHead = pHead.next;
        }
        return retNode.next;
    }
    
}