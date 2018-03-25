
/**
 * 题目名称：平衡二叉树
 * 题目描述：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution {
    /**
     * 思路：
     * 求一次这颗二叉树的深度，在计算深度的过程中判断是否平衡
     * ps:没有必要计算每个节点是否平衡
     */
    
    // 注意：这里有个坑，如果把isBalanced定义为静态的
    // 那么这个变量在修改为false的时候就不会再改为true了
    // 由此可见，这个判题程序对每个测试用例实例化一个对象，但是这个类只加载一次
    public boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }
    
    /**
     * 计算一颗二叉树的深度
     * 深度为左右子树深度中最深的那个数+1
     * ps：在计算的过程中就可以判断出这颗树是否平衡，避免对每个节点进行遍历，损耗性能
     */
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        
        // 在求深度的过程中判断树是否平衡
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return left > right ? left + 1 : right + 1;
    }
    
}