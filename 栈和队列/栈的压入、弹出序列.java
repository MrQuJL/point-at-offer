import java.util.LinkedList;

/**
 * 题目名称：栈的压入、弹出序列
 * 题目描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Solution {
    
    /**
     * 思路：
     * 1.借助一个辅助栈，每次先将pushA序列中的一个元素压入栈中
     * 2.然后循环判断辅助栈栈中的栈顶元素是否和popIndex所指向的popA中的元素相等
     * 3.相等则辅助栈栈顶元素出栈，指针后移
     * 4.不相等继续压栈，直到pushA已经为空
     * 5.最后若栈中没有元素则说明popA就是pushA的弹出序列，否则不是
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        // 合法性判断
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 ||
            pushA.length != popA.length) {
            return false;
        }
        // 定义一个辅助栈
        LinkedList<Integer> stack = new LinkedList<Integer>();
        // 用于标示弹出序列的位置
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.addFirst(pushA[i]);
            // 辅助栈不空，并且栈顶元素等于popIndex指向的弹出序列的那个元素，那么就将栈中的该元素出栈，指针后移
            while (!stack.isEmpty() && stack.getFirst() == popA[popIndex]) {
                stack.removeFirst();
                popIndex++;
            }
        }
        // 如果栈是空的说明popA为pushA的弹出序列
        return stack.isEmpty();
    }
    
}