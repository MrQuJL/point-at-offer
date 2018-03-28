package com.qjl.sort;

/**
 * 题目名称：实现希尔排序
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = {8, 9, 7, 6, 5, 4, 3, 2, 1, 99};
        shellSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * 希尔排序
     * 
     * 特点：
     * 希尔排序是一种插入排序
     * 希尔排序是一种不稳定(假设a，b相等，那么排序前a在b的前面，排序后a就可能在b的后面)的排序
     * 希尔排序开始时组数较多，每组记录数较少，所以组内直接插入排序较快
     * 后来组数减少，各组记录数逐渐增读到，但由于之前各组内已经排过序了，所以组内相对有序，所以一趟排序也较快
     * 
     * 最坏的情况下时间复杂度为O(n2)
     * 平均时间复杂度O(nlogn)
     * 空间复杂度为O(1)
     * 
     * 适用场景：
     * 组内相对有序，不要求稳定性
     * 
     * @param array 待排序的数组
     */
    public static void shellSort(int[] array) {
        int d = array.length;
        while (true) {
            d = d / 2; // 增量，每组内记录之间的间隔，组数
            for (int x = 0; x < d; x++) {
                // 开始在每组内进行直接插入排序
                for (int i = x + d; i < array.length; i = i + d) {
                    int temp = array[i];
                    int j;
                    for (j = i - d; j >= 0 && array[j] > temp; j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
            // 增量为1，也就是组内间隔为1，也就是只有一组时，跳出循环
            if (d == 1) {
                break;
            }
        }
    }
}
