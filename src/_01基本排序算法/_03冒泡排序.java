package _01基本排序算法;

public class _03冒泡排序 {
/**
 * 思路：
 * 1. 需要进行n-1轮比较（外循环）
 * 2. 每一轮都需要比较 n-1-i 次,将这一轮中最大的那个数放到 n-1-i 的位置上。 （每轮比较中都将最大的那一个值右移）
 * 优化措施： 增加的是一个标识位，这个标识位代表的是在某一轮比较后，比较的过程中如果没有发生交换则证明改数组已经有序了，则终止后面几轮的交换
 * 时间复杂度: O(n) -> O(n^2)
 * 空间占用: O(1)
 * 稳定性: 稳定
 * @param args
 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6};
        bubbleSort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	
	//冒泡排序
	public static void bubbleSort(int[] arr){
		for(int i = 0;i < arr.length-1; i++){
			boolean flag = true;  // 增加的是一个标识位，这个标识位代表的是在某一轮比较后，比较的过程中如果没有发生交换则证明改数组已经有序了，则终止后面几轮的交换
			for(int j = 0; j < arr.length-1-i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					flag = false;
				}
			}
			if(flag){
				break;
			}
		}
	}
	
	//元素交换的方法
	private static void swap(int[] arr,int i, int j) {
		arr[i]   = arr[i]^arr[j];
		arr[j]   = arr[i]^arr[j];
		arr[i]   = arr[i]^arr[j];
	}
}
