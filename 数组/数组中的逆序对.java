
/**
 * 题目名称：数组中的逆序对
 * 题目描述：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class Solution {
        
    public int inverseCount = 0;
    
    /**
     * 思路：
     * 其实就是个归并排序，在排序的过程中统计出有多少个逆序对即可。
     * 代码相比于归并排序只多了44,45两行
     */
    public int InversePairs(int [] array) {
        // 如果把创建临时数组的动作放到递归函数内部，会导致时间复杂度过大
        int[] temp = new int[array.length];
        // 归并排序
        mergeSort(array, temp, 0, array.length - 1);
        return inverseCount;
    }
    
    public void mergeSort(int[] array, int[] temp, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, temp, low, middle);
            mergeSort(array, temp, middle + 1, high);
            merge(array, temp, low, middle, high);
        }
    }
    
    public void merge(int[] array, int[] temp, int low, int middle, int high) {
        int mid = middle + 1;
        int tempIndex = low;
        int copyIndex = low;
        
        while (low <= middle && mid <= high) {
            if (array[low] <= array[mid]) {
                temp[tempIndex++] = array[low++];
            } else {
                temp[tempIndex++] = array[mid++];
                inverseCount += middle - low + 1; // 核心，
                inverseCount %= 1000000007; // 防止逆序对过大溢出
            }
        }
        
        while (low <= middle) {
            temp[tempIndex++] = array[low++];
        }
        
        while (mid <= high) {
            temp[tempIndex++] = array[mid++];
        }
        
        while (copyIndex <= high) {
            array[copyIndex] = temp[copyIndex++];
        }
    }
}