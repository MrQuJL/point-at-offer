import java.util.Stack;

/**
 * 题目名称：包含min函数的栈
 * 题目描述：定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class Solution {
    // 数据栈
    Stack<Integer> stack = new Stack<Integer>();
    // min栈
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int node) {
        stack.push(node);
        // 如果min栈为空或者min栈不为空但是min栈的栈顶元素大于当前要push的这个元素，就把这个元素也压入min栈
        if (minStack.isEmpty() || minStack.peek() > node) {
            minStack.push(node);
        // 否则，说明当前push的这个元素比min栈栈顶的元素大，则向min栈中再次压入min栈栈顶的元素保持与数据栈的同步
        } else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}