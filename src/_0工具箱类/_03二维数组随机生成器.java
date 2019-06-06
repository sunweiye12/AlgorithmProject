package _0工具箱类;

public class _03二维数组随机生成器 {

	
	public static void main(String[] args) {
		int[][] matr = getMatr(5,5);
		myPrint(matr);
	}
	
	//获取一个m行n列的矩阵队列
	private static int[][] getMatr(int m,int n) {
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
	public static void myPrint(int[][] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
