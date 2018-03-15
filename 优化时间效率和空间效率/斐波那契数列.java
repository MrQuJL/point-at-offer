/**
 * 题目名称：斐波那契数列
 * 题目描述：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 */
public class Solution {
    /**
     * 思路：用两个变量来记录中间过程的叠加值
     */
    public int Fibonacci(int n) {
        // 合法性判断
        if (n < 1) {
            return 0;
        }
        // 前两项都是1
        if (n < 3) {
            return 1;
        }
        int fibFirst = 1;
        int fibSecond = 1;
        int fib = 0;
        for (int i = 2; i < n; i++) {
            fib = fibFirst + fibSecond;
            fibFirst = fibSecond;
            fibSecond = fib;
        }
        return fib;
    }
}