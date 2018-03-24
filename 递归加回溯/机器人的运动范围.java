
/**
 * 题目名称：机器人运动范围
 * 题目描述：地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Solution {
    /**
     * 思路：
     * 递归+回溯
     * 注：递归的过程中要携带标记数组以及门限值
     */
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[] flag = new boolean[rows * cols];
        int count = moving(0, 0, rows, cols, flag, threshold);
        return count;
    }
    
    /**
     * 递归移动
     */
    public int moving(int x, int y, int rows, int cols, boolean[] flag, int threshold) {
        // 判断当前这个格子是否能到达
        if (x < 0 || x > rows - 1 || y < 0 || y > cols - 1 || bitSum(x) + bitSum(y) > threshold || flag[x * cols + y]) {
            return 0;
        }
        flag[x * cols + y] = true;
        int right = moving(x + 1, y, rows, cols, flag, threshold);
        int left = moving(x - 1, y, rows, cols, flag, threshold);
        int top = moving(x, y + 1, rows, cols, flag, threshold);
        int bottom = moving(x, y - 1, rows, cols, flag, threshold);
        return right + left + top + bottom + 1;
    }
    
    /**
     * 计算正整数的每位数字之和
     */
    public int bitSum(int num) {
        int sum = 0;
        while (num / 10 != 0) {
            sum += (num % 10);
            num /= 10;
        }
        sum += num;
        return sum;
    }
    
}