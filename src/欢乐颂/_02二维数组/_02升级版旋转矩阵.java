package 欢乐颂._02二维数组;

import org.junit.Test;

/**
 *  【题目】 给定一个整型二维矩阵matrix，请把该矩阵调整成顺时针旋转90度的样子。
	【要求】 额外空间复杂度为O(m*n)。
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
 *思路:此题的思路依然是将具体细节转化为宏观操作,与基础版不同的是这里没有指定必须时正方形的矩阵,因此当不是正方形的矩阵时,90度旋转以后的二维数组与
 *	原数组的数据结构不同,因此此题需要的空间复杂度为(m*n) --> 其中m和n分别为矩形的高和宽
 *	其余的解题思路和基础版的相同
 *	设置四个指针:p1=0是起始行位置,p2=0是起始列位置,p3=...是最终行位置,p4=...是最终列位置
 *	第一次循环用于打印最外层元素,分别让1->4,4->16,16->13,13->1
 *	然后在让2和3按照上面的思路进行面
 *	当进行玩最外层的时候逐层向内部打印
 */
public class _02升级版旋转矩阵 {
	
	@Test
	public void main() {
		int[][] matr = getMatr(2,4);
		myPrint(matr);
		System.out.println("------------------------");
		int[][] matr1 = rotateMatr(matr);
		myPrint(matr1);
		
	}
	
	private int[][] rotateMatr(int[][] arr) {
		int[][] arr1 = new int[arr[0].length][arr.length]; //创建一个转移后的矩阵用于填充
		int p1 = 0;
		int p2 = 0;
		int p3 = arr.length-1;		//行数 - 1 (因为从0开始计数)
		int p4 = arr[0].length-1;	//列数 - 1
		while(p2<=p4 && p1<=p3){
			//循环移动最外面一圈
			for (int i = 0; i < p4-p2; i++) {
				swap(arr,arr1, p1, p2+i, p2+i, p3);
			}
			for (int i = 0; i < p3-p1; i++) {
				swap(arr,arr1, p3-i, p2, p2, p1+i);
			}
			for (int i = 0; i < p4-p2; i++) {
				swap(arr,arr1, p3, p4-i, p4-i, p1); 
			}
			for (int i = 0; i < p3-p1; i++) {
				swap(arr,arr1, p1+i, p4, p4, p3-i);
			}
			p1++;
			p2++;
			p3--;
			p4--;
		}
		
		return arr1;
	}
	
	//二维数组的交换
	private void swap(int[][] arr , int[][] arr1 ,int p1,int p2,int p3,int p4){
		arr1[p3][p4] = arr[p1][p2];
	}

	//获取一个m行n列的矩阵队列
	private int[][] getMatr(int m,int n) {
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
