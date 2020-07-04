package _03examination._1bytedance;

import org.junit.Test;
/**
 * 雨水累计问题
 * 题目:给定一个数组,每一个数字代表一个水坑的高度,求当下雨时,水坑可以手机多少雨水
 * @author Administrator
 *
 */
public class _02雨水收集 {
    
	@Test
    public void main() {
//        Scanner sc = new Scanner(System.in);
        //数组的长度
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++){
//        	arr[i] = sc.nextInt();
//        } 
        int[] arr = {4,0,2,4,3};
        int n = arr.length;
        getyushui(arr,n);
    }
    
    //调用方法输出结果
	private static void getyushui(int[] arr, int n) {
		if (arr==null || arr.length==0 ||arr.length==1 || arr.length==2) {
			System.out.println(0);
		}
		// 生成一个数组为arr装满水之后的样子
		//找到每个位置左侧和右侧最高的高度,如果次高的高度小于自身,则为本身,否则为次高的值
		//新建数组
		int[] arr1 = new int[n]; 
		arr1[0] = arr[0];
		arr1[n-1] = arr[n-1];
		for (int i = 1; i < arr.length-1; i++) {
			arr1[i] = getnum(arr,i);
		}
		int sum = 0;
		for (int i = 0; i < arr1.length; i++) {
			sum += arr1[i] - arr[i];
		}
		System.out.println(sum);
	}
	
	private static int getnum(int[] arr, int i) {
		int leftnum = arr[i];
		for (int j = i; j >= 0; j--) {
			leftnum = Math.max(leftnum, arr[j]);
		}
		int rightnum = arr[i];
		for (int j = i; j < arr.length; j++) {
			rightnum = Math.max(rightnum, arr[j]);
		}
		return Math.min(leftnum, rightnum);
	}
}

