import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * 题目名称：滑动窗口的最大值
 * 题目描述：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Solution {
    
    /**
     * 思路：
     * 1.通过一个大根堆来作为滑动窗口的容器
     * 2.遍历数组向容器中添加元素，当添加元素后达到size时，将堆顶元素添加到集合，并且remove掉最左端的元素
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 合法性判断
        if (num == null || num.length == 0 || size == 0 || size > num.length) {
            return list;
        }
        
        // 1.定义一个指针用于确定滑动窗口的左端的位置
        int left = 0;
        // 2.创建一个大根堆来保存滑动窗口中的值(优先级队列默认实现是一个小根堆)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(size, Comparator.reverseOrder());
        for (int i = 0; i < num.length; i++) {
            maxHeap.offer(num[i]);
            if (maxHeap.size() == size) {
                list.add(maxHeap.peek());
                maxHeap.remove(num[left++]);
            }
        }
        return list;
    }
}