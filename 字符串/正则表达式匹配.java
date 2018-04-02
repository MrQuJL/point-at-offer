import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 题目名称：正则表达式匹配
 * 题目描述：请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution {
    /**
     * 思路：
     * 使用一下 String 的 matches 的底层原理 --> Pattern + Matcher
     */
    public boolean match(char[] str, char[] pattern) {
        // 1.把规则编译成Pattern对象
        Pattern pa = Pattern.compile(new String(pattern));
        // 2.调用Pattern的matcher方法把一个字符串封装成匹配器对象
        Matcher m = pa.matcher(new String(str));
        // 3.这里其实可以看出 String 的 matches 方法其实就是调用的 Matcher 的 matches 方法
        return m.matches();
    }
}