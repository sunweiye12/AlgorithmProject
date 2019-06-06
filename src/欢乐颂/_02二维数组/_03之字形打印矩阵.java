package 欢乐颂._02二维数组;

/**
 “之”字形打印矩阵
	【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这
		个矩阵，例如：	 1 2  3  4 
					 5 6  7  8 
					 9 10 11 12
		“之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，8，12
	【要求】 额外空间复杂度为O(1)
 * 
	思路:此题的思路依然是将具体细节转化为宏观操作(因为是要求空间复杂度为1因此不可以借助辅助空间)
		设置两个点分别一个往下走一个往右走,每次都走一步且起始位置都在原点,
		当往右走的点走到了最右侧就开始往下走
		当往下走的点走到了最下侧就开始往右走
		这样的两个点他们始终是在对角线的位置的
 *
 */
public class _03之字形打印矩阵 {

	public static boolean flag;//打印的标志(正反)
	public static void main(String[] args) {
		int[][] matr = getMatr(4,3);
		myPrint(matr);
		System.out.println("----------------");
		zhiPrint(matr);
		
	}
	
	private static void zhiPrint(int[][] arr) {
		int rows = arr.length-1;		//行数(最大列坐标)
		int columns = arr[0].length-1;	//列数(最大横坐标)
		//定义向下走的点的横坐标与纵坐标
		int dp1 = 0;
		int dp2 = 0;
		//定义向右走的点的横坐标与纵坐标
		int rp1 = 0;
		int rp2 = 0;
		//每次他俩同时走一步,每走一步都会调用打印方法
		while(dp1<=rp1||dp1==0){
			//实现从zhi字打印
			booleanPrint(arr,dp1,dp2,rp1,rp2);
			//向下走的点向下移动,当移动到rows时向右移动
//			System.out.println(dp1+" "+dp2+"--"+rp1+" "+rp2);
			if (dp2<rows) {
				dp2++;
			}else {
				dp1++;
			}
			//向右走的点向右移动,当移动到columns时向下移动
			if (rp1<columns) {
				rp1++;
			}else {
				rp2++;
			}
		}
	}

	private static void booleanPrint(int[][] arr, int dp1, int dp2, int rp1,int rp2) {
		if (flag) {
			while(dp1<=rp1){
				System.out.print(arr[rp2++][rp1--]+" ");
//				rp1--;
//				rp2++;
			}
			flag =false;
		} else{
			while(dp1<=rp1){
				System.out.print(arr[dp2--][dp1++]+" ");
//				dp1++;
//				dp2--;
			}
			flag = true;
		}
	}

	//获取一个m行n列的矩阵队列
	private static int[][] getMatr(int m,int n) {
		int[][] matr = new int[m][n];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				matr[i][j] = n*i+(j+1);
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
