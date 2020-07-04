package _03examination._3alibaba;
/*
 * 题目:给定一个数组,输出子数组中最大和
 * 
 * 思路1:暴力解,分别求出每一个子数组,并计算他们的长度,然后维持一个全局最大值
 * 
 * 思路2:设置一个动态和 wmax,从第一个开始累加,记录每次的最大值,
 * 		如果加到下一个数小于0时,就将wmax=0,然后继续累加,直到结束,输出最大的wmax 
 */

public class _02输出子数组的最大和{ 
	
	public static void main(String[] args) {
		//输入
		int[] arr = {-1,5,4,-1,-2,10,-1,100};
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(arr[i], max);
		}
		//如果无正数,则输出全局最大的值
		if (max <= 0) {
			System.out.println(max);
			return;
		}
		//如果里面包含非负数的话
		max = 0;
		int wmax = 0;
		for(int i = 0; i < arr.length; i++){
			//假如加上一个数以后小于0,则将wmax置为0.否则加上这个数
			if(wmax + arr[i] >= 0){
				wmax = wmax + arr[i];
			}else{
				wmax = 0;
			}
			max = Math.max(wmax, max);
		}
		System.out.println(max);
	}
}
