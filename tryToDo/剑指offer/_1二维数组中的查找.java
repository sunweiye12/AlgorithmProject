package 剑指offer;

import org.junit.Test;

/*
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数
 */
public class _1二维数组中的查找 {
	
	@Test
	public void main() {
		int[][] matr = getMatr(5,5);
		myPrint(matr);
	}
	
	
    public boolean Find(int target, int [][] array) {

    	
    	return false;
    }
    
    
	
	//获取一个m行n列的矩阵队列-----------------------------------------
	private int[][] getMatr(int m,int n) {
		int[][] matr = new int[m][n];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				matr[i][j] = n*i+(j+1);			//生成的数为第几个数
//				matr[i][j] = (int)(Math.random()+0.7);		//只存在0和1的矩阵
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
