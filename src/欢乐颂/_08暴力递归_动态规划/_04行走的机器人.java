package 欢乐颂._08暴力递归_动态规划;

import org.junit.Test;

/*
 * 思路:一个长度为N的路,1~N,一个机器人在M位置，他可以走P步，如果在1位置只能走右，在N位置只能走左，请问机器人走P步后他停在K位置上的走法有多少种。
 * 例如n=4 m=2 p=2 k=2   1-2-3-4  就是它从2位置走两步来到2位置,一共有2中分别为 2->3->2  2->1->2
 * 
 * 思路1:暴力递归：定义一个函数f(N,M,P,K)
 * K和N是固定的，表示 K位置 和 N为路的长度，
 * P和M是可变的，P表示当前剩余多少步能走 M表示当前在路的什么位置*(如果p和m确定返回结果就确定了)
 * 返回值为当前状态下 机器人最终停在K位置的走法
 * 
 * 思路2:动态规划,由上面的结果可以知道只要m和p确定了递归函数的返回结果就确定了,因此可以通过m p参数构建一个而为dp数组
 */
public class _04行走的机器人 {

	@Test
	public void main() {
		int n = 4; // 路的长度
		int m = 2; // 当前位置
		int p = 2; // 可以走的步数
		int k = 2; // 目标位置
		int num1 = baoli(n, m, p, k);
		int num2 = dp(n, m, p, k);
		System.out.println(num1);
		System.out.println(num2);
	}

	// 动态规划解法
	private int dp(int n, int m, int p, int k) {

		int[][] dp = new int[p + 1][n + 1]; // 剩余步数,当前位置
		dp[0][k] = 1; // 当剩余步数为0时,只有当前位置为k时为1,其余都为0
		for (int i = 1; i <= p; i++) {
			for (int j = 1; j <= n; j++) { // 杨辉三角形逻辑
				dp[i][j] += j - 1 < 1 ? 0 : dp[i - 1][j - 1];
				dp[i][j] += j + 1 > n ? 0 : dp[i - 1][j + 1];
			}
		}
		return dp[p][m]; // 返回返回剩余步数为p时,当前位置为m的可能性
	}

	// 暴力递归法
	private int baoli(int n, int m, int p, int k) {
		// basecase(当剩余步数为0时判断,当前位置是否在目标位置上)
		if (n < 1 || m < 1 || m > n || p < 0 || k > n) {
			return 0;
		}
		if (p == 0) {
			return m == k ? 1 : 0;
		}
		int count = 0; // 声明返回结果
		// 否则说明还可以走
		if (m == 1) { // 走到左边界
			count = baoli(n, m + 1, p - 1, k);
		} else if (m == n) { // 走到右边界
			count = baoli(n, m - 1, p - 1, k);
		} else { // 在中间的时候(可以向左也可以向右)
			count = baoli(n, m + 1, p - 1, k) + baoli(n, m - 1, p - 1, k);
		}
		return count;
	}
}
