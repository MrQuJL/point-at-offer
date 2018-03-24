package com.lyu.shopping.test;

/**
 * 题目名称：实现堆排序
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = {8, 9, 7, 6, 5, 4, 3, 2, 1, 99};
        heapSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * 堆排序
     * 
     * 特点：
     * 堆排序是一种选择排序
     * 堆排序是一种不稳定(假设a，b相等，那么排序前a在b的前面，排序后a可能在b的后面)的排序
     * 堆排序利用树形结构保留了部分比较结果，减少了比较次数
     * 时间复杂度O(nlogn)
     * 空间复杂度O(1)
     * 
     * 适用场景：
     * 数据规模较大，对稳定性不做要求时建议使用堆排序，对稳定性有要求建议使用归并排序
     * 只要求出最小（大）的前几个记录，建议使用堆排序或选择排序
     * 
     * @param array
     */
    public static void heapSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            // 1.循环建堆
            buildMaxHeap(array, array.length - 1 - i);
            // 2.交换堆顶和最后一个元素
            swap(array, 0, array.length - 1 - i);
        }
    }
    
    /**
     * 建大根堆，每次找到一个最大的元素放到array[0]的位置
     * @param array 建堆的数组
     * @param lastIndex 建堆的范围上限
     */
    private static void buildMaxHeap(int[] array, int lastIndex) {
        if (array == null || array.length == 0 || lastIndex < 0) {
            return ;
        }
        // 从最后一个节点的父节点开始查找
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // 记录当前节点
            int k = i;
            // 判断当前节点是否存在至少一个左叶子节点
            while (k * 2 + 1 <= lastIndex) {
                // 保留叶子节点中最大的节点
                int biggerIndex = k * 2 + 1;
                // 判断当前节点是否存在右叶
                if (biggerIndex < lastIndex) {
                    // 判断两个叶子节点哪个大
                    if (array[biggerIndex] < array[biggerIndex + 1]) {
                        biggerIndex++;
                    }
                }
                // 判断当前节点和它较大的那个叶子节点哪个值大
                if (array[biggerIndex] > array[k]) {
                    swap(array, biggerIndex, k);
                    // 递归的判断交换后的这个节点是否有子节点
                    k = biggerIndex;
                } else {
                    break;
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
