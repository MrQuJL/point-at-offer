/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
*/
/**
 * 题目名称：序列化二叉树
 * 题目描述：请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Solution {
    
    /**
     * 序列化二叉树
     * 思路：先序遍历，空节点用"#"来表示，用逗号分隔
     */
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    
    /**
     * 反序列化二叉树
     * 思路：将字符串根据逗号分隔成一个字符串数组，如果当前遍历到的字符串是"#"，就返回null
     * 否则为该节点赋值，递归遍历左右子树
     */
    int index = -1;   //计数变量，用于反序列化时记录当前反序列化的节点
    
    TreeNode Deserialize(String str) {
        index++;
        String[] strr = str.split(",");
        TreeNode node = null;
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}