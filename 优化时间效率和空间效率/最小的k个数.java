import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * 题目名称：最小的k个数
 * 题目描述：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Solution {

   /**
    * 思路：
    * 创建一个大小为K的数组，如果数组中数字的个数未满，则向里面添加数字。
    * 如果个数已满，则判断数组中最大的那个数是否大于大于当前要插入的数。
    * 如果大于当前要插入的数字，则从数组中移除那个最大的数，然后插入当前数字
    * 
    * 这种数据结构显然是堆的功能，java中已经实现了这种数据结构 -- PriorityQueue
    * PriorityQueue默认实现是一个小根堆，如果想改为大根堆则需要传入比较器Comparator重写排序规则
    */
   public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
       ArrayList<Integer> result = new ArrayList<Integer>();
       // 合法性判断
       if (input == null || k > input.length || k < 1) {
           return result;
       }
       // 创建一个大根堆
       PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
           @Override
           public int compare(Integer o1, Integer o2) {
               return o2.compareTo(o1);
           }
       });

       // 遍历数组
       for (int i = 0; i < input.length; i++) {
           if (maxHeap.size() < k) { // 容器不满就继续添加
               maxHeap.offer(input[i]);
           } else if (maxHeap.peek() > input[i]) { // 容器满了就检查最大的值是否大于当前要插入的值
               maxHeap.poll();
               maxHeap.offer(input[i]);
           }
       }
       for (int i = 0; i < k; i++) {
           result.add(maxHeap.poll());
       }

       return result;
    }
    
}