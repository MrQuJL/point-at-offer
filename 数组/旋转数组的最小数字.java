import java.util.ArrayList;

/**
 * 题目名称：旋转数组的最小数字
 * 题目描述：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution {
    
    /**
     * 思路：
     * 类似二分查找，需要考虑三种情况：
     * 1.array[mid] > array[high]，那么最小的数字一定在 mid 的右边
     * low = mid + 1
     * 例：[3,4,5,6,0,1,2]
     *
     * 2.array[mid] == array[high]，不好判断，只好一个一个判断
     * high = high - 1
     * 例：[1,0,1,1,1] 或者[1,1,1,0,1]
     *
     * 3.array[mid] < array[high]，那么最小的数字要么是它自己，要么在它左边
     * high = mid
     * 例：[2,2,3,4,5,6,6]
	 *
	 * 考察：能否对二分查找进行灵活的变通从而解决问题
     */
    public int minNumberInRotateArray(int [] array) {
        // 合法性判断
        if (array == null || array.length == 0) {
            return 0;
        }
        // 定义 low 和 high 来限定查找范围
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            } else { // 如果相等的情况算法的时间复杂度就会退化到O(n)
                high = high - 1;
            }
        }
        return array[low];
    }
    
}