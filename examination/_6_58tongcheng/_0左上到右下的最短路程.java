package _6_58tongcheng;
/*
 * 有一个棋盘,每一个位置上都有一个对应的数,从左上角开始移动到右下角,问经过的数最小和是多少
 * 例如: 1 3 4
 * 		2 1 2
 * 		4 3 1
 * 行走路径为: 下>右>右>下       1+2+1+2+1=7
 * 因此答案为7
 * 
 * 思路:通过动态规划解题,如果传入一个m*n的二维矩阵,则创建一个m*n的DP矩阵,dp[i][j]代表从坐上角走到此位置时的最短距离
 */
public class _0左上到右下的最短路程 {
	public static void main(String[] args) {
		int[][] arr = {{1,3,4},{2,1,2},{4,3,1}};
		int num = partion(arr);
		System.out.println(num);
	}

	private static int partion(int[][] arr) {
		//basecase
		if (arr == null || arr.length==0 || arr[0].length == 0) {
			return 0;
		}
		// 创建一个dp数据,代表dp[i][j]代表从arr[0][0]到arr[i][j]的最短路程
		int[][] dp = new int[arr.length][arr[0].length];
		// 赋初始值
		dp[0][0] = arr[0][0];
		for (int i = 1; i < arr.length; i++) {
			dp[i][0] = arr[i][0] + dp[i-1][0];
		}
		for (int i = 1; i < arr[0].length; i++) {
			dp[0][i] = arr[0][i] + dp[0][i-1];
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp.length; j++) {
				dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j])+arr[i][j];
			}
		}
		return dp[arr.length-1][arr[0].length-1];
	}
}
