/**
 * 题目名称：二维数组中的查找
 * 题目描述:
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 例：
 * 1 2 8  9
 * 2 4 9  12
 * 4 7 10 13
 * 6 8 11 15
 */
public class Solution {
    /**
     * 思路：
     * 1.将目标值与右上角的数字进行比较。
     * 2.如果大于右上角的数字，说明当前这一行没有比目标值还大的数，去掉这一行。
     * 3.如果小于右上角的数字，说明这一列没有比目标值还小的数，去掉这一列。
     * 4.如果等于右上角的数字，则存在与目标值相等的数据，返回true。
     * 5.如果当前只剩下一个数，还不相等，则返回false。
     * 
     * 注：也可以与左下角的数字比较，思路类似，但是不可以与左上角和右下角的数字进行比较，思考一下为什么？
     */    
    public boolean Find(int target, int [][] array) {
        // 合法性判断
        if (array == null || array.length == 0) {
            return false;
        }
        // 右上角的坐标值
        int x = 0;
        int y = array[0].length - 1;
        // 没有超出数组的范围
        while (x < array.length && y > -1) {
            if (target == array[x][y]) {
                return true;
            } else if (target > array[x][y]) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}