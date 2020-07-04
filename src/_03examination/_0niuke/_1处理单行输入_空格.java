package _03examination._0niuke;
import java.util.Scanner;

/*
 * 单行输入信息,用空格隔开 ---> 5 4 1 1
 * 或者每行一个数
			 * 1
			 * 2
			 * 3
 * 将他们转换成int存到数组中
 */
public class _1处理单行输入_空格 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //等待输入信息
		
		while(sc.hasNextInt()){  	//下面还有没有int数
			int i = sc.nextInt(); 	//获取下一个int数(之间用空格或者制表符连接)
			System.out.print(i + " ");
		}
	}
}
