/**
 * 题目名称：实现直接选择排序
 * 题目描述:请在30秒之内实现直接选择排序
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = {8, 9, 7, 6, 5, 4, 3, 2, 1, 99};
        selectSort(a);
        for (int i : a) {
            System.out.println(i);
        }

    }

    /**
     * 直接选择排序
     * 
     * 特点：
     * 直接选择排序是一种选择排序
     * 直接选择排序是一种不稳定(假设a，b相等，那么排序前a在b的前面，排序后a仍然在b的前面)的排序
     * 时间复杂度为O(n2)
     * 空间复杂度为O(1)
     * 
     * 适用场景：
     * 数据规模较小，对稳定性不作要求建议使用选择排序，对稳定性有要求建议冒泡或者插入排序
     * 
     * @param array 待排序的数组
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            array[minIndex] = array[i];
            array[i] = min;
        }
    }
    
    /**
     * 交换数组中的两个数
     * @param array 需要交换数值的数组
     * @param i 被交换的数
     * @param j 被交换的数
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
}
