package _02分类算法._09基础经典算法;

import org.junit.Test;

/**
 * 题目:给定你一个字符串(例如:abcabc),只能在其尾部进行追加字符串
 * 	   使得添加以后的字符串,包含两个源字符串的子串,求最短的添加长度
 * 
 * 例如: abcabc  -->abcabcabcabc<包含两个,添加了源字符串的长度(6个)>  
 * 					abcabcabc<包含两个,添加了3个字符>
 * 
 * 
 *思路:可以利用KMP算法来解决此问题,假设给定的字符串str长度为N,
 *		则利用str字符串,返回一个N+1长度的next数组,在N+1的位置(即next的最后一个位置)
 *		存放的是,此字符串的最长前后缀匹配长度(假设为k),即代表前面k字符,与后面k字符相同
 *		,因此我们需要追加的是,前面k个字符除外的所有字符,即第k+1到N个字符
 *	
 *		--->获取添加以后的数组
 *
 * @author Administrator
 *
 */

public class _02KMP应用之_添加字符串 {
	
	@Test
	public void main() {
		String str0 = "abcabc";
		String str1 = "a";
		String str2 = "aa";
		String str3 = "ab";
		String str4 = "abc";
		String str5 = "abca";
		String str = endNextLength(str5);	//获取最短的添加长度
		System.out.println(str);
	}

	//传入一个字符串,计算在后面最少追加多少元素
	private String endNextLength(String str) {
		
		//BaseCase
		if (str==null||str.length()==0) {
			return "";
		} else if(str.length()==1) {
			return str + str.substring(0);
		}
		
		
		char[] charArray = str.toCharArray();//得到字符串对应的字符数组
		int[] nextArray = getNextArray(charArray);//得到此字符串所对应的next数组
		int cn = nextArray[nextArray.length-1];	//next的最后一个元素代表此字符串最大前后缀的匹配长度
//		System.out.println(nextArray.length);
		return str + str.substring(cn);
	}
	
	//传入一个字符数组,返回其所对应的next数组
	private int[] getNextArray(char[] str) {
		
		//BaseCase--->如果长度为1或者2,直接返回
		if (str.length == 1) {
			return new int[] { -1,0 };
		} 
		//创建一个比str2相同长度大1的next数组.并初始化前两个位置
		int[] next = new int[str.length+1];
		next[0] = -1;
		next[1] = 0;
		
		//定义两个指针
		int i = 2; 	//next数组的下标(从第3个元素开始求,因为前给定)
		int cn = 0;	//代表每次要与i-1处值,进行比较的值的索引(当i=2是cn=0,因为i-1处的next值为0)
		//cn即代表位置,又代表前缀的长度
		
		//从第三个元素开始求出所有元素的next值.每次求当前next值时,只依赖于之前的next值
		while (i < next.length) {
			if (str[i - 1] == str[cn]) { //cn代表i-1位置的next数,ms[cn]代表此字符前缀的下一个字符
				next[i] = cn+1;						//如果i-1位置和此字符前缀的下一个字符相等,则i位置的next为i-1位置的next数加1
				i++;	//i位置求出,在求下一个
				cn = next[i-1];  //cn一直指向的是i-1元素所对应的next值
			} else {	//如果不相等					
				if (cn > 0) { 
					cn = next[cn];	//令cn指向 cn字符前缀的下一个字符,即cn所对应的next数
				} else {		//直到cn等于0或-1时代表,此时i位置的next值为0
					next[i] = 0;
					i++;
				}
			}
		}
		
		//数组全部赋值结束后返回Next指针
		return next;
	}
}
