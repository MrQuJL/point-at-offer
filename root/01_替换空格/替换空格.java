/**
 * 题目名称：替换空格
 * 题目描述：
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution {
    /**
     * 思路：
     * 1.找出旧数组中有多少个空格，算出新数组的长度 = 旧数组长度 + 2 * 空格数，创建新数组
     * 2.从后向前逐个进行拷贝
     * 3.如果遇到空格就依次赋值'0','2','%'
     * 4.否则就一个一个的复制即可
     * 5.循环结束条件两个指针都小于0
     */
    public String replaceSpace(StringBuffer str) {
        // 合法性判断
        if (str == null) {
            return null;
        }
    	// 1.算出新字符数组的长度
        String old = str.toString();
        char[] oldChar = old.toCharArray();
        int oldLength = oldChar.length;
        int blank = 0;
        for (int i = 0; i < oldLength; i++) {
            if (oldChar[i] == ' ') {
                blank++;
            }
        }
        char[] newChar = new char[oldLength + 2 * blank];
        // 2.从后向前判断赋值，O（n）
        int oldIndex = oldLength - 1;
        int newIndex = newChar.length - 1;
        while (oldIndex >=0 && newIndex >= 0) {
            if (oldChar[oldIndex] != ' ') {
                newChar[newIndex--] = oldChar[oldIndex--];
            } else {
                oldIndex--;
                newChar[newIndex--] = '0';
                newChar[newIndex--] = '2';
                newChar[newIndex--] = '%';
            }
        }
        return new String(newChar);
    }
}