import java.util.HashMap;

/**
 * 题目名称：数组中出现次数超过一半的数字
 * 题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class Solution {

    /**
     * 思路：
     * 统计数组中每个数字出现的次数
     * 假设 m 是数组中出现次数最大的那个数，它出现的次数为 n
     * 如果 n 都不大于数组长度的一半，就没有数字能大于数组长度的一半，返回 0
     * 如果 n 大于数组长度的一半，就返回这个数
     *
     * 时间复杂度：O(n)
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        // 合法性判断
        if (array == null || array.length == 0) {
            return 0;
        }
        // 用来统计每个数字以及数字出现的次数
        HashMap<Integer, Integer> numCountsMap = new HashMap<Integer, Integer>();
        // 记录当前出现次数最大的数以及它出现的次数
        int maxCountNum = array[0];
        int maxCount = 1;
        // 记录数组长度
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (numCountsMap.containsKey(array[i])) { // 如果数组中存在这个数，把它取出来对应的次数加1，再存回去
                int tempCount = numCountsMap.get(array[i]);
                numCountsMap.put(array[i], ++tempCount);
                // 判断当前这个数字出现的次数是否已经超过了记录的最大值
                if (tempCount > maxCount) {
                    maxCount = tempCount;
                    maxCountNum = array[i];
                }
            } else { // 不存在这个数，直接存入
                numCountsMap.put(array[i], 1);
            }
        }
        return maxCount > length / 2 ? maxCountNum : 0;
    }

}