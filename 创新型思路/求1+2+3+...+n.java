
/**
 * 题目名称：求1+2+3+...+n
 * 题目描述：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Solution {

    /**
     * 思路1：
     * 递归，但是一般情况下递归需要使用 if else 来终止
     * 这里使用短路与的短路特性实现递归终止
     */
    public int Sum_Solution_1(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution_1(n-1)) > 0);
        return sum;
    }

    /**
     * 思路2：
     * 仍然是递归，不过这里使用捕获异常的方式来终止递归
     */
    public int Sum_Solution_2(int n) {
        try {
            int i = 1 / n;
            return n + Sum_Solution_2(n - 1);
        } catch (Exception e) {
            return 0;
        }
    }
}