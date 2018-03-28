package com.qjl.sort;

/**
 * 题目名称：实现归并排序
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = {8, 9, 7, 6, 5, 4, 3, 2, 1, 99};
        mergeSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * 归并排序
     * 
     * 特点：
     * 归并排序是一种稳定(假设a，b相等，那么排序前a在b的前面，排序后a仍在b的前面)的排序
     * 速度仅次于快速排序，一般用于对总体无序，但是对各个子项相对有序的数列
     * 时间复杂度O(nlogn)
     * 空间复杂度O(n)
     * 
     * 适用场景：
     * 数据规模较大，要求稳定，且内存空间允许，关键码分布可能正序或逆序建议用归并排序
     * 
     * @param array
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            // 把大数组拆分成左右两部分
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            // 对这两部分进行归并排序
            merge(array, left, middle, right);
        }
    }

    public static void merge(int[] array, int left, int middle, int right) {
        int[] tempArr = new int[array.length];
        int mid = middle + 1; // 右边数组的起始位置
        int temp = left; // 在临时数组中遍历需要用到的指针
        int copyIndex = left; // 从临时数组复制回原数组中用到的指针
        // 从左右两部分中选取较小的数放入临时数组
        while (left <= middle && mid <= right) {
            if (array[left] <= array[mid]) {
                tempArr[temp++] = array[left++];
            } else {
                tempArr[temp++] = array[mid++];
            }
        }
        // 把左边剩余的部分放入临时数组
        while (left <= middle) {
            tempArr[temp++] = array[left++];
        }
        // 把右边剩余的部分放入临时数组
        while (mid <= right) {
            tempArr[temp++] = array[mid++];
        }
        // 把临时数组中的数据拷贝回原数组
        while (copyIndex <= right) {
            array[copyIndex] = tempArr[copyIndex++];
        }
    }
    
}
