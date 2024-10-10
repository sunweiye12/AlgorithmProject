package _01基本排序算法;

public class _07快速排序_1 {
	/**
	 * 思路：
     *
     * 时间复杂度: O(nlogn)  O(n^2) ---平均---->O(nlogn)
	 * 空间占用: O(logn)  -  O(n)
	 * 稳定性: 不稳定
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6};
		fastSort(arr,0,arr.length-1);		//快速排序要传入数组,以及数组开头和结尾的下标
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	//快速排序
	public static void fastSort (int[] arr,int first,int last){
		if (first >= last) { //递归截止的条件(当数组只有一个元素)
			return;
		}
		
		int mid_value = arr[first];	//取第一个元素作为基准元素用作比较。
		int low = first;
		int high = last;
		
		while (low < high) {
			//当满足条件是游标左移,否则交换
			while((low < high) && (arr[high]>=mid_value)){
				high -= 1;
			}
			arr[low] = arr[high];
			
			//当满足条件时游标右移,否则交换
			while((low < high) && (arr[low]<=mid_value)){
				low += 1;
			}
			arr[high] = arr[low];
		}
		
		//从循环中退出意味着low = high,两个指针相遇
		arr[low] = mid_value;
		
		//通过递归将左右两侧进行快排
		fastSort(arr,first,low-1);
		fastSort(arr,low+1,last);
	}
	
}
