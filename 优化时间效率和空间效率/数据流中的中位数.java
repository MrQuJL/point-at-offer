import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * 题目名称：数据流中的中位数
 * 题目描述：如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Solution {
    /**
     * 思路：
     * 我们只需要排序后位于中间的两个数就可以得出中位数，当元素个数为奇数个时可以看成这两个数一样。
     * 中位数在左半部分它是最大的，右半部分是最小的。
     * 我们只要始终知道前半部分数里的最大的那个数，后半部分里那个最小的数就可以了，其他的不用关心，这明显是堆的作用。
     * 所以前半部分用一个最大堆，后半部分建一个最小堆。
     * 为了保持两个堆的数目之差不超过1.实现平均分配，可以在数据的总数目是偶数时把新数据插入到最小堆中，否则插入最大堆中。
     * 
     * 问题：
     * 另一个问题是保持最大堆的所有数据都小于最小堆中的数据。
     * 如果插入一个数使得总数目和为偶数，根据之前的原则应该插入最小堆中，但是新插入的元素可能比最大堆中的元素小怎么办？
     * 这就违反了最小堆的数据一定大于最大堆得原则。
     * 实际上这里插入的元素应该是新元素和最大堆中所有元素的最大值。
     * 最大堆正好有返回一个最大值的作用，所以新插入的元素先插入最大堆，然后取出最大值再插入最小堆中。
     * 如果插入元素使得数据总数目和为奇数，处理方法类似。
     */
    private int count = 0; // 记录数据的个数
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    
    // 个人觉得这种插入的思想有点和快排的一趟排序类似，把小的放到一边，大的放到另一边
    public void Insert(Integer num) {
        if (count %2 == 0) {// 当数据总数为偶数时，新加入的元素先加入大根堆获取其中的最大值，再把这个最大值插入小根堆
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        } else {//当数据总数为奇数时，新加入的元素先加入小根堆获取其中的最小值，在把这个最小值插入大根堆
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    public Double GetMedian() {
        if (count %2 == 0) { // 偶数时各取大根堆的最大值和小根堆的最小值，也就是两个中位数/2
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else { // 奇数时，就取小根堆中的最小值
            return new Double(minHeap.peek());
        }
    }
}