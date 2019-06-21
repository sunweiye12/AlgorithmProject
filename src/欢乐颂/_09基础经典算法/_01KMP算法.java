package 欢乐颂._09基础经典算法;

import org.junit.Test;
/**
 * 	(用于解决的原始问题)题目:给定两个数组str1 和 str2 判断str1中是否有与str2相等的子串(子串问题)
 * 						如果有相等则返回此子串在str1中第一次出现的位置,否则返回-1
 * 思路1:str1中从第一个元素开始,和str2的第一个元素比较,如果相同在同时比较第二个,直到str2结束都相同,则返回true(str1开始的位置)
 * 		若在过程中遇到一个不相同,则从str1的第二个元素开始,依次类推,假设str1有M个字符,str2有N个字符,时间复杂度为O(M*N)
 * 
 * KMP详解:1.首先对于str2中的每一个字符而言,假设第k个字符,则0到k-1字符做对应的字符串,存在一个最长的前后缀匹配长度,将此长度匹配给k字符
 * 			成为k字符之前字符串的前后缀匹配长度,因此对于每一个元素都有一个其前面字符串的最长的前后缀匹配长度与之对应(此处规定0位置处为-1,1位置处为0)
 * 			因此可以创建一个和str2相同长度的字符串,存放每个元素,对应的其前字符串的最大前后缀匹配长度.
 * 	     2.在获得每一个字符其前面字符串最大的前后缀匹配长度以后开始进行加速(KMP是指三个人的名字)
 * 			<1>str1中从第一个元素开始,和str2的第一个元素比较,如果相同在同时比较第二个,直到str2结束都相同,则返回true(str1开始的位置)
 * 			定义甲,乙分别为str1和str2比较时的指针,如果乙指向了str2的我不元素时都相等.则说明找到了此子串,在str1中的起始位置为:甲-乙
 * 		    <2>现在假如说判断到一个位置上,甲和乙所指向的元素不相等,则此时拿出乙位置在next数组所对应的值(假设为k),为乙所指元素,之前字符串的
 * 			最长前后缀匹配长度,而此时的k就指向的是前缀的下一个元素,因此甲指针不等,乙指针指向k,然后开始继续甲乙比较,如果相等同时向下一个指针移动
 * 			,否则按照上面的原则继续跳转乙指针,直到对应的k为o则,则乙指针跳到了str2的头部
 * 		 3.Next指针的求解(是通过归纳法得到),(规定0位置处为-1,1位置处为0)假设0到i-1位置的next值都直到,求i位置处的next值,有两种情况:
 * 			<1>如果i-1所对应的值,与i-1的next值(假设为k),即和k对应的值如果相等,则i处的next值为i-1处的next值加1(即K+1)
 * 				*此处k所对应的值,也是i-1之前字符串,前缀的先一个字符
 * 			<2>如果i-1所对应的值,与i-1的next值(假设为k),即和k对应的值如果不相等,则k位置处的next值(假设为n),在与n位置的元素比较,如果相等
 * 				则则i处的next值为n+1,遇到next值为0时,i对应的next值也为0
 *
 * @author Administrator
 *
 */
public class _01KMP算法 {
	
	@Test
	public void main() {
		String str1 = "abcabcababaccc";
		String str2 = "bab";
		System.out.println(getIndexOf(str1, str2));
	}
	
	//返回str2在str1中的起始坐标(不包含返回-1)
	private int getIndexOf(String str1, String str2) {
		
		//BaseCase
		if (str1 == null || str2 == null || str1.length() < 1 || str1.length() < str2.length()) {
			return -1;
		}

		//获取两个字符串的字符数组
		char[] arrayStr1 = str1.toCharArray();
		char[] arrayStr2 = str2.toCharArray();
		int[] next = getNextArray(arrayStr2);	//获取str2的Next数组
		
		//定义两个指针甲乙
		int jia = 0;
		int yi = 0;
		
		//两个指针都没有越界则继续循环
		while (jia < arrayStr1.length && yi < arrayStr2.length) {
			if (arrayStr1[jia] == arrayStr2[yi]) {	//甲乙所对应的元素相同则同时向下移动 
				jia++;
				yi++;
			} else {
				if (next[yi] != -1) { //next所指向的值不为-1说明不是第一个数,yi还可以往前面跳
					yi = next[yi];		//**甲不变,乙移动.乙跳到他指向的元素所对应的next值所指向的位置,(即跳到其前缀的先一个字符的位置)
				} else {			  //如果next所指向的值为-1,说明乙跳到了str2第一个字符,不能再往前跳,从sht1的下一个字符开始比较
					jia++; 	//甲向下走一个
				}
			}
		}
		
		//如果跳出循环,则肯定是甲或乙至少有一个走到了字符串的头(如果是乙走到头的话,说明str1中包含str2的子串)
		if (yi == arrayStr2.length) {	//说明str1中包含str2的子串(起始坐标为甲指向的位置见去str2的长度)
			return jia - yi;
		}else{
			return -1;
		}
	}
	
	
	//传入一个字符数组,返回其所对应的next数组
	private int[] getNextArray(char[] arrayStr2) {
		
		//BaseCase--->如果长度为1或者2,直接返回
		if (arrayStr2.length == 1) {
			return new int[] { -1 };
		} else if (arrayStr2.length == 2) {
			return new int[] {-1,0};
		} 
		//创建一个与str2相同长度的next数组.并初始化前两个位置
		int[] next = new int[arrayStr2.length];
		next[0] = -1;
		next[1] = 0;
		
		//定义两个指针
		int i = 2; 	//next数组的下标(从第3个元素开始求,因为前给定)
		int cn = 0;	//代表每次要与i-1处值,进行比较的值的索引(当i=2是cn=0,因为i-1处的next值为0)
		//cn即代表位置,又代表前缀的长度
		
		//从第三个元素开始求出所有元素的next值.每次求当前next值时,只依赖于之前的next值
		while (i < next.length) {
			if (arrayStr2[i - 1] == arrayStr2[cn]) { //cn代表i-1位置的next数,ms[cn]代表此字符前缀的下一个字符
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
