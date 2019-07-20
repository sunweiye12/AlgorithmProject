package 欢乐颂._08暴力递归_动态规划;

import org.junit.Test;

/*
 * 题目:求两字符序列的最长公共字符子序的长度-->
 * 		提供给你两个字符串,求出最长的公共子序列,的长度
 * 		例如  abcbdab  bced  -->  最长公共子序列为bcd 返回 3
 * 
 * 思路:1.首先可以通过字符串来过去到两个字符数组,然后问题转化为两个数组的最长公共子序列
 * 	   2.创建dp[str1.length+1][str2.length+1]数组,其中dp[x][y]代表从str1前x个元素,与str2前y个元素的最长公共子序列
 * 	   3.初始化,其中dp[x][0] = dp[0][y] = 0 因为定其中一个是空串时,不存在最长公共子串
 * 			dp[x][1]当str1的第x个元素与str2的第1个元素相同时dp[x][1]=1,且之后都为1
 * 			dp[1][y]同理
 * 	   4.对于任意的dp[x][y]有三种情况
 * 			1.当str1[x] != str2[y]时可能:dp[x][y] = dp[x-1][y]
 * 			2.当str1[x] != str2[y]时可能:dp[x][y] = dp[x][y-1]
 * 			3.当str1[x] == str2[y] 时为: dp[x][y] = dp[x-1][y-1] + 1
 * 		求出这三种情况中最大是复制给dp[x][y]
 */
public class _12两个字符串的最长公共子序列 {
	
	@Test
	public void main() {
		String str1 = "ABCBDCAB";
		String str2 = "BDCABA";  //BDAB
		int maxLen = partion(str1,str2);
		System.out.println(maxLen);
	}

	private int partion(String str1, String str2) {
		//通过字符串获取字符数组
		char[] strArr1 = str1.toCharArray();
		char[] strArr2 = str2.toCharArray();
		//创建dp数组
		int[][] dp = new int[strArr1.length][strArr2.length];
		//初始化
		if(strArr1[0] == strArr2[0]) dp[0][0] = 1;
		for (int i = 1; i < dp.length; i++) {
			if(strArr1[i] == strArr2[0] || dp[i-1][0] == 1){
				dp[i][0] = 1;
			}
		}
		for (int i = 1; i < dp[0].length; i++) {
			if(strArr2[i] == strArr1[0] || dp[0][i-1] == 1){
				dp[0][i] = 1;
			}
		}
		for (int x = 1; x < dp.length; x++) {
			for (int y = 1; y < dp[0].length; y++) {
				if (strArr1[x] == strArr2[y]) {
					dp[x][y] = dp[x-1][y-1] + 1;
				} else{
					dp[x][y] = Math.max(dp[x-1][y], dp[x][y-1]);
				}
			}
		}
		return dp[strArr1.length-1][strArr2.length-1];
	}

}
