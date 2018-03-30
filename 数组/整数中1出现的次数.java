
/**
 * 题目名称：整数中1出现的次数（从1到n整数中1出现的次数）
 * 题目描述：求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class Solution {
    /**
     * 思路：
     * 对一个数除以10可以去掉这个数的个位数
     * 对一个数余10可以获得这个数的个位数
     * 循环即可统计出这个数中有多少个1
     */
    public int NumberOf1Between1AndN_Solution1(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += count1InNum(i);
        }
        return sum;
    }
    
    /**
     * 统计这个数中1出现的次数
     */
    public int count1InNum(int num) {
        int count = 0;
        while (num / 10 != 0) { // 满足条件则至少是两位
            int temp = num % 10;
            if (temp == 1) {
                count++;
            }
            num = num / 10;
        }
        if (num == 1) {
            count++;
        }
        return count;
    }
    
}