import java.util.Arrays;

/**
 * 题目名称：数字在排序数组中出现的次数
 * 题目描述：统计一个数字在排序数组中出现的次数。
 */
public class Solution {

    /**
     * 思路：
     * 通过二分查找法找到第一个小于该数的位置和第一个大于该数的位置相减即是该数字在排序数组中出现的次数
     * 时间复杂度O(logn)
     */
    public int GetNumberOfK(int [] array , int k) {
        int start = binarySearch(array, k - 0.5);
        int end = binarySearch(array, k + 0.5);
        return end - start;
    }

    /**
     * 二分查找法
     */
    public int binarySearch(int[] array, double key) {
        int left = 0;
        int right = array.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = (right + left) / 2;
            if (key < array[middle]) {
                right = middle - 1;
            } else if (key > array[middle]) {
                left = middle + 1;
            } else {
                break;
            }
        }
        return left;
    }
    
}