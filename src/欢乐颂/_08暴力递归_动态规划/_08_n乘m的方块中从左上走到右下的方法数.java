package 欢乐颂._08暴力递归_动态规划;
/*
 * 题目:有一个n*m的矩阵,从左上角走到右下角,要求路径最短,返回一共有多少中走法
 * 
 * 思路:首先要求路径最短,那就意味着从一个位置开始只能想右走或者向下走
 * 		1.创建一个dp数组 dp[n][m] 表示从0,0坐标走到n,m坐标的方法数
 * 		2.对于dp[i][0] = dp[0][j] = 1;因为第一行只能向右走到,第一列只能向下走到,所以方法就一种
 * 		3.对于任意dp[x][y] 他只能后从dp[x-1][y]或者dp[x][y-1]走过来,因此dp[x][y]=dp[x-1][y]+dp[x][y-1]
 * 		4.最后返回dp[n-1][m-1]
 */
import org.junit.Test;

public class _08_n乘m的方块中从左上走到右下的方法数 {
	
	@Test
	public void main() {
		int n = 3;//获取行数
		int m = 3;//获取列数
		int times = partion(n,m);
		System.out.println(times);
	}

	private int partion(int n, int m) {
		//basecase
		if (n <= 0 || m <= 0) {
			return 0;
		}
		//创建pd数组
		int[][] dp = new int[n][m];
		//赋初始值
		for (int i = 0; i < dp.length; i++) 
			dp[i][0] = 1;
		for (int i = 0; i < dp[0].length; i++) 
			dp[0][i] = 1;
		//推算
		for (int x = 1; x < dp.length; x++) {
			for (int y = 1; y < dp[0].length; y++) {
				dp[x][y] = dp[x-1][y] + dp[x][y-1];
			}
		}
		return dp[n-1][m-1];
	}
}
