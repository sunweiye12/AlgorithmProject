package 欢乐颂._09基础经典算法;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * BFPRT算法要解决的原始问题是:快速的在一个无序数组中快速得到第K小(大)的数
 * 思路1:想要从一个无序数组中得到第K大的数,让我topK问题的从一群数中查出前K大的数,因此可以用一个大小为k的堆来实现
 * 		时间复杂度为O(nlogK)
 * 
 * 思路2:可以利用快排的partition部分来做,运用荷兰国旗问题来求解,每次随机选一个数,大于他的放右面,等于的放中间,小于的放左面
 * 		最后判断等于区的下标和k的大小关系   ---> 时间复杂度趋近于O(n)
 * 
 * 思路3:采用BFPRT算法来解决
 * 	1)先将n个数没5个数一组进行划分 O(1)
 * 	2)将每组的5个数进行排序		O(n)
 * 	3)得到每组的中位数所形成的数组  O(n)
 * 	4)用递归的方式得到这个有中位数组成的新数组中的中为主T(n/5)
 *  5)用4)得到的数进行思路2中的暴力递归,用他进行划分,选择一部分进行递归T(7n/10)
 * 
 * @author Administrator
 *
 */
public class _06_BFPRT算法 {

	@Test
	public void main() {
//		int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 3, 5, 9, 7, 2, 5, 6, 9 };
//		sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
//		printArray(getMinKNumsByHeap(arr, 10));
//		System.out.println(getMinKNumsByBFPRT(arr, 4));
		
		int[] arr = { 1,2,3,4,5,6,7 };
		int min1 = getMinKNumsByBFPRT(arr, 6);
		System.out.println(min1);
		int min2 = getMinKNumsByHeap(arr, 3);
		System.out.println(min2);
	}

	//在arr数组中获得第i小的数(假设第一小的数是最小的数)
	private int getMinKNumsByHeap(int[] arr, int size) {
		//basecase
		if (size>arr.length||size<=0) {
			throw new RuntimeException("您输入的i不满足范围!!");
		}
		
		//因为要得到最小的第k个数,因此要创建一个大顶堆  (默认是创建的小顶堆,因此这里需要重写Comparator)
		PriorityQueue<Integer> heap = new PriorityQueue(1, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		//首先将arr的前i个数装到大顶堆中,形成一个容积为i的大顶堆
		for (int j = 0; j < size; j++) {
			heap.add(arr[j]);
		}
		
		//遍历arr中的剩余元素,如果元素比堆顶小就与栈顶交换,否则跳过
		for (int i = size; i < arr.length; i++) {
			if (heap.peek()>arr[i]) {
				heap.poll();
				heap.add(arr[i]);
			}
		}
		return heap.peek();
	}
	
	//通过BFPRT算法来求解---------------BFPRT-------------BFPRT-------------BFPRT-------------------
	public int getMinKNumsByBFPRT(int[] arr, int K) {
		
		return select(arr, 0, arr.length - 1, K - 1);
	}

	//真正的BFPRT过程,传入集合arr,集合中查找的起始坐标和结束坐标,还有下标为i的位置
	//在arr数组中的begin下标到end下标找到第i小的数
	public int select(int[] arr, int begin, int end, int i) {
		if (begin == end) {
			return arr[begin];
		}
		
		//过得中位数数组中的中位数
		int pivot = medianOfMedians(arr, begin, end);
		
		//利用得到的中位数进行partiton过程返回等于次数的下标(--pivotRange[0]下标的左边界--)
		int[] pivotRange = partition(arr, begin, end, pivot);
		//如果i位于等于区域所对应的下标则表示第K大的值就是此值
		if (i >= pivotRange[0] && i <= pivotRange[1]) {
			return arr[i];
		} else if (i < pivotRange[0]) {  //否则分情况递归调用
			return select(arr, begin, pivotRange[0] - 1, i);
		} else {
			return select(arr, pivotRange[1] + 1, end, i);
		}
	}

	//获得中位数数组并且返回它的中位主
	public int medianOfMedians(int[] arr, int begin, int end) {
		int num = end - begin + 1;
		int offset = num % 5 == 0 ? 0 : 1;
		//创建一个中位数集合
		int[] mArr = new int[num / 5 + offset];
		
		//将每一组的中位数放到里面
		for (int i = 0; i < mArr.length; i++) {
			int beginI = begin + i * 5;	//此小组的开始下标
			int endI = beginI + 4;		//此小组的结束下标
			insertionSort(arr, beginI, endI);//利用排序算法进行排序
			int sum = end + begin;
			int mid = (sum / 2) + (sum % 2);//返回中间下标
			mArr[i] = arr[mid];		//将中位数填到中位数数组中
		}
		
		//递归调用(跨方法),在此范围内得到中间大的那个数(即中为主)
		return select(mArr, 0, mArr.length - 1, mArr.length / 2); 
	}
	
	public void insertionSort(int[] arr, int begin, int end) {
		for (int i = begin + 1; i != end + 1; i++) {
			for (int j = i; j != begin; j--) {
				if (arr[j - 1] > arr[j]) {
					swap(arr, j - 1, j);
				} else {
					break;
				}
			}
		}
	}

	//快排的partiton过程,发那会等于pivotValue值的下标
	public int[] partition(int[] arr, int begin, int end, int pivotValue) {
		int small = begin - 1;
		int cur = begin;
		int big = end + 1;
		while (cur != big) {
			if (arr[cur] < pivotValue) {
				swap(arr, ++small, cur++);
			} else if (arr[cur] > pivotValue) {
				swap(arr, cur, --big);
			} else {
				cur++;
			}
		}
		int[] range = new int[2];
		range[0] = small + 1;
		range[1] = big - 1;
		return range;
	}

	public void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
}
