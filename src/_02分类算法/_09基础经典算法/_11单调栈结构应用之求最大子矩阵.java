package _02分类算法._09基础经典算法;

import java.util.Stack;

import org.junit.Test;

/**
 * 求最大子矩阵的大小
 * 题目:给定一个整形矩阵map,其中的值只有0和1两种,求其中全是1的矩形区域中,最大那块矩形的面积
 * 例如:  1 1 1 0
 * 		其中,最大的矩形面积为3
 * 再如:
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * 		其中最大矩形面积为6
 * 
 * 输入一个二维矩阵,返回最大面积	
 * 
 * 思路:
 *     1   1   1  
 *   1 1   1   1 1
 * 1 1 1 1 1   1 1
 * 1 1 1 1 1 1 1 1
 * 对于一个条形图而言,对于第i条通过单调栈可以找到左右侧第一个比他矮的条,那么位于这两条内侧的条形,就可以形成
 * 一个以原条为高的矩形,每一条都可以按照此方式来得到一个以此条为高的最大矩形,保留一个全局最大量记录就可以了,得到这个最大值
 * 
 * 此题中可以利用这个四星来解决:
 * 每一行的进行分析,第一个此将第一行作为一个条形表分析,然后再分析前两行,当第二行的元素为1时条的高度加1,否则清空高度
 *
 */
public class _11单调栈结构应用之求最大子矩阵 {

	@Test
	public void main() {
		int[][] matr = getMatr(4,7);
//		int[][] matr = {{1,0,1,1},{0,0,1,1},{1,0,1,1},{1,0,0,1}};
		myPrint(matr);
		int area = getMaxArea(matr);
		System.out.println(area);
	}
	
	//传入二维数组,返回最大矩形面积
	private int getMaxArea(int[][] map) {
		//basecase
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		int[] table = new int[map[0].length]; 	//创建一个条形表,长度为每一行的长度
		
//		System.out.println(map.length);//列数
		int max = Integer.MIN_VALUE;
		for (int j = 0; j < map.length; j++) {	//遍历每一列
			for (int i = 0; i < table.length; i++) { //更新条形图
				table[i] = map[j][i]==0 ? 0 : table[i]+1;
			}
			int colMax = getColumnMax(table);	//调用方法返回此条形图中中的最大面积
			max = Math.max(max, colMax);
		}
		return max;
	}

	//给我一个条形表,返回次条形表中的的最爱的面积(利用到单调栈)
	private int getColumnMax(int[] arr) {
		int max = Integer.MIN_VALUE; //维护一个最大值
		Stack<Integer> stack = new Stack<Integer>(); //求两侧第一个小的数(底到顶-->从小到大)
		//所有元素尝试进栈
		for (int i = 0; i < arr.length; i++) {
			while(!stack.isEmpty()&&arr[stack.peek()]>arr[i]){//头部不符合预期就弹栈
				int high = arr[stack.pop()];
				int j = stack.isEmpty() ? -1 :stack.peek();
				int width = i-j-1;
				max = Math.max(max, high*width);

			}
			//正常那个情况添加
			stack.push(i);
		}
		//向外弹出元素
		while(!stack.isEmpty()){
			int high = arr[stack.pop()];
			int width = stack.isEmpty() ? -1 :stack.peek();
			max = Math.max(max, high*(arr.length-width-1));
			
		}
		return max;
	}

	//----------------工具方法----------------工具方法----------------工具方法----------------工具方法
	//获取一个m行n列的矩阵队列
	private  int[][] getMatr(int m,int n) {
		int[][] matr = new int[m][n];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				matr[i][j] = (int)(Math.random()+0.7);		//只存在0和1的矩阵
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
