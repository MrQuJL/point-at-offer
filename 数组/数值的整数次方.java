
/**
 * 题目名称：数值的整数次方
 * 题目描述：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Solution {

    /**
     * 考察思维的严谨性
     * 这里注意几点：
     * 1.指数为负数的情况
     * 2.指数为负数并且底数为0的情况
     * 3.0的0次方的情况
     * 4.判断两个小数是否相等只能判断它们只差的绝对值是不是在一个很小的范围内
     * 5.用左移运算代替乘以2，用右移运算代替除以2
     * 6.用位运算代替求余运算（%）来判断一个数是奇数还是偶数   if ((exponent & 0x1) == 1)奇数
     */
    public double Power(double base, int exponent) {
        // 考虑底数为0的情况
        if (equals(base, 0.0)) {
            return 0.0;
        }
        // 考虑指数为0的情况
        if (exponent == 0) {
            return 1;
        }
        double result = 0.0;
        int absExponent = exponent;
        // 考虑指数为负数的情况
        if (exponent < 0) {
            absExponent = -exponent;
        }
        
        result = powerWithUnsignedExponent(base, absExponent);
        // 如果指数为负数，最后的结果还要用1.0除一下
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }
    
    /**
     * 计算base的exponent次方，其中exponent恒大于0
     */
    public double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        // 递归的把这base的exponent次方拆分成两次base的exponent/2次方
        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        // 如果是奇数还要再乘一次base
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }
    
    /**
     * 不能直接用 "==" 来判断两个 double 类型的数值
     * 因为用浮点数表示的数值精度上有一定的误差
     */
    public boolean equals(double num1, double num2) {
        if (num1 - num2 > -0.0000001 && num1 - num2 < 0.0000001) {
            return true;
        }
        return false;
    }
    
}