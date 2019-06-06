package 欢乐颂._02二维数组;

/**
 *  【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成顺时针旋转90度的样子。
	【要求】 额外空间复杂度为O(1)。
	例如:   1  2  3  4
		   5  6  7  8
		   9  10 11 12
		   13 14 15 16
	
	转化为:	13 9  5 1
		    14 10 6 2
		    15 11 7 3
		    16 12 8 4
 * @author Administrator
 *
 *思路:此题的思路依然是将具体细节转化为宏观操作(因为是要求空间复杂度为1因此不可以借助辅助空间)
 *	设置四个指针:p1=0是起始行位置,p2=0是起始列位置,p3=...是最终行位置,p4=...是最终列位置
 *	第一次循环用于打印最外层元素,分别让1->4,4->16,16->13,13->1
 *	然后在让2和3按照上面的思路进行面
 *	当进行玩最外层的时候逐层向内部打印
 */
public class _02旋转正方形矩阵 {
	
	public static void main(String[] args) {
		int[][] matr = getMatr(5,5);
		myPrint(matr);
		System.out.println("----------------");
		rotateMatr(matr);
		myPrint(matr);
		
	}
	
	private static void rotateMatr(int[][] arr) {
		int p1 = 0;
		int p2 = 0;
		int p3 = arr.length-1;		//行数
		int p4 = arr[0].length-1;	//列数
		
		while(p2<p4){
			//循环移动最外面一圈
			for (int i = 0; i < p4-p2; i++) {
				swap(arr, p3, p4-i, p3-i, p2);
				swap(arr, p1+i, p4, p3, p4-i);
				swap(arr, p1, p2+i, p1+i, p4);   
			}
			p1++;
			p2++;
			p3--;
			p4--;
		}
	}
	
	//二维数组的交换
	private static void swap(int[][] arr ,int p1,int p2,int p3,int p4){
		int temp = arr[p1][p2];
		arr[p1][p2] = arr[p3][p4];
		arr[p3][p4] = temp;
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
