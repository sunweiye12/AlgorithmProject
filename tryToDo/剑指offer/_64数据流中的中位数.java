package 剑指offer;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/*
 * 题目:如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 	如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 	我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 
 * 思路:
 */
public class _64数据流中的中位数 {
	
	@Test
	public static void main(String[] args) {
		
	}
	 
	PriorityQueue<Integer> minHeap = new  PriorityQueue<Integer>(20); //存比中位数大的元素
	PriorityQueue<Integer> maxHeap = new  PriorityQueue<Integer>(20,new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	});
	
	//加入一个元素
	public void Insert(int num){
		//维持两个堆的大小不会相差超过1(一直使maxHeap的size大于minHeap)
		//当两个堆元素相等时,新插入的value,如果它大于minHeap的最大值，把它插入到minHeap。
		//并且把minHeap的最小值移动到maxHeap。否则插入到maxHeap
		if (maxHeap.size() == minHeap.size()) {
             if (minHeap.peek() != null && num > minHeap.peek()) {
            	 minHeap.offer(num);
                 maxHeap.offer(minHeap.poll());
             } else {
                 maxHeap.offer(num);
             }
         } else {
             if (num < maxHeap.peek()) {
            	 maxHeap.offer(num);
                 minHeap.offer(maxHeap.poll());
             } else {
                 minHeap.offer(num);
             }
         }
	}
	
	//获取中位数
	public double GetMedian(){
		if (maxHeap.isEmpty()) {
		     return (double)-1; 
		}
		if (maxHeap.size() == minHeap.size()) {
			int num1 = minHeap.peek();
			int num2 = maxHeap.peek();
		     return (double)(num1 + num2)/2;
		} else {
		     return (double)maxHeap.peek();
		}
	}
}
