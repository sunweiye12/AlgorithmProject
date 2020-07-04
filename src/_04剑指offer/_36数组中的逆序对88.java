package _04剑指offer;

import org.junit.Test;

/*
 * 题目:在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 		输入一个数组,求出这个数组中的逆序对的总数P。
 * 		并将P对1000000007取模的结果输出。
 * 		 即输出P%1000000007   (注:题目保证输入的数组中没有的相同的数字)
 * 思路(暴力算法):依次扫描每一个数字开头的逆序对   O(n2)   空间O(1)
 * 思路(利用MegerSort原理):可以将给定的数组二分,直到最小单元为一个字符元素时,然后在排序好合并
 * 		在合并的过程中,进行逆序对儿的统计   时间O(nlogn)  空间O(n)
 */
public class _36数组中的逆序对88 {

	@Test
	public void main() {
		int[] arr = {1,2,3,4,5,6,7,0};
		int num = InversePairs_baoli(arr);
		int num1 = InversePairs(arr);
		System.out.println(num1);
	}
	
	//利用MegerSort来结题
	public int InversePairs(int[] arr) {
		if (arr==null || arr.length <= 1) {
			return 0;
		}
		int num = merge(arr,0,arr.length-1);
		return num;
	}
	
	//利用归并排序思路在解决此题
    public  int merge(int[] arr,int left,int right) {
    	//递归的截止条件
        if(left == right) 
            return 0;
      	//获取中间点
        int mid = left + ((right - left) >> 1);
        return  merge(arr,left,mid)+ merge(arr,mid+1,right)+mergerSort(arr ,left,mid,right);
    }
    
    public  int mergerSort(int[] arr,int left,int mid,int right){
    	//创建辅助数组
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid+1;
        int result = 0;
        //将有序的两部分合并为有序的一部分存储到help中
        while (p1 <= mid && p2 <= right){
        	//***重点***两部分分开考虑.由于两部分都是由大到小排序的,
        	//当左面的一个数A小于右面的一个数B时.此时A跳过,因为A本生在B所在的左面,所以不会形成逆序对
            //当左面的一个数A大于右面的一个数B时.此时形成逆序对,且它一定大于B右面的所有数,也就是说B的右面包括B都会与A组成逆序对
        	result += (arr[p1] > arr[p2] ? right-p2+1 : 0); //只有当左面的数大于右面的数的时候才会统计逆序对
            help[i++] = (arr[p1] > arr[p2] ? arr[p1++] : arr[p2++]);
        }
        //当其中有一个到头时将另一个直接复制到result中
        while (p1 <= mid){
             help[i++] = arr[p1++];
        }
        while (p2 <= right){
             help[i++] = arr[p2++];
        }
      //将这部分有序代码存储到arr所属的位置
        for (int j = 0; j < help.length; j++) {
			arr[j+left] = help[j];
		}
        return result;
    }

	//暴力解
	public int InversePairs_baoli(int [] arr) {
		if (arr==null || arr.length <= 1) {
			return 0;
		}
		int retCount = 0;//用于返回的计数器
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i]>arr[j]) {
					retCount++;
				}
			}
		}
        return retCount;
    }
}
