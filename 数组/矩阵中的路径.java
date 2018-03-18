/**
 * 题目名称：矩阵中的路径
 * 题目描述：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如：
 * a b c e
 * s f c s
 * a d e e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Solution {

    /**
     * 核心思路：优化版回溯法，参考《剑指offer》
     * 1.将matrix字符串模拟映射为一个字符矩阵(但并不实际创建一个矩阵)
     * 2.取一个boolean[matrix.length]标记某个字符是否已经被访问过。
     * 3.如果没找到结果，需要将对应的boolean标记值置回false,返回上一层进行其他分路的查找。
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        // 标记数组
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 依次从每一个点开始进行递归加回溯的遍历
                if (searchFromHere(matrix,rows,cols,i,j,0,str,visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchFromHere(char[] matrix,int rows,int cols,int r,int c,int index,char[] str,boolean[] visited){
        // 判断是否超出边界，是否经过，字符是否相等
        if (r < 0 || r >= rows || c < 0 || c >= cols || 
            matrix[r * cols + c] != str[index] || visited[r * cols + c]) {
            return false;
        }
        // 字符长度已经遍历完毕
        if (index == str.length - 1) {
            return true;
        }
        // 标记这个点已经遍历过
        visited[r * cols + c] = true;
        if (searchFromHere(matrix,rows,cols,r - 1,c,index + 1,str,visited) ||
            searchFromHere(matrix,rows,cols,r,c -1,index + 1,str,visited) ||
            searchFromHere(matrix,rows,cols,r + 1,c,index + 1,str,visited) ||
            searchFromHere(matrix,rows,cols,r,c + 1,index + 1,str,visited)) {
            return true;
        }
        // 回溯
        visited[r * cols + c] = false;
        return false;
    }
}