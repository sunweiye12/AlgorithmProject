package _0工具箱类;
import java.util.Arrays;

import _1基本排序算法._07快速排序_1;


public class _02对数器 {
/**
 * 1.有一个你想要测试的方法a
 * 2.实现一个绝对正确但是复杂度不好的方法b
 * 3.实现一个随机样本产生器
 * 4.把方法a和方法b比对很对此来验证方法a是否正确
 * 5.如果一个样品使得对比出错,打印分析那个方法出错了
 * 6.当样本多了以后就可以确定a是对的了
 * @param args
 */
	public static void main(String[] args) {
		int testTime = 500000;	//测试次数
		int size = 10;			//数组的最大长度
		int value = 100;		//数组的数值限制
		boolean success = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(size, value);	//生成随机数组生成器
			int[] arr2 = copyArray(arr1);					//获得结构相同数组
			int[] arr3 = copyArray(arr1);
			_07快速排序_1.fastSort(arr1, 0, arr1.length-1);	//调用测试方法
			rightSort(arr2);							//调用绝对正确的方法
			if (!isEqual(arr1, arr2)) {			//调用比对器进行比对
				success = false;
				printArray(arr3); // 将失败的样本打印出来
				break;
			}
		}
		System.out.println(success ? "Nice!成功!" : "出错了");
	}
	
	
	/**
	 * 打印数组
	 * @param arr3
	 */
	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	/**
	 * 产生一个随机的数组
	 * @return
	 */
	public static int[] generateRandomArray(int size , int value){
		
		//生成长度随机的数组 长度处于[0 , size]
//		int[] arr = new int[(int)((size + 1) * Math.random())];
		int[] arr = new int[9];//指定长度
		
		for(int i =0;i < arr.length; i++){
			arr[i] = (int)((value + 1) * Math.random()) - (int)(value * Math.random());
		}
		
		return arr;
	}
		
	/**
	 * 绝对正确的排序方法
	 * @param arr
	 */
	public static void rightSort(int [] arr){
		Arrays.sort(arr);
	}
		
	/**
	 * 返回一个结构一模一样的数组
	 * @param arr
	 * @return
	 */
	public static int[] copyArray(int [] arr){
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
		
	/**
	 * 判断两个数组结构是否完全相同
	 * @param arr
	 * @return
	 */
	public static boolean isEqual(int [] arr1,int [] arr2){
		if(arr1==null && arr2!=null){
			return false;
		}
		if(arr2==null && arr1!=null){
			return false;
		}
		if(arr1==null && arr2==null){
			return true;
		}
		if(arr1.length != arr2.length){
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i] != arr2[i]){
				return false;
			}
		}
		return true;
	}
	
}
