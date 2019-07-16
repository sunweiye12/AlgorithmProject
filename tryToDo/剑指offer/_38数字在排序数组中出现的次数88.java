package 剑指offer;

import org.junit.Test;

/*
 * 题目:统计一个数字在排序数组中出现的次数。
 * 
 * 思路:因为数组中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5
		这两个数应该插入的位置，然后相减即可。(但是浮点数运算效率低)
      思路:(重点是二分查找哇重要)
 */
public class _38数字在排序数组中出现的次数88 {
	
	@Test
	public void main() {
		int[] arr = {0,1,1,2,3,5,5,5,6};
		int k = GetNumberOfK(arr, 1);
		System.out.println(k);
	}
	
	public int GetNumberOfK(int [] arr , int k) {
        if(arr.length == 0 || arr == null){
            return 0;
        }
        int firstK = getFirstK(arr, k, 0, arr.length-1); //获取开头的下标(若找不到返回下标为-1)
        int lastK = getLastK(arr, k, 0, arr.length-1);	 //获取结尾的下标
        if(firstK == -1 || lastK == -1){
             return 0;
        }
        return lastK - firstK + 1; //返回个数
    }
	
	//递归写法
    private int getFirstK(int [] arr , int k, int start, int end){
    	if (end < start) {
			return -1; //每有查找到返回-1
		}
    	int mid = (end + start) >> 1;
    	if (arr[mid] > k) {
    		return getFirstK(arr, k, start, mid-1);
		} else if(arr[mid] < k){
			return getFirstK(arr, k, mid+1, end);
		} else if (mid-1>=0 && arr[mid-1] == k) {
			return getFirstK(arr, k, start, mid-1);
		} else {
			return mid;
		}
    }
    //循环写法
    private int getLastK(int [] arr , int k, int start, int end){
    	if (end < start) {
			return -1;
		}
    	int mid = (start + end) >> 1;
    	if (arr[mid] > k) {
    		return getLastK(arr, k, start, mid-1);
		} else if(arr[mid] < k){
			return getLastK(arr, k, mid+1, end);
		} else if( mid+1 <= end && arr[mid+1] == k){
			return getLastK(arr, k, mid+1, end);
		} else {
			return mid;
		}
    }
}
