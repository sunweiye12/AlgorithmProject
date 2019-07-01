package _0niuke;
import java.util.Scanner;

/*
 * 单行输入信息,用逗号隔开 ---> 5,4,1,1
 * 将他们转换成int存到数组中
 */
public class _1处理单行输入_逗号 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //等待输入信息
		//1.读取一行的字符串
        String line = sc.nextLine();
        //2.将字符串切割成字符数组
        String[] sArr = line.split(",");
        //3.创建int数组,将字符数组转型存放到int数组中
        int[] arr = new int[sArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(sArr[i]); // 将数字字符串转换成数字
            System.out.print(arr[i] + " ");
        }
	}
}
