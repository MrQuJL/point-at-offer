
/**
 * 题目名称：实现二分法插入排序
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
     * 二分法插入排序
     * 
     * 特点：
     * 二分法插入排序是一种插入排序
     * 二分法插入排序是一种稳定(假设a，b相等，那么排序前a在b的前面，排序后a仍然在b的前面)的排序
     * 最好的情况下时间复杂度为O(n)
     * 最坏的情况下时间复杂度为O(n2/2)
     * 平均时间复杂度O(n2)
     * 空间复杂度为O(1)
     * 
     * 适用场景：
     * 数据规模较小，对稳定性有要求建议使用二分法插入排序，对稳定性没有要求可以使用简单选择排序
     * 
     * @param array 待排序的数组
     */
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int left = 0; // 记录待插入的位置
            int right = i - 1;
            int mid = 0;
            // 通过二分法找到待插入元素的位置
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp > array[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // 从left元素起依次后移到i的位置
            for (int j = i - 1; j >= left; j--) {
                array[j + 1] = array[j];
            }
            // left == i就说明该元素所处的位置就是排序后的位置
            if (left != i) {
                array[left] = temp;
            }
        }
    }
}
