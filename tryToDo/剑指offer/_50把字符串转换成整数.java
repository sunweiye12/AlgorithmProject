package 剑指offer;

import org.junit.Test;

/*
 * 题目:将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 		要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 思路:首先将子串转换为字符数组
 */
public class _50把字符串转换成整数 {

	@Test
	public void main() {
		String str = "-2147483647";
		int toInt = StrToInt(str);
		System.out.println(toInt);
	}
	
	public int StrToInt(String str) {
		//basecase
		if (str == null || str.length() == 0) {
			return 0;
		}
		//获取字符数组
		char[] arr = str.toCharArray();
		//符号标志位(判断有无符号位)
		boolean Fu = false; //默认为正数
		if (arr[0] == '+' || arr[0] == '-') {
			if (arr[0] == '-') Fu = true;
			
			char[] arr1 = new char[arr.length-1];
			for (int i = 0; i < arr1.length; i++) {
				arr1[i] = arr[i+1];
			}
			arr = arr1; //索引交换
		}
		
		//将arr代表的字符数组转换为int数组
		int[] arrInt = new int[arr.length];
		for (int i = 0; i < arrInt.length; i++) {
			if (arr[i] >= '0' && arr[i] <= '9') {
				arrInt[i] = (int)(arr[i]-'0');
			} else { //如果有不符合格式的直接返回
				return 0;
			}
		}
		int res = 0; //数字
		int ind = 1; //每次的进制
		for (int i = arrInt.length-1; i >= 0; i-- ) {
			int tem = arrInt[i] * ind;
			res += tem; 
			ind = ind * 10;
		}
		if (Fu) {
			return res * -1;
		}
		return res;
    }
}
