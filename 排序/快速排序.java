
/**
 * 题目名称：实现快速排序
 */
public class Solution1 {

    public static void main(String[] args) {
        int[] array = {8, 9, 7, 6, 5, 3, 4, 2, 1};
        quick(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 思路：
     * 每次选择一个基准元素，基准元素一般选取第一个元素
     * 将所有比基准元素小的数据放到它的前面，将所有比基准元素大的数据放到它的后面
     * 
     * 快速排序的特点：
     * 快速排序是一种交换排序
     * 快速排序是不稳定的排序(假设 a 和 b 相等，排序前 a 在 b 的前面，排序后 a 就可能在 b 的后面)
     * 快速排序的时间复杂度是O(nlogn)
     * 快速排序的空间复杂度是O(1)
     * 
     * 适用场景：
     * 数据规模较大，序列杂乱无序，并且不要求稳定性的时候强烈建议使用
     * 序列基本有序的时候用快排反而不好，这时候建议使用堆排序
     * 
     * 对外提供的接口的形式：
     * 因为直接把 quickSort 暴露给上层，用户需要输入较多的参数，而且还要对应的检查输入参数的合法性，麻烦
     * 所以把 quickSort 封装成一个简单的 quick 提供给上层一个简单的接口
     * 
     * @param array 待排序的数组
     */
    public static void quick(int[] array) {
        if (array != null && array.length > 0) {
            quickSort(array, 0, array.length - 1);
        }
    }

    /**
     * 对 array 数组中 low 到 high 范围的数字进行快速排序
     * @param array 待排序的数组
     * @param low 对数组进行排序的范围的下限
     * @param high 对数组进行排序的范围的上限 
     */
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = getMiddle(array, low, high);
            quickSort(array, low, middle - 1);
            quickSort(array, middle + 1, high);
        }
    }

    /**
     * 对数组进行一趟排序，只排好一个数字，并且这个数左边的数都比它小，右边的数都比它大
     * @param array 待进行一趟排序的数组
     * @param low 对数组进行排序的范围的下限
     * @param high 对数组进行排序的范围的上限 
     * @return 返回这个已经排好了的数字的角标
     */
    private static int getMiddle(int[] array, int low, int high) {
        // 获取基准元素
        int temp = array[low];
        while (low < high) {
            // 从后往前找比基准元素小的
            while (low < high && array[high] >= temp) {
                high--;
            }
            array[low] = array[high];
            // 从前往后找比基准元素大的
            while (low < high && array[low] <= temp) {
                low++;
            }
            array[high] = array[low];
        }
        // 此次一趟排序之后便排好了一个元素，而且该元素左边的都比它小，右边的都比它大
        array[low] = temp;
        // 返回该元素的角标
        return low;
    }

}
