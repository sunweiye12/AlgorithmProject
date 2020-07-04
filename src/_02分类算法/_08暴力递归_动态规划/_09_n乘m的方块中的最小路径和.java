package _02分类算法._08暴力递归_动态规划;
import org.junit.Test;
/*
 * 题目:有一个n*m的矩阵,从左上角走到右下角,最短路径情况下,返回最小的路径和
 * 思路:首先要求路径最短,那就意味着从一个位置开始只能想右走或者向下走
 * 		1.创建一个dp数组 dp[n][m] 表示从0,0坐标走到n,m坐标的最小路径
 * 		2.对于dp[i][0]第一列的值,dp[i][0] = dp[0][0]+dp[1][0]+..+dp[i][0],为路径上的元素相加
 * 		3.对于dp[0][j]第一行的值,同理为第一行上经过元素值相加
 * 		3.对于任意dp[x][y] 他只能后从dp[x-1][y]或者dp[x][y-1]走过来,因此dp[x][y]=Math.min(dp[x-1][y],dp[x][y-1])+arr[x][y]
 * 		4.最后返回dp[n-1][m-1]
 */

public class _09_n乘m的方块中的最小路径和 {
	
	@Test
	public void main() {
//		int[][] arr = getMatr(4, 4);
		int[][] arr = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
		myPrint(arr);
		int num = partion(arr);
		System.out.println(num);
	}

	private int partion(int[][] arr) {
		//basecase
		if (arr == null ||arr.length == 0 ||arr[0].length == 0) {
			return 0;
		}
		//创建dp数组-->dp[x][y]代表从0,0到达x,y的最小路径和
		int[][] dp = new int[arr.length][arr[0].length];
		//赋初始值
		dp[0][0] = arr[0][0];
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = dp[i-1][0]+arr[i][0];
		}
		for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = dp[0][j-1]+arr[0][j];
		}
		//推算
		for (int x = 1; x < dp.length; x++) {
			for (int y = 1; y < dp[0].length; y++) {
				dp[x][y] = Math.min(dp[x-1][y] , dp[x][y-1])+arr[x][y];
			}
		}
		return dp[arr.length-1][arr[0].length-1];
	}
	
	
	
	
	//----------------------------------------------------------------------------------------------
	//获取一个m行n列的矩阵队列
	private static int[][] getMatr(int m,int n) {
		int[][] matr = new int[m][n];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				matr[i][j] = n*i+(j+1);			//生成的数为第几个数
//					matr[i][j] = (int)(Math.random()+0.7);		//只存在0和1的矩阵
			}
		}
		return matr;
	}
		
	//打印二维数组
	public static void myPrint(int[][] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
