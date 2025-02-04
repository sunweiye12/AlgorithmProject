package _01基本排序算法;

public class _06希尔排序 {
	/**
	 * 时间复杂度: O(n^1.3)  O(n^2) ---平均---->O(nlogn)-O(n^2)
	 * 空间占用: O(1)
	 * 稳定性: 不稳定
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6,0};
		shellSort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	
	/**
	 * 希尔排序
	 * 希尔排序是以插入排序为前提
	 * 希尔排序是将数组分成了几部分(通过步长分割),分别进行插入排序
     * 然后逐步缩小步长，最后步长为1的时候，进行最后一轮插入排序。
     *
     * 空间复杂度：O(n^k) 1.3<k<2
     * 时间复杂度：O(1)
	 * @param arr
	 */
	public static void shellSort(int[] arr){
		
		//设置步长
		int gap = arr.length/2;

        while(gap >= 1){
			for(int i=gap; i<arr.length; i++){ //从第二行开始,一直走到头
				for(int j=i; j >= gap; j=j-gap){ //设置每一个数所比较的次数
					if(arr[j] < arr[j-gap]){	//每次只和前步长个比较
						swap(arr, j, j-gap);
					} else {
						break;
					}
				}
			}
			//步长减半
			gap = gap/2; 
		}
	}
	
	//元素交换的方法
	private static void swap(int[] arr,int i, int j) {
		arr[i]   = arr[i]^arr[j];
		arr[j]   = arr[i]^arr[j];
		arr[i]   = arr[i]^arr[j];
	}
	
	
	
}
