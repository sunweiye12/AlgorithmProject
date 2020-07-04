package _01基本排序算法;

public class _04选择排序 {
	/**
	 * 时间复杂度: O(n^2)  O(n^2)
	 * 空间占用: O(1)
	 * 稳定性: 不稳定
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6,0};
		selectSort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	
	//选择排序
	public static void selectSort(int[] arr){
		for(int i = 0;i < arr.length-1; i++){
			for(int j = i+1; j < arr.length; j++){
				if(arr[i]>arr[j]){
					swap(arr,i,j);
				}
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
