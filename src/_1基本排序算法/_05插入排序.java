package _1基本排序算法;

public class _05插入排序 {
	/**
	 * 时间复杂度: O(n)  O(n^2)
	 * 空间占用: O(1)
	 * 稳定性: 稳定
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6};
		insertSort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	
	/**插入排序
	 * 认为第一个元素是有序的,从第二个元素开始(向前插入),从第二个元素开始和前面的比较,如果比本身大就交换,然后在和前一位比较,
	 * 直到遇到前一位比自身小的元素,就结束循环(或者循环条件结束,交换到了头部)
	 * @param arr
	 */
	public static void insertSort(int[] arr){
		for(int i = 1;i < arr.length; i++){ //从第一个节点开始想前插入
			
			for(int j = i; j > 0; j--){		//每个节点最多交换的次数
				if(arr[j] < arr[j-1]){	   //如果后面的这个比前面的小就交换位置
					swap(arr,j,j-1);
				} else{						//否则结束循环
					break;
				}
			}
			
		}
	}
	
	//元素交换的方法
	private static void swap(int[] arr,int i, int j) {
		// TODO Auto-generated method stub
		arr[i]   = arr[i]^arr[j];
		arr[j]   = arr[i]^arr[j];
		arr[i]   = arr[i]^arr[j];
	}
	
	
	
}
