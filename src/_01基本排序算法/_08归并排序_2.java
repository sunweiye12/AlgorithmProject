package _01基本排序算法;


public class _08归并排序_2 {
	/**
	 * 时间复杂度: O(nlogn) O(nlogn) ---平均---->O(nlogn)
	 * 空间占用: O(n)   ---->  此处不用返回一个新数组,但也需要开辟一个数组的空间
	 * 稳定性: 稳定
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6};
		mergeSort(arr,0,arr.length-1);  //在原来数组上修改
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	//归并排序
	public static void mergeSort(int[] arr, int left, int right) {

	    if (left == right) {	//划分为只有一个元素时结束
	       return;
	    }
	    
	    //获取中间值
	    int mid = left+(( right - left) >> 1);  //向右移动一位代表除以2
	    
	    //调用递归来进行切分
	    mergeSort(arr, left, mid);
	    mergeSort(arr, mid + 1, right);
	    
	    //调用合并方法,合并切分好的部分
	    merge(arr, left ,mid ,right);	
	}

	// 将两个已经排好序的部分合并成一个有序部分
	public static void merge(int[] arr, int left ,int mid ,int right) {

	    int[] result = new int[right - left + 1];  //创建新数组,长度为两个数组长度之和
	    int p = 0;			//新建数组的下标
	    int lp = left; 		//左侧部分下标
	    int rp = mid+1; 	//右侧部分下标
	    
	    while (lp <= mid && rp <= right) {
	       result[p++] = (arr[lp] > arr[rp] ? arr[lp++] : arr[rp++]);
	    }
	    //当其中一个数组用完时,来到下面
	    //分别将没有弄完的元素直接添加到数组中
	    while (lp <= mid) {
	       result[p++] = arr[lp++];
	    }
	    while (rp <= right) {
	       result[p++] = arr[rp++];
	    }
	    
	    //result是已经排好序的数组(他只是arr数组中left到right的一段)将他赋值到arr的固定位置上面
	    for (int i = 0; i < result.length; i++) {
			arr[i+left] = result[i];
		}
	}

}
