import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目名称：字符流中第一个不重复的字符
 * 题目描述：请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述：
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Solution {

    /**
     * 思路：
     * 使用LinkedHashMap可以保证数据存入的有序性
     */
    public LinkedHashMap<Character, Integer> charCounts = new LinkedHashMap<Character, Integer>();
    
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (charCounts.containsKey(ch)) {
            charCounts.put(ch, charCounts.get(ch) + 1);
        } else {
            charCounts.put(ch, 1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return '#';
    }
}