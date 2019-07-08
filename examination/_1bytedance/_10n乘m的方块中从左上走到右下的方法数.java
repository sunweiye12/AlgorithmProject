package _1byt edance;

import java.util.Scanner;

import org.junit.Test;

public class _10n乘m的方块中从左上走到右下的方法数 {
	
	@Test
	public void main() {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		String[] strArr = line.split(" ");
		int n = Integer.parseInt(strArr[0]);//获取行数
		int m = Integer.parseInt(strArr[1]);//获取列数
		if (n <= 0 || m <= 0) {
			System.out.println("输入有误!!");
			return;
		}
		int[][] dp = new int[n][m];//创建一个dp数组
		for (int i = 0; i < dp.length; i++) {  //将每一行的第一个数设置为1
			dp[i][0] = 1;
		}
		for (int i = 0; i < dp[0].length; i++) { //将每一列的第一个数设为1
			dp[0][i] = 1;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		System.out.println(dp[n-1][m-1]);
	}
}
