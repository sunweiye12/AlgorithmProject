package 剑指offer;

import java.util.ArrayList;

import org.junit.Test;

/*
 * 题目:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 	例如，如果输入如下4 X 4矩阵： 
 * 			1  2  3  4 
 * 			5  6  7  8 
 * 			9  10 11 12 
 * 			13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * 思路:用左上和右下的坐标定位出一次要旋转打印的数据，一次旋转打印结束后，往对角分别前进和后退一个单位。
    	提交代码时，主要的问题出在，需要加入条件判断，防止出现单行或者单列的情况。(要单列情况下,从那边开始打印)
 */

public class _19顺时针打印矩阵__ {
	
	@Test
	public void main() {
		int[][] arr = getMatr(3,4);
		myPrint(arr); //打印二维矩阵
		//调用循环打印的函数
		printMatrix(arr);
	}
	
	//传入一个二维数组,将旋转打印的信息放入list集合中
	public ArrayList<Integer> printMatrix(int [][] arr) {
		if (arr == null || arr.length == 0 || arr[0].length == 0) {
			return null;
		}
		ArrayList<Integer> list = new ArrayList<Integer>(); //创建一个用于返回的集合
		int p1 = 0;					//起始行
		int p2 = 0;					//起始列
		int p3 = arr.length - 1;	//终止行
		int p4 = arr[0].length - 1;	//终止列
		parttion(arr,list,p1,p2,p3,p4,p3,p4); //最后两个参数用来判断最后一行时向左打印还是向右打印
		return list;
	}
	
	private void parttion(int[][] arr, ArrayList<Integer> list, int p1, int p2,
			int p3, int p4, int p5, int p6) {
		if (p1 <= p3 && p2 <= p4) { //进入循环的条件
			//只有一列时,需要判断向左打印还是向右打印
			if (p2 == p4) {	
				if (p6 % 2 == 0) {
					for (int i = 0; i < p3 - p1 + 1; i++) {
						System.out.print(arr[p1 + i][p4]+" ");
						list.add(arr[p1 + i][p4]);
					}
				} else {
					for (int i = 0; i < p3 - p1 + 1; i++) {
						System.out.print(arr[p3 - i][p2]+" ");
						list.add(arr[p3 - i][p2]);
					}
				}
				return;
			}
			//只有一行时.需要判断向左打印还是向右打印
			if (p1 == p3) { 
				if (p5 % 2 == 0) {
					for (int i = 0; i < p4 - p2 + 1; i++) {
						System.out.print(arr[p1][p2 + i]+" ");
						list.add(arr[p1][p2 + i]);
					}
				} else {
					for (int i = 0; i < p4 - p2 + 1; i++) {
						System.out.print(arr[p3][p4 - i]+" ");
						list.add(arr[p3][p4 - i]);
					}
				}
				return;
			}
			
			for (int i = 0; i < p4 - p2; i++) {
				System.out.print(arr[p1][p2 + i]+" ");
				list.add(arr[p1][p2 + i]);
			}
			for (int i = 0; i < p3 - p1; i++) {
				System.out.print(arr[p1 + i][p4]+" ");
				list.add(arr[p1 + i][p4]);
			}
			for (int i = 0; i < p4 - p2; i++) {
				System.out.print(arr[p3][p4 - i]+" ");
				list.add(arr[p3][p4 - i]);
			}
			for (int i = 0; i < p3 - p1; i++) {
				System.out.print(arr[p3 - i][p2]+" ");
				list.add(arr[p3 - i][p2]);
			}
			p1++;p2++;p3--;p4--;
			parttion(arr, list, p1, p2, p3, p4, p5, p6);
		}
	}

	//---------------------------------------------------------------------------------------
	private int[][] getMatr(int m,int n) {
		int[][] matr = new int[m][n];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				matr[i][j] = n*i+(j+1);			//生成的数为第几个数
			}
		}
		return matr;
	}
	
	//打印二维数组
	public void myPrint(int[][] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
