import java.util.ArrayList;

/**
 * 题目名称：构建乘积数组
 * 题目描述：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1]。
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Solution {

    /**
     * 思路：
     * 1.以B0,B1,B2,...,Bn-1为纵轴画出一个矩阵，如图：
     * https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46
     * 2.先连乘下三角再把上三角连乘进去即可
     */
    public int[] multiply(int[] A) {
        // 合法性判断
        if (A == null || A.length == 0) {
            return null;
        }
        
        int[] b = new int[A.length];
        b[0] = 1;
        int temp = 1;
        // 求出下三角
        for (int i = 1; i < b.length; i++) {
            b[i] = temp * A[i - 1];
            temp = b[i];
        }
        // 求上三角
        temp = 1;
        for (int i = b.length - 2; i >= 0; i--) {
            temp = temp * A[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}