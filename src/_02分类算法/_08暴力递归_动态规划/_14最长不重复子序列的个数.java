package _02分类算法._08暴力递归_动态规划;

import org.junit.Test;

/*
 * 题意:给定你一个字符串,返回其中最长不重复子序列的个数
 * 
 *  例如: 4 5 6 7 4 3   --> 最长不重复子串为 4 5 6 7 3 -->长度为5
 *  
 *  思路:采用dp思维来解决此问题;dp[arr.length]创建一个与自出串相同长度的dp数组
 *  	1.其中dp[x]标志以下标为0~x结尾的子串中最长不重复的元素个数
 *  	2.初始化有dp[0] = 1,因为只有一个元素
 *  	3.对于任意的dp[x] 如果之前出现过元素,arr[x] 则有dp[x] = dp[x-1]
 *  				如果之前没有出现过元素,arr[x] 则有dp[x] = dp[x-1]+1;
 *  	4.最后dp[arr.length-1]即为所求
 *  
 *  思路2:可以利用Set集合来实现,时间复杂度为n
 */
public class _14最长不重复子序列的个数 {
	
	@Test
	public void main() {
		int[] arr = {4,5,6,7,4,3,6,8}; //456738
		int size = partion(arr);
		System.out.println(size);
	}

	//求最长不重复子序列长度
	private int partion(int[] arr) {
		//basecase
		if (arr == null || arr.length == 0) {
			return 0;
		}
	
		//创建dp数组
		int[] dp = new int[arr.length];
		//初始化
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			if (isContain(arr,i)) { //判断arr的i元素是否在之前出现过(如果出现过)
				dp[i] = dp[i-1];
			} else{
				dp[i] = dp[i-1] +1;
			}
		}
		return dp[arr.length-1];
	}

	//用于判断i之前有没有arr[i]出现过
	private boolean isContain(int[] arr, int i) {
		for (int j = 0; j < i; j++) {
			if (arr[j] == arr[i]) {
				return true;
			}
		}
		return false;
	}

}
