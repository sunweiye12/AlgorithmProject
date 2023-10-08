package _04JianZhiOffer;

import org.junit.Test;

/*
 * 题目:汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 		对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 		例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * 思路:通过数组来实现:将字符串转换为字符数组
 */
public class _44左旋转字符串 {

	@Test
	public void main() {
		String str = "abcXYZdef";
		int num = 3;
		String str1 = LeftRotateString(str, num);
		System.out.println(str1);
	}
	
	public String LeftRotateString(String str,int n) {
		//basecase
		if (str == null || str.equals("")) {
			return "";
		}
		char[] arr = str.toCharArray();
		for(int i = 0;i < n;i++){
			partion(arr); //向左移动一位
		}
		String ret = "";
		for (int i = 0; i < arr.length; i++) {
			ret += arr[i];
		}
		return ret;
    }

	private void partion(char[] arr) {
		if (arr.length==1) {
			return;
		}
		char tem = arr[0];
		for (int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1]; 
		}
		arr[arr.length-1] = tem;
	}
}
