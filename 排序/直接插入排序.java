
/**
 * 题目名称：实现直接插入排序
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = {8, 9, 7, 6, 5, 4, 3, 2, 1, 99};
        insertSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * 直接插入排序
     * 
     * 特点：
     * 直接插入排序是一种插入排序
     * 直接插入排序是一种稳定(假设a，b相等，那么排序前a在b的前面，排序后a仍然在b的前面)的排序
     * 时间复杂度为O(n2)
     * 空间复杂度为O(1)
     * 
     * 适用场景：
     * 数据规模较小，对稳定性有要求建议使用直接插入排序，对稳定性没有要求可以使用简单选择排序
     * 
     * @param array 待排序的数组
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
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
