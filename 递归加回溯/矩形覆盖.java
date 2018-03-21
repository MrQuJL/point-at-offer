/**
 * 题目名称：矩形覆盖
 * 题目描述：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Solution {
    /**
     * 思路：
     * 与跳台阶的思路类似，也是考察的斐波那契数列
     * 覆盖一个 2*n 的大矩形可能是从 2*(n-1) 的位置覆盖一次覆盖过来的
     * 也可能是从 2*(n-2) 的位置覆盖两次覆盖过来的
     * 
     * 运行时间：693ms
     */
    public int RectCover1(int target) {
        if (target < 1) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }
    
    /**
     * 非递归解法：
     * 运行时间：11ms
     */
    public int RectCover(int target) {
        if (target < 1) {
            return 0;
        }
        int firstStep = 1;
        int secondStep = 1;
        int step = 1;
        for (int i = 1; i < target; i++) {
            step = firstStep + secondStep;
            secondStep = firstStep;
            firstStep = step;
        }
        return step;
    }
}