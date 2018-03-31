/**
 * 题目名称：表示数值的字符串
 * 题目描述：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution {
    
    /**
     * 思路1：正则表达式
     */
    public boolean isNumeric1(char[] str) {
        String string = String.valueOf(str);
        // 强大的正则表达式
        return string.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }
    
    /**
     * 思路2：抛异常法
     */
    public boolean isNumeric(char[] str) {
        try {
            double re = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}