
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
    public void reOrderArray1(int[] array) {
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

    /**
     * 思路二：
     * 类似直接插入排序的思想
     */
    public void reOrderArray2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if ((array[i] & 0x1) == 1) {
                int temp = array[i];
                int j;
                for (j = i - 1; j >= 0 && (array[j] & 0x1) == 0; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = temp;
            }
        }
    }

    /**
     * 思路三：
     * 类似快速排序的思想
     */
    public void reOrderArray3(int[] array) {
        int size = array.length;
        if(size == 0 || size == 1) return;
        int p = -1;
        int q = 0;
        while(q < size) {
            if ((array[q] & 1) != 0) {
                p++;
                int i = q;
                int temp = array[i];
                while(i > p) {
                    array[i] = array[i-1];
                    i--;
                }
                array[p] = temp;
            }
            q++;
        }
    }
    
    /**
     * 交换数组中的两个数
     */
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
}