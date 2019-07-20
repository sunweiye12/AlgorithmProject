package 欢乐颂._08暴力递归_动态规划;

import org.junit.Test;

/*
 * 题目:求两字符序列的最长公共字符子序的长度-->提供给你两个字符串,求出最长的公共子序列,的长度
 * 		例如  abcbdab  bced  -->  最长公共子序列为bcd 
 
 */
public class _12两个字符串的最长公共子序列_升级 {
	
	@Test
	public void main() {
		String str1 = "ABCBDCAB";
		String str2 = "BDCABA";  //BDAB
		int maxLen = partion(str1,str2);
		System.out.println(maxLen);
	}

	private int partion(String str1, String str2) {
		return 0;
	}

}
