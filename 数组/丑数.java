
/**
 * 题目名称：丑数
 * 题目描述：把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Solution {

    /**
     * 思路：
     * 一次性的计算出前N个丑数，而不是从1~1000000..一个一个去判断每个数是不是丑数
     */
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        int[] ugly = new int[index];
        ugly[0] = 1;
        // 用于存放现有丑数的位置
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++) {
            // 找出已有丑数中乘上2,3,5后最小的那个丑数（保证了顺序）
            ugly[i] = Math.min(ugly[t2] * 2, Math.min(ugly[t3] * 3, ugly[t5] * 5));
            // 找出到底是2,3,5中哪个种子计算出的ugly[i]。
            // 当然，有可能有多个种子，比如ugly[num_2]*2 == ugly[num_3]*3时，需要把num_2++，并且要使num_3++。
            // 因此这里不能使用if-else，要全部使用if进行判断
            if (ugly[i] == ugly[t2] * 2) t2++;
            if (ugly[i] == ugly[t3] * 3) t3++;
            if (ugly[i] == ugly[t5] * 5) t5++;
        }
        return ugly[index - 1];
    }

}