import java.util.Stack;

/**
 * 题目名称：用两个栈实现队列
 * 题目描述：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    /**
     * push 的时候将数据都压入 stack1
     */
    public void push(int node) {
        stack1.push(node);
    }
    
    /**
     * pop 的时候从 stack2 中 pop
     * 如果 stack2 为空，就先把 stack1 中的元素压入stack2
     * 然后在 pop stack2
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}