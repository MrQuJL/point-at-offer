import java.util.ArrayList;

/**
 * 题目名称：和为S的两个数字
 * 题目描述：输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Solution {
    
    /**
     * 思路：
     * 1.定义两个头尾指针，分别指向数组的头部和数组的尾部
     * 2.让指针指向的值相加
     * 3.如果和小于S，就让头指针加1
     * 4.如果和大于S，就让为指针减1
     * 5.如果和等于S，就返回这两个数
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        // 合法性判断
        if (array == null || array.length == 0) {
            return resultList;
        }
        // 定义两个头尾指针
        int start = 0;
        int end = array.length - 1;
        int tempSum = array[start] + array[end];
        while (start < end) {
            if (tempSum > sum) {
                end--;
            } else if (tempSum < sum) {
                start++;
            } else {
                resultList.add(array[start]);
                resultList.add(array[end]);
                break;
            }
            tempSum = array[start] + array[end];
        }
        return resultList;
    }
}