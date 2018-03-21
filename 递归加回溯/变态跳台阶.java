/**
 * 题目名称：变态跳台阶
 * 题目描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution {
    /**
     * 思路1：
     * 找规律
     * 跳到 n 阶台阶，可能是直接从 n-1 阶跳上来的，也可能是直接从 n-2 阶、n-3 阶...1 阶跳上来的，
     * 所以 f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(1)。
     * 跳到 n-1 阶台阶，可能是从 n-2 阶跳上来的，也可能是直接从 n-3阶、n-4阶...1 阶跳上来的，
     * 所以 f(n-1) = f(n-2) + f(n-3) + ... + f(1)。
     * 综上所述：
     * f(n) = 2 * f(n-1)
     *
     * 这里有一张非常直观的图：
     * https://github.com/MrQuJL/point-at-offer/blob/master/递归加回溯/变态跳台阶.PNG
     * 运行时间：21ms
     */
    public int JumpFloorII(int target) {
        // 合法性判断
        if (target <= 1) {
            return 1;
        }
        return (2 * JumpFloorII(target - 1));
    }
    
    /**
     * 思路二：
     * 非递归解法，转换一下思维就可以想出
     * n = 1 --> f(n) = 1
     * n = 2 --> f(n) = 2
     * n = 3 --> f(n) = 4
     * n = 4 --> f(n) = 8
     * n = 5 --> f(n) = 16
     * ...
     * n = target --> f(n) = 2的 target-1 次方
     *
     * 运行时间：15ms
     */
    public int JumpFloorIII(int target) {
        // 合法性判断
        if (target <= 1) {
            return 1;
        }
        // 也可以这么写 return (int)Math.pow(2, target - 1)
        // 不过位运算更高效
        return (1 << target - 1);
    }
    
}