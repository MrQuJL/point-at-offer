
/**
 * 题目名称：二叉搜索树的后序遍历序列
 * 题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution {

    /**
     * 思路：
     * 1.确定BST的左右子树的范围
     * 2.如果左子树中有大于根节点的值返回false
     * 3.如果右子树中有小于根节点的值返回false
     * 4.递归的判断每个左右子树是否是BST
     */
    public boolean VerifySquenceOfBST1(int [] sequence) {
        // 合法性判断
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int root = sequence[sequence.length - 1];
        // 1.确定左右子树的分界点
        int i = 0;
        for (; i < sequence.length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        // 2.判断右子树中是否小于根节点的节点
        // ps:因为在确定左右子树分界点的时候就已经确定左子树中一定没有比根节点大的值，所以就没有必要再判断左子树了
        int j = i;
        for (; j < sequence.length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        // 3.递归的判断左子树
        boolean left = true;
        if (i > 0) {
            int[] lchild = new int[i];
            for (int temp = 0; temp < i; temp++) {
                lchild[temp] = sequence[temp];
            }
            left = VerifySquenceOfBST(lchild);
        }
        
        // 4.递归的判断右子树
        boolean right = true;
        if (j < sequence.length - 1) {
            int[] rchild = new int[sequence.length - i];
            for (int temp = i; temp < j + 1; temp++) {
                rchild[temp] = sequence[temp];
            }
            right = VerifySquenceOfBST(rchild);
        }
        
        return left && right;
    }
    
    /**
     * 思路2：
     * 非递归解法，利用左子树的所有值都比根节点小
     * 右子树的所有值都比根节点大的特性
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int size = sequence.length;
        int i = 0;
        while (--size != 0) {
            while (sequence[i] < sequence[size])i++;
            while (sequence[i] > sequence[size])i++;
            if (i < size) {
                return false;
            }
            i = 0;
        }
        return true;
    }
    
}