package 欢乐颂._08暴力递归_动态规划;
import org.junit.Test;
/*
 * 思路:一个长度为N的路,1~N,一个机器人在M位置，他可以走P步，如果在1位置只能走右，在N位置只能走左，请问机器人走P步后他停在K位置上的走法有多少种。
 * 例如n=4 m=2 p=2 k=2   1-2-3-4  就是它从2位置走两步来到2位置,一共有2中分别为 2->3->2  2->1->2
 * 思路2:动态规划,由上面的结果可以知道只要m和p确定了递归函数的返回结果就确定了,因此可以通过m p参数构建一个而为dp数组
 */
public class _04行走的机器人_dp {
	@Test
	public void main() {
		int n = 4; // 路的长度
		int m = 2; // 当前位置
		int p = 2; // 可以走的步数
		int k = 2; // 目标位置
		int num2 = dp(n, m, p, k);
		System.out.println(num2);
	}

	// 动态规划解法
	private int dp(int len, int pos, int step, int aim) {
		// basecase
		if (len < 1 || pos < 1 || pos > len || step < 0 || aim > len) {
			return 0;
		}
		//创建dp数组   dp[x][y] 是指剩余x步数时,当前位置为y时到指定位置的方法数
		int[][] dp = new int[step + 1][pos + 1]; 
		//初始化-->当剩余步数为0时,只有当前位置为aim时为1,其余都为0
		dp[0][aim] = 1; 
		for (int i = 1; i <= step; i++) {
			for (int j = 1; j <= len; j++) { // 杨辉三角形逻辑
				dp[i][j] += j - 1 < 1 ? 0 : dp[i - 1][j - 1];
				dp[i][j] += j + 1 > len ? 0 : dp[i - 1][j + 1];
			}
		}
		return dp[step][pos]; // 返回返回剩余步数为p时,当前位置为m的可能性
	}
}
