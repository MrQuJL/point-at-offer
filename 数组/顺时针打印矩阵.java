import java.util.ArrayList;

/**
 * 题目名称：顺时针打印矩阵
 * 题目描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution {
    
    /**
     * 思路：
     * 1.一直向右走，走到边界（超出数组范围或已经访问过）
     * 2.一直向下走，走到边界（超出数组范围或已经访问过）
     * 3.一直向左走，走到边界（超出数组范围或已经访问过）
     * 4.一直向上走，走到边界（超出数组范围或已经访问过）
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        // 定义两个坐标记录当前遍历的位置
        int x = 0, y = -1;
        int width = matrix.length;
        int height = matrix[0].length;
        byte[][] flag = new byte[width][height];
        int total = width * height;
        
        while (total-- > 0)  {
            // 1.向右走，一直走到边界处
            while (y + 1 < height && flag[x][y + 1] != 1) {
                flag[x][++y] = 1;
                list.add(matrix[x][y]);
            }
            // 2.向下走，一直走到边界处
            while (x + 1 < width && flag[x + 1][y] != 1) {
                flag[++x][y] = 1;
                list.add(matrix[x][y]);
            }
            // 3.向左走，一直走到边界处
            while (y - 1 > -1 && flag[x][y - 1] != 1) {
                flag[x][--y] = 1;
                list.add(matrix[x][y]);
            }
            // 4.向上走，一直走到边界处
            while (x - 1 > -1 && flag[x - 1][y] != 1) {
                flag[--x][y] = 1;
                list.add(matrix[x][y]);
            }
        }
        return list;
    }
}