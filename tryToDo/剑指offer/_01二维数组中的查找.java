package 剑指offer;

import org.junit.Test;

import com.sun.org.apache.regexp.internal.recompile;

/*
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数
 * 
 * 思路:从二维数组的右上角开始,只有两个选择,左面的比自己小,下面的比自己大
 */
public class _01二维数组中的查找 {
	
	@Test
	public void main() {
		int[][] matr = getMatr();
		myPrint(matr);
		System.out.println(Find(4, matr));
	}
	
	
    public boolean Find(int target, int [][] array) {
    	if (array==null) {
    		return false;
		}
    	int line = array.length;
    	int column = array[0].length;
    	//起始点的下标
    	int p1 = 0;
    	int p2 = column-1;
    	while(p1<line && p2 >= 0){
    		if (array[p1][p2] < target) {
    			p1++;
			} else if(array[p1][p2] > target){
				p2--;
			} else {
				return true;
			}
    	}
    	
    	return false;
    }
    
    
	
	//获取一个m行n列的矩阵队列-----------------------------------------
	private int[][] getMatr() {
		int[][] matr = {{1,2,3,5},
				{3,5,9,10},
				{7,8,13,14}};
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
