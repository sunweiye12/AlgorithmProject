package _03examination._0niuke;

import java.util.Scanner;

/*
 * 获取多行信息,盛放到二维数组中
 * 例如:
 * 2
 * 3
 * 1,2,3
 * 4,5,6
 * 第一行是二维数组的行数
 * 第二行是二维数组的列数
 * 接下来两行是信息
 */

public class _2处理多行输入 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //等待输入信息
		int n = sc.nextInt();  	//获取行数
		int m = sc.nextInt();	//获取列数
		int[][] arr = new int[n][m]; //构建二维数组
		for (int i = 0; i < arr[0].length; i++) {	//第一行开始获取每一行信息
			String line = sc.nextLine();
	        //2.将字符串切割成字符数组
	        String[] sArr = line.split(",");   //如果是其他分隔符,可以改变
	        //3.放到对应行的相应位置上
	        for (int j = 0; j < sArr.length; j++) {
	            arr[i][j] = Integer.parseInt(sArr[j]); // 将数字字符串转换成数字
	            System.out.println(arr[i][j]);
	        }
		}
	}
}
