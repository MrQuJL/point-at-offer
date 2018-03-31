import java.util.List;
import java.util.ArrayList;

/**
 * 题目名称：和为S的连续正数序列
 * 题目描述：小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述：输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Solution {

    /**
     * 思路：
     * 1.定义两个头尾指针，头指针指向1，为指针指向2
     * 2.计算两个指针范围内的数字的和
     * 3.若数字大于sum，就让头指针+1
     * 4.若数字小于sum，就让尾指针+1
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > sequences = new ArrayList<ArrayList<Integer> >();
        if (sum < 1) {
            return sequences;
        }
        int small = 1;
        int big = 2;
        while (small * 2 < sum && small < big) {
            // 若范围内的和大于sum，则缩小范围，让small++
            if (getSumOfRange(small, big) > sum) {
                small++;
            // 若范围内的和小于sum，则扩大范围，big++
            } else if (getSumOfRange(small, big) < sum) {
                big++;
            } else {
                // 找到一个序列
                sequences.add(getListOfRange(small, big));
                // 这里big++或者small++都可以，总之就是扩大序列的范围
                big++;
            }
        }
        return sequences;
    }
    
    /**
     * 计算start到end范围内数字的和
     */
    public int getSumOfRange(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
    
    /**
     * 获取start到end范围内的序列
     */
    public ArrayList<Integer> getListOfRange(int start, int end) {
        ArrayList<Integer> sequence = new ArrayList<Integer>(end - start + 1);
        for (int i = start; i <= end; i++) {
            sequence.add(i);
        }
        return sequence;
    }
    
}