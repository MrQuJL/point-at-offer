
/**
 * 题目名称：连续子数组的最大和
 * 题目描述：HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Solution {
    
    /**
     * 思路：
     * 1.遍历数组累加各项的和
     * 2.如果累加的和是负数，就要抛弃之前的累加和
     * 3.累加的过程中保留当前最大的子数组的和
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        // 合法性判断
        if (array == null || array.length == 0) {
            return 0;
        }
        int tempSum = 0;
        int maxSum = Integer.MIN_VALUE; // int类型的最小值
        for (int i = 0; i < array.length; i++) {
            if (tempSum < 0) { // 1.如果之前的累加和小于0，就抛弃掉之前的累加和
                tempSum = 0;
            }
            tempSum += array[i]; // 2.累加统计子数组的和
            if (tempSum > maxSum) { // 3.如果加上当前数字的累加和大于最大子数组和就记录下这个和
                maxSum = tempSum;
            }
        }
        return maxSum;
    }
}