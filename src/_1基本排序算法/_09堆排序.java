package _1基本排序算法;
import java.util.Arrays;


public class _09堆排序 {
	/**
	 * 时间复杂度: O(nlogn) O(nlogn) ---平均---->O(nlogn)
	 * 空间占用: O(1)
	 * 稳定性: 不稳定
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6};
		heapSort(arr);
		printArray(arr);
//		System.out.println(-1/2);
	}
	
	
	//堆排序
	public static void heapSort(int[] arr) {
		//当给定的数组小于等于1时直接返回
		if (arr == null || arr.length < 2) {
			return;
		}
		
		//将给定的数组构造成大顶堆
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		
		//将堆顶与数组尾部交换,堆的长度减一;(每一次将最大的放到最后)
		int size = arr.length;
		swap(arr, 0, --size);
		while (size > 0) {
			heapify(arr, 0, size);	//堆顶数据改变重新成堆
			swap(arr, 0, --size);	//继续交换位置
		}
	}

	//向堆中插入一个值(每次都与其父节点比较如果比父节点大则交换为位置,在与父节点比较,直到小于父节点)
	//此方法默认index之前的数组已经形成大顶堆结构,将index下标的元素插入
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;				//-1/2 = 0
		}
	}
	
	//改变堆中一个值,重新成堆
	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;  //左子节点
		while (left < size) {
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}

	//工具方法,交换
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	//工具方法,打印数组
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
