/**
 * 题目名称：调整数组顺序使奇数位于偶数前面
 * 题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变（稳定）
 */
public class Solution {
    /**
     * 思路一：
     * 类似冒泡排序，前偶后奇就交换
     */
    public void reOrderArray(int[] array) {
        // 合法性判断
        if (array == null || array.length == 0) {
            return;
        }
        
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if ((array[j] & 0x1) == 1 && (array[j - 1] & 0x1) == 0) { // 前偶后奇就交换
                    swap(array, j, j - 1);
                }
            }
        }
    }
    
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    
}