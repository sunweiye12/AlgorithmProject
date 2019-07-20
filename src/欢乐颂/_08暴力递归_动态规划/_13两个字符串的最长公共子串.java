package 欢乐颂._08暴力递归_动态规划;
/*
 * 题目:求两字符序列的最长公共字符子串的长度-->
 * 		提供给你两个字符串,求出最长的公共子序列,的长度
 * 		例如  abcbdab  bced  -->  最长公共子序列为bc 返回 2
 * 思路:动态规划,创建dp[][]数组,
 * 		1.其中dp[x][y]=0代表str1[x] != str2[y],dp[x][y]=k是指,str1在0-x和str2在0-y后面的k个元素相等
 * 		2.初始化有dp[x][0] 只有与arr2[0]相等的时候为1,其他时候都为0 ;;; dp[0][y]同理
 * 		3.dp[x][y] 推导过程为如果str1[x]!=str2[y]则dp[x][y]=0 
 * 				str1[x]==str2[y] 则有dp[x][y] = dp[x-1][y-1] + 1;
 * 		4.而后返回dp[x][y]中最大的数
 * 思路:KMP算法用于判断一个字符串中是否包含另一个字符串
 */
public class _13两个字符串的最长公共子串 {

	public static void main(String[] args) {
		String str1 = "aaffffsfabcdfasf";
		String str2 = "aaaadfsabcdfsdb";  //公共abcdf
		int num = partion(str1,str2);
		System.out.println(num);
	}

	private static int partion(String str1, String str2) {
		//将字符串转换为字符数组
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		//创建dp数组
		int[][] dp = new int[arr1.length][arr2.length];
		//初始化
		for (int i = 0; i < dp.length; i++) 
			dp[i][0] = arr1[i] == arr2[0] ? 1 : 0;
		
		for (int i = 0; i < dp[0].length; i++) 
			dp[0][i] = arr1[0] == arr2[i] ? 1 : 0;
		
		for (int x = 1; x < dp.length; x++) {
			for (int y = 1; y < dp[0].length; y++) {
				if (arr1[x] == arr2[y]) {
					dp[x][y] = dp[x-1][y-1] + 1;
				}
			}
		}
		int ret = 0; //全局最大值,将其返回
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				ret = Math.max(ret, dp[i][j]);
			}
		}
		return ret;
	}
}
