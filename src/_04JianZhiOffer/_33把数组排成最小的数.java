package _04JianZhiOffer;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/*
 * 题目:输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 		例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * 思路:利用Array的sort放法来完成,并且自定义排序策略
 */
public class _33把数组排成最小的数 {

	@Test
	public void main() {
		int[] arr = {3,32,321};
		String minNum = PrintMinNumber(arr);
		System.out.println(minNum);
	}
	
	public String PrintMinNumber(int[] arr) {
		String[] arr1 = new String[arr.length];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = String.valueOf(arr[i]);
		}
		//通过设定的比较策略来进行排序(自定义排序策略时**只能够对引用数据类型进行排序)
		Arrays.sort( arr1,new Comparator<String>() {
			public int compare(String o1, String o2) {
				return (o1+o2).compareTo(o2+o1);  //字符串内置的比较方法compareTo
			}
		});
		String result = "";
		//将排序好的字符串数组拼接成字符串
		for (int i = 0; i < arr1.length; i++) {
			result += arr1[i];
		}
		return result;
    }
}
