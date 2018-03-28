package com.qjl.sort;

import java.util.List;
import java.util.ArrayList;

/**
 * 题目名称：实现基数排序
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = {8, 9, 7, 6, 5, 4, 3, 2, 1, 99};
        baseSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * 基数排序
     * 
     * 特点：
     * 基数排序是一种稳定(假设a，b相等，那么排序前a在b的前面，排序后a仍然在b的前面)的排序
     * 将所有带比较的数值（正整数）统一为同样的位数长度，位数较短的前面补0。然后从最低位开始，
     * 依次进行依次排序，这样从最低位排序一直到最高位排序完成后，就变成一个有序序列
     * 
     * 时间复杂度为O(d(n+r)) d为位数，r为基数，n为关键字个数
     * 
     * 适用场景：
     * 知道了记录值的范围，采用基数排序
     * 
     * @param array 待排序的数组
     */
    public static void baseSort(int[] array) {
        // 1.找到最大数，确定要排序几趟
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        // 2.判断位数
        int times = 0;
        while (max > 0) {
            max /= 10;
            times++;
        }
        // 3.建立十个队列
        List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> node = new ArrayList<Integer>();
            queue.add(node);
        }
        // 4.进行times次分配和收集
        for (int i = 0; i < times; i++) {
            // 分配
            for (int j = 0; j < array.length; j++) {
                // 把某位数字都相同的放到同一个队列内
                int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(array[j]);
                queue.set(x, queue2);
            }
            // 收集
            int count = 0;
            for (int j = 0; j < 10; j++) {
                while (queue.get(j).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(j);
                    array[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
    }
}
