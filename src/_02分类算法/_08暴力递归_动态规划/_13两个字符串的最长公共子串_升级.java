package _02分类算法._08暴力递归_动态规划;
/*
 * 题目:求两字符序列的最长公共字符子串的长度-->提供给你两个字符串,求出最长的公共子序列
 * 		例如  abcbdab  bced  -->  最长公共子序列为bc 
 */
public class _13两个字符串的最长公共子串_升级 {

	public static void main(String[] args) {
		String str1 = "aaffffsfabcdfasf";
		String str2 = "aaaadfsabcdfsdb";  //公共abcdf
		int num = partion(str1,str2);
		System.out.println(num);
	}

	private static int partion(String str1, String str2) {
		return 1;
	}
}
