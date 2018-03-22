/**
 * 题目名称：二进制中 1 的个数
 * 题目描述：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution {
    /**
     * 思路一：
     * 使用 java 自带的库函数 bitCount 统计数值二进制表示中 1 的个数
     */
    public int NumberOf1_1(int n) {
        try {
            return Integer.bitCount(n);
        } catch (Exception e) {
            return 0;
        }
    }
    
    /**
     * 思路二：
     * 先将 int 类型的数值转换成二进制字符串
     * 将里面的 0 全部用空字符串替换
     * 剩下的字符串的长度即为 1 的个数
     */
    public int NumberOf1_2(int n) {
        try {
            return Integer.toBinaryString(n).replaceAll("0","").length();
        } catch (Exception e) {
            return 0;
        }
    }
    
    /**
     * 思路三：
     * 原理：将一个数减去 1 再与原数做与运算，就可以把原数二进制表示中最右边的一个 1 变成 0
     * 例：12 --> 1100, 11 --> 1011, 12 & 11 --> 1000 就去掉了最右边的一个 1
     * 这个数的二进制中有多少个 1 就可以进行多少次这样的运算
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n & (n - 1));
        }
        return count;
    }
    
}