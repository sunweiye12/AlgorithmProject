package _03examination._1bytedance;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/*
 * 思路:
 * 用一个最大堆存放比中位数小（或等于）的元素，
 * 用一个最小堆存放比中位数大（或等于）的元素。
 * 这里关键的方法是insert()，每当要插入一个元素时，根据判断条件将它插入最大堆或是最小堆，
 * 并更新最大堆和最小堆，使得最大堆和最小堆中元素的个数之差不超过1，这样中位数就是最大堆或最小堆的堆顶元素。
 * 当最大堆和最小堆中元素个数不同（个数相差为1）时，元素个数多的那个堆的堆顶元素即为中位数；
 * 如果两者元素个数相同，那么中位数可以是最大堆和最小堆的堆顶元素的值取平均。
 * 
 */
public class _15利用堆结构来实现中位树的查找 {
	
	@Test
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		double mid = partion(arr);
		System.out.println(mid);
	}

	private static double partion(int[] arr) {
		if(arr == null || arr.length == 0){
			return -1;
		}
		PriorityQueue<Integer> minHeap = new  PriorityQueue<Integer>(20); //存比中位数大的元素
		PriorityQueue<Integer> maxHeap = new  PriorityQueue<Integer>(20,new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		//维持两个堆的大小不会相差超过1(一直使maxHeap的size大于minHeap)
		//当两个堆元素相等时,新插入的value,如果它大于minHeap的最大值，把它插入到minHeap。
		//并且把minHeap的最小值移动到maxHeap。否则插入到maxHeap
		for (int i = 0; i < arr.length; i++) {
			if (maxHeap.size() == minHeap.size()) {
	             if (minHeap.peek() != null && arr[i] > minHeap.peek()) {
	            	 minHeap.offer(arr[i]);
	                 maxHeap.offer(minHeap.poll());
	             } else {
	                 maxHeap.offer(arr[i]);
	             }
	         } else {
	             if (arr[i] < maxHeap.peek()) {
	            	 maxHeap.offer(arr[i]);
	                 minHeap.offer(maxHeap.poll());
	             } else {
	                 minHeap.offer(arr[i]);
	             }
	         }
		}
		if (maxHeap.isEmpty()) {
		     return -1; 
		}
		if (maxHeap.size() == minHeap.size()) {
			int num1 = minHeap.peek();
			int num2 = maxHeap.peek();
		     return (double)(num1 + num2)/2;
		} else {
		     return maxHeap.peek();
		}
	}
	
	
}
