import java.util.LinkedHashMap;
import java.util.Set;

/**
 * 题目名称：第一个只出现一次的字符
 * 题目描述：在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class Solution {
    
    /**
     * 思路：
     * 遍历字符串，将字符串中每个字符以及字符出现的次数放入一个 LinkedHashMap 中，取出第一个次数为 1 的 key
     */
    public int FirstNotRepeatingChar(String str) {
        // 合法性判断
        if (str == null || str.length() == 0) {
            return -1;
        }
        char[] ch = str.toCharArray();
        // 用于存放每个字符以及它所对应到的出现的次数，用 LinkedHashMap 可以保证字符插入的次序
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])) { // 如果 map 中包含 key，就把它取出来加个 1，再存进去
                int count = map.get(ch[i]);
                map.put(ch[i], ++count);
            } else { // 如果不包含，直接存进去
                map.put(ch[i], 1);
            }
        }
        Set<Character> keySet = map.keySet();
        for (Character c : keySet) { // 遍历所有的 key，找到第一个 value 为 1 的 key，返回在字符串中对应的下标
            if (map.get(c).equals(1)) {
                return str.indexOf(c);
            }
        }
        
        return -1;
    }
}