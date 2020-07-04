package _02分类算法._02二维数组;

/**
 * 排好序的矩阵中找数
	【题目】 	给定一个有N*M的整型矩阵matrix和一个整数K，matrix的每一行和每一列都是排好序的。
			实现一个函数，判断K是否在matrix中。 
			例如：      	0 1 2 5 
					2 3 4 6 
					4 4 4 8 
					5 7 8 9 
			如果K为7，返回true；
			如果K为6，返回false。
	【要求】 时间复杂度为O(N+M)，额外空间复杂度为O(1)。
	思路:由于样本量是比较特殊的,所以可以得到比较优良的解决方案
	*	从右上角开始查找是否等于K,如果相等返回true,如果cur大于k就想左移动,如果cur小于K则向下移动
	*	移动后让cur指向当前值,循环比较直到走到最下行之后就只往左移动.或者直到走到最左行之后就只往下移动
 * @author Administrator
 *
 */
public class _04排好序的矩阵中找数 {
	public static void main(String[] args) {
	//排好序的矩阵中找数
		int[][] matr = getMatr(5,4);
		matr[3][0] = 12;
		matr[2][3] = 11;
		myPrint(matr);
		System.out.println("----------------");
		boolean contain = findNum(matr,12);
		System.out.println(contain);
		
	}
	
	private static boolean findNum(int[][] arr, int num) {
		int rows = arr.length-1;		//行数(最大列坐标)
		int columns = arr[0].length-1;	//列数(最大横坐标)
		int p1 = 0;
		int p2 = columns;
		//当指针既没有到达下端又没有到达左端时
		if (num==arr[rows][0]) {
			return true;
		}
		while(p1<rows&&p2>0){
			if (num>arr[p1][p2]) {		//如果num大于当前值就向下比较
				p1++;
			} else if(num<arr[p1][p2]){	//如果num小于当前值就向左比较
				p2--;
			} else {
				return true;
			}
		}
		
		//当已经到达左端,开始向下移动
		while(p1<rows){
			if(num>arr[p1][p2]){	
				p1++;
			} else if (num<arr[p1][p2]) {
				return false;
			}else{
				return true;
			}
		}
		//当已经到达下端
		while(p2>0){
			if(num<arr[p1][p2]){	
				p2--;
			} else if (num>arr[p1][p2]) {
				return false;
			}else{
				return true;
			}
		}
		return false;
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

