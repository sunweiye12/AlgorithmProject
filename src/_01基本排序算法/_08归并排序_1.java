package _01基本排序算法;


public class _08归并排序_1 {
	/**
	 * 时间复杂度: O(nlogn) O(nlogn) ---平均---->O(nlogn)
	 * 空间占用: O(n)   ---->  归并排序返回一个新数组所以空间占用大
	 * 稳定性: 稳定
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6};
		int[] arr1 = mergeSort(arr,0,arr.length-1);//返回新的数组
		for (int i : arr1) {
			System.out.print(i + " ");
		}
	}
	
	//归并排序(返回一个有序数组)
	public static int[] mergeSort(int[] arr, int left, int right) {

	    if (left == right) {	//划分为只有一个元素时返回元素本身
	       return new int[] {arr[left]};
	    }
	    int mid = right+(( left - right) >> 1);  // 求中间值（防止溢出），将数组分成两部分
	    
	    int[] l = mergeSort(arr, left, mid);
	    int[] r = mergeSort(arr, mid + 1, right);
	    return merge(l, r);
	}

	// 将两个已经排好序的数组合并成一个有序数组
	public static int[] merge(int[] l, int[] r) {

	    int[] result = new int[l.length + r.length];  //创建新数组,长度为两个数组长度之和
	    int p = 0;	//新建数组的下标
	    int lp = 0; //左侧数组下标
	    int rp = 0; //右侧数组下标
	    
	    while (lp < l.length && rp < r.length) {
	       result[p++] = (l[lp] < r[rp] ? l[lp++] : r[rp++]);
	    }
	    //当其中一个数组用完时,来到下面
	    //分别将没有弄完的元素直接添加到数组中
	    while (lp < l.length) {
	       result[p++] = l[lp++];
	    }
	    while (rp < r.length) {
	       result[p++] = r[rp++];
	    }
	    
	    return result;		//返回一个有序的数组
	}

}
