/**
 * 题目名称：跳台阶
 * 题目描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution {
    /**
     * 思路一：
     * 跳到 n 阶，要么是从 n-1 阶跳上来的，要么是从 n - 2 阶跳上来的
     * 运行时间：791ms
     */
    public int JumpFloor(int target) {
        if (target <= 1) {
            return 1;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
    
    /**
     * 思路二：
     * 非递归解法，用两个变量来记录中间值
     * 运行时间：15ms
     */
    public int JumpFloor1(int target) {
        if (target <= 1) {
            return 1;
        }
        int firstStep = 1;
        int secondStep = 1;
        int step = 0;
        
        for (int i = 1; i < target; i++) {
            step = firstStep + secondStep;
            secondStep = firstStep;
            firstStep = step;
        }
        return step;
    }
    
}