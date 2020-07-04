package _01基本排序算法;

public class _03冒泡排序 {
/**
 * 时间复杂度: O(n)  O(n^2)
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
			boolean flag = true;
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
