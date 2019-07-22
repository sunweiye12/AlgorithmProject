package 欢乐颂._06并查集和前缀树;

import org.junit.Test;

/**
 * 此问题如果涉及到分治思维可以用并查集来解决
 * 但此处可以用递归调用来解决
 * 问题:	一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右四个位置相连(斜着不算)，如果有一片1连在一起，这个部分叫做一个岛，
 * 		求一个矩阵中有多少个岛？
 * 例如:
 * 0 0 1 0 1 0
 * 1 1 1 0 1 0
 * 1 0 0 1 0 0
 * 0 0 0 0 0 0
 * 这个矩阵中有3个岛
 * 
 * 思路:从第一个元素开始按照从左到右从上到下的顺序开始遍历
 * 		当遇到的元素不是1就跳过,如果遇到1,说明走到了岛屿的边缘,然后以此节点为中心向上下左右扩散,如果扩散到的元素还是1,则继续扩散,直到扩散到的元素
 * 		不在是1结束,在扩散的过程中,将所有走到过的岛屿节点都改为-1,当所有扩散的结果都为0时说明此岛屿扩散结束,则岛屿数加1
 * 		然后从第一次进入岛屿的位置依次按照从左到右从上到下的顺序走,如果遇到1,重复上面操作.当遍历到尾部时遍历结束,输出岛屿地方数目
 * @author Administrator
 *
 */

public class _02岛问题 {
	
	@Test
	public void main() {
		int[][] matr = getMatr(5,4);
		myPrint(matr);
		System.out.println("----------");
		int num = getNumIsland(matr);
		System.out.println(num);
	}
	
	//传入一个二维数组返回二维数组中岛的个数
	private int getNumIsland(int[][] arr) {
		if (arr==null) {
			return 0;
		}
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j]==1) {
					num++;					//岛个数加一
					traverIsland(arr,i,j);	//遍历此岛,将所有的数都变为-1
				}
			}
		}
		return num;
	}

	//从i j的位置起,开始向上下左右遍历
	private void traverIsland(int[][] arr, int i, int j) {
		if (arr[i][j]==1) {
			arr[i][j]=-1;	//将此值置为-1
			//开始遍历其上下左右
			if (j>0) {
				traverIsland(arr, i, j-1);
			}
			if (j<arr[0].length-1) {
				traverIsland(arr, i, j+1);
			}
			if (i>0) {
				traverIsland(arr, i-1, j);
			}
			if (i<arr.length-1) {
				traverIsland(arr, i+1, j);
			}
		}
	}

	//------------------------工具类---------------工具类----------------工具类---------------工具类---------
	//获取一个m行n列的矩阵队列
	private int[][] getMatr(int m,int n) {
		int[][] matr = new int[m][n];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				matr[i][j] = (int)(Math.random()+0.5);
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
