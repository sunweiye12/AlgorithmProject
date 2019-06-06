package 欢乐颂._01队列栈;

import org.junit.Test;

/**
 * 题目描述:有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。请设计一个高效的算法，
 * 计算给定数组中的逆序对个数。
 * 输入描述:给定一个int数组A和它的大小n，请返回A中的逆序对个数。保证n小于等于5000
 * 
 * 测试样例：
   [1,2,3,4,5,6,7,0],8
       返回：7
 * @author Administrator
 */

public class _01数组中的逆序对 {
	
	@Test
	public  void main() {
		int[] arr = {1,2,3,4,5,6,7,0};
		System.out.println(count(arr, arr.length));
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
			String si = "";
		}
	}
    
	 public  int count(int[] arr, int n) {
		//若长度小于等于1则不存在逆序对
    	if(arr == null || arr.length < 2){
    		return 0;
		}
		return merge(arr,0,arr.length-1);
	 }
	
	//利用归并排序思路在解决此题
    public  int merge(int[] arr,int left,int right) {
    	
    	//递归的截止条件
        if(left == right) {
            return 0;
        }
        
      //获取中间点
        int mid = left + ((right - left) >> 1);
        
//        merge(arr,left,mid);
//        merge(arr,mid+1,right);
        
        return	merge(arr,left,mid) + merge(arr,mid+1,right) + mergerSort(arr,left,mid,right) ;
    }
    
    public  int mergerSort(int[] arr,int left,int mid,int right){
    	
    	//创建辅助数组
        int[] help = new int[right - left + 1];
        
        int i = 0;
        int p1 = left;
        int p2 = mid+1;
        int result = 0;
        //将有序的两部分合并为有序的一部分存储到result中
        while (p1 <= mid && p2 <= right){
        	//***重点***讲两部分分开考虑.由于两部分都是由大道小排序的,当左面的一个数A大于右面的一个数B时
            //那它一定大于B右面的所有数,也就是说B的右面包括B都会与A组成逆序对
        	result += (arr[p1] > arr[p2] ? right-p2+1 : 0);
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
}
