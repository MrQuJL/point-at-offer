
/**
 * 题目名称：不用加减乘除做加法
 * 题目描述：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Solution {
    /**
     * 思路：
     * 1.各位相加但不进位 --> 异或的效果
     * 2.记下进位 --> 两个数先做位与再向左移动一位
     * 3.把前两步的结果相加
     */
    public int Add(int num1,int num2) {
        int sum, carry;
        while (num2 != 0) {
            sum = num1 ^ num2; // 异或相当于每一位相加，而不考虑进位
            carry = (num1 & num2) << 1; // 两个数相与，并左移一位，相当于求得进位
            num1 = sum;
            num2 = carry; // 为0表示没有进位了，返回num1即可
        }
        return num1;
    }
}