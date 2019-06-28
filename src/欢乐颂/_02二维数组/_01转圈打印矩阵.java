package 欢乐颂._02二维数组;

/**
 * 【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。
	例如： 	1  2  3  4 
			5  6  7  8 
			9  10 11 12
			13 14 15 16 
	打印结果为：1，2，3，4，8，12，16，15，14，13，9，5，6，7，11， 10
	【要求】 额外空间复杂度为O(1)
	思路:将细节问题转换为宏观问题---->首先考虑打印最外面一层,然后逐渐向内部打印
		设置四个指针:p1=0是起始行位置,p2=0是起始列位置,p3=...是最终行位置,p4=...是最终列位置
		就最外行而言先从arr[p1][p2] 打印到 arr[p1][p4-1]
				然后打印 arr[p1][p4]到 arr[p3-1][p4]
				然后打印 arr[p3][p4]到 arr[p3][p2+1]
				然后打印 arr[p3][p2]到 arr[p1+1][p2]
		此时完成一圈的工作,然后让p1++,p2++,p3--,p4--继续循环
		直到p1>p3或者p2>p4
 * @author Administrator
 *
 */
public class _01转圈打印矩阵 {
	public static void main(String[] args) {
		int[][] matr = getMatr(5,3);
		myPrint(matr);
		System.out.println("-----------------------");
		printMatr(matr);
		
	}

	
	//转圈的方式打印二维数组
	private static void printMatr(int[][] arr) {
		int p1 = 0;
		int p2 = 0;
		int p3 = arr.length-1;		//行数
		int p4 = arr[0].length-1;	//列数
//		System.out.println(p3+" "+p4);
		while(p1<=p3&&p2<=p4){
			for (int i = p2; i < p4; i++) {
				System.out.print(arr[p1][i]+" ");
			}
			for (int i = p1; i < p3; i++) {
				System.out.print(arr[i][p4]+" ");
			}
			for (int i = p4; i > p2; i--) {
				System.out.print(arr[p3][i]+" ");
			}
			for (int i = p3; i > p1; i--) {
				System.out.print(arr[i][p2]+" ");
			}
			p1++;
			p2++;
			p3--;
			p4--;
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

