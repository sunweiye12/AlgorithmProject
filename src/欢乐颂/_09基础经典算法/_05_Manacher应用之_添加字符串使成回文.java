package 欢乐颂._09基础经典算法;

import org.junit.Test;

/**
 * 题目: 给定一个字符串,请你在后面添加最少的字符,使此字符串成为一个回文字符
 * 
 * 例如:abca  --> abcabc
 * 		123832  --> 1238321
 * 
 * 思路:此题是给定一个字符串添加最少字符形成一个回文,至少我们知道当添加这个字符串的逆序时,这样就可以轻松得到了一个回文
 * 	但是在题目中要求使用最少的字符,因此就转化为看Manacher问题,如何利用Manacher算法呢,在其中有一位定义为回文最右
 *  边界,当回文最右边界第一次到达最后一个元素的时候,我们将此时回文从原字符串中剪切,剩余的字符串逆序的方式添加到原字符串
 *  的后面,就形成的最小的回文字符串
 * @author Administrator
 *
 */
public class _05_Manacher应用之_添加字符串使成回文 {

	@Test
	public void main() {
		String str = "123";
		System.out.println(str);
		String huiwen = getShortHuiwen(str); //在原回文后面添加字符串后得到最短的回文
		System.out.println(huiwen);
		
		//验证其他函数效果 
//		System.out.println(str.length());
//		char[] cs = str.toCharArray();
//		char[] fuZhou = getFuZhou(cs);
//		for (int i = 0; i < fuZhou.length; i++) {
//			System.out.print(fuZhou[i]);
//		}
//		System.out.println();
//		
//		int c = getC(fuZhou);
//		System.out.println(c);
//		getShortHuiwen(str);
		
	}

	//给定字符串在后面添加字符串使之成为最短的回文
	//思路是根据Manacher来实现,当最大右回文边界到达最后一个元素时得到当时是回文中心C
	private String getShortHuiwen(String str) {
		if (str==null) {
			return "";
		}
		char[] str1 = str.toCharArray(); //字符串转换为字符数组
		char[] strArray = getFuZhou(str1); //调用方法添加虚轴
		
		int c = getC(strArray);
		//创建一个包含虚轴的新数组
		int i1 = 2*(strArray.length-c)-1;	//重复部分的长度
		int i2 = strArray.length-i1;		//非重复部分的长度
		char[] resultArr = new char[strArray.length+i2]; //长度计算
//		System.out.println(strArray.length);
//		System.out.println(resultArr.length);
		
		int index = 0;
		for (; index < strArray.length; index++) {
			resultArr[index] = strArray[index];
		}
		while(i2>0){
			resultArr[index++] = strArray[--i2];
		}
		
		//此时是resultArr是包含虚轴的字符数组
		//现在只需要将虚轴去掉并且转换成字符串就好了
		char[] res = new char[resultArr.length/2];
		for (int i = 0; i < res.length; i++) {
			res[i] = resultArr[2*i+1];
		}
		
//		for (int i = 0; i < res.length; i++) {
//			System.out.print(res[i]);
//		}
	
		String resultStr = String.valueOf(res);
		
		return resultStr;
	}

	//返回当最大回文右边界到达字符串尾部时回文中心的位置
	private int getC(char[] strArray) {
		int[] pArr = new int[strArray.length];  //回文半径数组
		int C = -1;	 //设置初始的回文中心的位置
		int pR = -1; //定义最大回文右边界的初始值为1
		//然后从每个元素为中心判断时回文的长度
		for (int i = 0; i < strArray.length; i++) {
			pArr[i] = i<pR ?Math.min(pArr[2*C-i], pR-i):1;
			while(i-pArr[i] >= 0 && i+pArr[i] < strArray.length){
				if (strArray[i-pArr[i]]==strArray[i+pArr[i]]) {
					pArr[i]++;
				} else {
					break;
				}
			}
			if (i+pArr[i]>pR) {
				pR = i+pArr[i];
				C = i;
			}
			//当最大回文右边界到达字符串尾部时,返回回文中心
			if (pR==strArray.length) {
				return C;
			}
		}
		return 1;
	}
	
	//为添加的字符数组添加虚轴
	private char[] getFuZhou(char[] str1) {
		char[] strArray = new char[str1.length*2+1];
		int index = 0;
		for (int i = 0; i < strArray.length; i++) {
			strArray[i] = i%2==0 ? '#' : str1[index++];
		}
		return strArray;
	}
}
