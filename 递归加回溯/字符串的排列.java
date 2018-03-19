import java.util.ArrayList;
import java.util.Collections;
/**
 * 题目名称：字符串换的排列
 * 题目描述：输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述：
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Solution {
    /**
     * 思路：
     * 将字符串转换成字符数组
     * 将字符数组中的每一个字符依次和后面的所有字符做交换
     */
    ArrayList<String> list = new ArrayList<String>();
    public ArrayList<String> Permutation(String str) {
        // 合法性判断
        if (str == null || str.length() == 0) return this.list;
   		// 将字符串转换成字符数组
        char[] ch = str.toCharArray();
        // 将字符数组中的每一个字符依次和后面的所有字符做交换
        permutation(ch, 0);
        // 按照字典顺序排序
        Collections.sort(list);
        return list;
    }
    
    public void permutation(char[] ch, int index) {
        if (index == ch.length - 1 && !list.contains(new String(ch))) {
            list.add(new String(ch));
        }
        // i 从 index 开始，自己本身就算一种排列
        for (int i = index; i < ch.length; i++) {
            swap(ch, index, i);
            permutation(ch, index + 1);
            swap(ch, index, i);
        }
    }
    
    public void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
    
}