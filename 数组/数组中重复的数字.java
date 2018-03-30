
/**
 * 题目名称：数组中重复的数字
 * 题目描述：在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。
 * 请找出数组中第一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 把这第一个重复的数字通过duplication[0]来传出
 */
public class Solution {

    /**
     * 思路1：
     * 利用一个标记数组，当一个数字被访问过后就设为true
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean[] flag = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (flag[numbers[i]] == true) { // 被访问过
                duplication[0] = numbers[i];
                return true;
            }
            flag[numbers[i]] = true;
        }
        return false;
    }
    
    /**
     * 思路2：
     * 不需要申请额外的 O(n) 的空间的数组来进行标记
     * 题目说了数组中所有数字的范围都在 0 到 n-1 范围内
     * 当一个数字被访问过后，设置对应位数上的数+length
     * 之后再遇到相同的数时，发现值大于length，直接返回这个数即可
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            // 为了防止数组角标越界，大于等于length的数要减去length
            if (index >= length) {
                index -= length;
            }
            // 如果对应位数上的值大于等于length说明这个下标已经被访问过了，返回即可
            if (numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] += length;
        }
        return false;
    }

}