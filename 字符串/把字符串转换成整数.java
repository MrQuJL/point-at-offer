
/**
 * 题目名称：把字符串转换成整数
 * 题目描述：将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * 
 * 输入描述：输入一个字符串,包括数字字母符号,可以为空
 * 输出描述：如果是合法的数值表达则返回该数字，否则返回0
 */
public class Solution {
    /**
     * 思路：
     * 调用Java库函数
     */
    public int StrToInt(String str) {
        int resultNum = 0;
        try {
            resultNum = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
        return resultNum;
    }
}
