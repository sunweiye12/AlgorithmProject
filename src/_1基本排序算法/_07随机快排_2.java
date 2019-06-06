package _1基本排序算法;
import org.junit.Test;


public class _07随机快排_2 {
	/**
	 * 时间复杂度: O(nlogn) --长期期望的过程-->O(nlogn)
	 * 空间占用: 	O(logn)  --长期期望的过程-->O(logn)
	 * 稳定性: 不稳定
	 * @param args
	 */
	
	@Test
	public void main() {
		int[] arr = {5,3,2,8,5,9,21,6};
		fastSort(arr,0,arr.length-1);		//快速排序要传入数组,以及数组开头和结尾的下标
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	
	//快速排序
	public void fastSort (int[] arr,int first,int last){
		
		if (first >= last) { //递归截止的条件(当数组只有一个元素第)
			return;
		}
		
		//随机快排(***重点***)
		swap(arr,first,first+(int)(Math.random()*(last-first+1)));
		
		int mid_value = arr[first];	//获取数组的下标
		
		int[] p = fast(arr, first, last, mid_value);
		
		//通过递归将左右两侧进行快排
		fastSort(arr,first,p[0]-1);
		fastSort(arr,p[1]+1,last);
	}
	
	//返回相等部分的下标值   ---> 参数为 数组,左边界,右边界,要比较的数
	public int[] fast(int[] arr, int L ,int R ,int num){

		int less =L - 1;	//小于num的指针
		int more =R + 1;	//大于num的
		int cur = L;		//等于num的指针
		
		while (cur < more) { 		//只要cur与more没有相遇就一直循环
			if (arr[cur] < num) {
				swap(arr, ++less, cur++);
			} else if (arr[cur] > num) {
				swap(arr, --more, cur);		//此处cur不能加一,因为移过来的more--还没有经过判断,且需要判断
			} else {		//相等情况
				cur++;
			}
		}
		
		//若数组中存在num则返回存在num的下标范围
		return new int[] {less+1,more-1};
	}
		
	//交换数组a下标和b下标的元素
	public void swap(int[] arr , int a ,int b){
		int tem = arr[a];
		arr[a] = arr[b];
		arr[b] = tem;
	}
	
}
