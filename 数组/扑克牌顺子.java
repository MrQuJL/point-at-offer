import java.util.Arrays;

/**
 * 题目名称：扑克牌顺子
 * 题目描述：LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
 * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
 */
public class Solution {
    
    /**
     * 思路：
     * 1.对数组排序
     * 2.统计0的个数
     * 3.将非0的数存入一个新数组
     * 4.统计非0数字之间的间隔，在统计的过程中判断是否有对子
     * 5.如果0的个数大于间隙的个数并且没有对子就可以组成顺子，否则不是
     */
    public boolean isContinuous(int [] numbers) {
        // 合法性判断
        if (numbers == null || numbers.length < 5) return false;
        
        // 1.将数组排序
        Arrays.sort(numbers);
        
        // 2.统计数组中0的个数
        int countZero = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                countZero++;
            }
        }
        
        int blank = 0;
        int nums = numbers.length - countZero;
        int[] tempArray = new int[nums];
        // 把去掉0之后的数字存入一个新的数组
        for (int i = 0, j = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) continue;
            tempArray[j++] = numbers[i];
        }
        // 3.统计排序之后相邻数字之间的空缺数
        // 记录数组中是否有对子
        boolean isDouble = false;
        for (int j = 0; j < tempArray.length; j++) {
            if (j == nums - 1) break;
            int temp = tempArray[j + 1] - tempArray[j];
            if (temp == 0) {
                isDouble = true;
                break;
            }
            if (temp > 1) {
                temp--;
                blank += temp;
            }
        }
        
        if (countZero >= blank && !isDouble) {
            return true;
        }
        return false;
    }
}