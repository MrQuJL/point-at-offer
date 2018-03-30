import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 题目名称：把数组排成最小的数
 * 题目描述：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution {
    /**
     * 思路：
     * 1.将数组中的数全部存入集合中
     * 2.对集合进行排序
     */
    public String PrintMinNumber(int [] numbers) {
        // 1.将数组中的数全部存入集合中
        ArrayList<Integer> list = new ArrayList<Integer>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        // 2.对集合中的数组排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            // 返回1表示o1大于o2
            // 返回0表示o1等于o2
            // 返回-1表示o1小于o2
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
                // 如果 s1 大于 s2 就返回 1，返回 1 就表示升序排列(规定,详见jdk源码)，就交换 o1 和 o2
            }
        });
        // 3.拼接排好序的数组
        StringBuffer buffer = new StringBuffer();
        for (Integer num : list) {
            buffer.append(num);
        }
        return buffer.toString();
    }
    
}