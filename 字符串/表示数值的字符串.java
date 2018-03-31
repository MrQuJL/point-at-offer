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
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        // 强大的正则表达式
        return string.matches("[+-]?[\\d]*(\\.[\\d]*)?([eE][+-]?[0-9]+)?");
        // 扩展
        // 1.(.)括号表示组，从第一组开始，\\1表示和第一组匹配的相同
        // ((A)(D(C))) 问：共有多少组？
        // 数左括号，有多少个左括号就有几组，4组
        // 从左括号开始依次是1,2,3,4组
        // 注：如果不写括号，则整个表达式就是第0组
        
        // 基础：
        // .表示0个到任意个
        // +表示1个到任意个
        // ?表示0个或1个
        
        // replace
        // 在两个参数的replace方法中要取前一个字符串中的组的时候不能使用\\1取组
        // 要用$编号取前一个参数的组
        // String temp = "15900001111";
        // String replaced = temp.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        
        // str.matches("dd")的底层其实是：
        // Pattern pattern = Pattern.compile(""); 将规则编译成pattern对象
        // Matcher matcher = pattern.matcher(""); 传入待匹配的字符串
        // boolean bool = matcher.matches(); 调用的Matcher的方法
        
        // while (matcher.find()) { // 找到就返回true，直到末尾
        //     System.out.println(matcher.start() + ":" +matcher.group() + ":" + matcher.end()); // 取找到的字符串
        // }
        
    }
    
    /**
     * 思路2：调用库函数，不是数值则抛异常返回false
     */
    public boolean isNumeric1(char[] str) {
        try {
            double re = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
}