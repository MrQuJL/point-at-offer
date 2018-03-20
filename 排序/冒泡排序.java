package com.lyu.shopping.test;

/**
 * 题目名称：实现冒泡排序
 * 题目描述:请在30秒之内实现冒泡排序
 */
public class Solution {
    
    public static void main(String[] args) {
        int[] a = {8, 9, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort(a, false);
        for (int i : a) {
            System.out.println(i);
        }
    }
    
    /**
     * 由小到大实现冒泡排序
     * @param array 待排序的数组
     * @param flag true则为升序，false则为降序
     */
    public static void bubbleSort (int[] array, boolean flag) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (flag && array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                } else if (!flag && array[j] < array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
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
