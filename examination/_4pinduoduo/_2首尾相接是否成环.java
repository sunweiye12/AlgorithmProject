package _4pinduoduo;

/*
 * 题意:提供一个字符串数组,判断相邻字符串是否首尾相接,,并且最后一个字符串的最后一个字符和第一个个字符串的第一个字符
 * 	相接,形成首尾相连的环(规定字符串数组至少有两个元素,每个字符串至少有两个元素)
 * 	如果能形成则输出 true  否则 false
 */
public class _2首尾相接是否成环 {
	public static void main(String[] args) {
		String[] arr = {"1328","81"};
		partion(arr);
	}

	private static void partion(String[] arr) {
		//basecase
		//第一个字符传
		char[] firstStr = arr[0].toCharArray();
		char frist = firstStr[0]; //第一个字符传的第一个字符
		char temLast = firstStr[firstStr.length-1];
		for (int i = 1; i < arr.length; i++) {
			char[] temArr = arr[i].toCharArray();
			if (temLast == temArr[0]) {
				temLast = temArr[temArr.length-1];
			} else{
				System.out.println("false");
				return;
			}
		}
		if (frist != temLast) {
			System.out.println("false");
			return;
		}
		System.out.println("true");
	}
}
