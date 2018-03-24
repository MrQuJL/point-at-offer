/**
 * 题目名称：孩子们的游戏（圆圈中最后剩下的数字）
 * 题目描述：每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中。
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？
 * (注：小朋友的编号是从0到n-1)
 */
public class Solution {

    /**
     * 模拟实现的一个单链表
     */
    public static class ListNode {
        int val; // 该节点保存的数值
        ListNode next; // 指向下一个节点的指针
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路：
     * 1.通过一个环形链表模拟圆圈，每次遍历到指定数值的节点时，删除该节点
     * 2.直到只剩下最后一个节点，即我们所要找的那个小孩子
     */
    public int LastRemaining_Solution(int n, int m) {
        // 合法性判断
        if (n < 1 || m < 1) {
            return -1;
        }
        
        // 1.先创建该单例表
        ListNode head = new ListNode(0);
        ListNode pHead = head;
        for (int i = 1; i < n; i++) {
            ListNode node = new ListNode(i);
            pHead.next = node;
            pHead = pHead.next;
        }
        // 因为要构成环，所以要首尾相连
        pHead.next = head;
        // 记录当前节点的前一个节点
        ListNode preNode = pHead;
        pHead = pHead.next;

        // 2.在单链表中查找
        // 记录当前报的数
        int temp = -1;
        while (pHead.next != pHead) {
            temp++;
            if (temp == m - 1) { // 命中，剔除（将当前节点前一个节点的 next 指向当前节点的下一个节点即可）
                preNode.next = pHead.next;
                temp = -1;
            }
            preNode = pHead;
            pHead = pHead.next;
        }
        return pHead.val;
    }

}