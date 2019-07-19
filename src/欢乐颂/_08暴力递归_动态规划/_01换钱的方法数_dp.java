package 欢乐颂._08暴力递归_动态规划;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 *【题目】给定数组arr，arr中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim代表要找的钱数，
 * 		求换钱有多少种方法。
 * DP解决方案:通过一个二维数组结构dp[][]来存放所有的结果集,
 * 		1.其中dp[x][y]表示使用前x张钱,凑出y元所用的方法数
 * 		2.可以得出dp[x][0]=1,因为凑出一张钱只有一种方法
 * 		3.对于任意dp[x][y] 为
 * 			dp[x-1][y] 不适用这张前,组出y元的方法.加上
 * 			dp[x-1][y - 1 * arr[x]] 使用一张此钱币,组出y - 1 * arr[x]的方法书,加上 ..
 *			定义count = y/arr[x]为做多可以使用此钱的个数
 */
public class _01换钱的方法数_dp {
	@Test
	public void main() {
		int[] arr = {5,10,25,1};
		int aim = 15;
		int num3 = dppartion(arr,aim);
		System.out.println(num3);
	}

	//利用动态规划来解决此问题
	private int dppartion(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim <= 0) {
			return 0;
		}
		//创建dp数组 dp[x][y]实用前x张钱组出y员的次数
		int[][] dp = new int[arr.length+1][aim+1];
		//初始化dp[x][0]=0,组出0元只有一种方法
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for (int x = 1; x < dp.length; x++) {
			for (int y = 1; y < dp[0].length; y++) {
				//判断当前x张钱时,组出y员的方法
				int count = y/arr[x-1]; //arr[x-1]代表x张硬币的面值,count代表可以用的最大是张数
				for (int i = 0; i <= count; i++) {
					//当使用i张此钱币时,前x-1个硬币应该组成y- i * arr[x-1]元
					dp[x][y] += dp[x-1][y- i * arr[x-1]]; 
				}
			}
		}
		return dp[arr.length][aim];
	}
}