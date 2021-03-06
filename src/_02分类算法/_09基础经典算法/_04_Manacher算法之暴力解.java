package _02分类算法._09基础经典算法;

import org.junit.Test;

/**
 * (Manacher算法用于解决原始问题)
 * 题目:给定一个字符串,返回字符串中最长回文子串的长度...(子串中若有回文,返回最长的回文长度)
 * 		例如:123321abc --> 最长回文为123321 因此返回长度 6
 * 			a1a  返回3
 * 			123abc  没有回文,则返回1
 * 			12abbad 回文为abba,返回4
 * 暴力解法:
 * 		思路1:对于奇数回文,从第一个元素开始遍历,判断以此元素为中心能否形成回文,如果能形成则记录回文的长度
 * 			对于偶回文,从第一个元素开始遍历,判断以此元素和其下一个元素为中心能否形成偶回文,如果能则记录其长度
 * 		思路2:针对上面的操作,需要分成偶回文和奇回文来讨论,还可以通过增加虚轴的方式来化简,之后只需要看每个元素的奇数回文长度
 * 				例如: a123321  --> # a # 1 # 2 # 3 # 3 # 2 # 1 #
 * 		转换后每个字符对应奇回文长度为->:1 3 1 3 1 3 1 3 13 3 1 3 1 3 1  -->最大的数为13 因此最长的回文长度为13/2=6
 * 
 * 				例如: a12321  --> # a # 1 # 2 # 3  # 2 # 1 #
 * 		转换后每个字符对应奇回文长度-->:1 3 1 3 1 3 1 11 1 3 1 3 1      -->最大的数为11 因此最长的回文长度为11/2=5
 * 		注意点:虚轴添加的特殊字符,可以为任意字符(不一定是源字符串中不包含的字符),因为在比较的过程中始终都是虚轴和虚轴比较,实轴和实轴比较
 * 	时间复杂度为:O(N^2)
 * 
 * Manacher算法的优化:
 * 	在Manacher算法中存在以下几个概念,
 * 		回文直径:以某一个数组为中心形成的回文的长度
 * 		回文半径数组:字符串每一个元素所对应的回文半径所形成的数组
 * 		当前最大回文右边界:从第一个元素开始记录回文的右边界,每次只记录最右面的那个回文右边界,和其第一次对应的回文中心(起始指向-1)
 * 		回文中心:回文右边界第一次到达时对应是回文中心
 *   	**当我们拿到回文中心数组的时候,数组中最大的那个数就是我们要求的最大回文长度(右边界问题要扣)
 *   我们如何求得对应的回文半径数组,在此处假设要求下表为i的元素对应的回文半径,我们假设i之前的回文半径
 *   已经得到,可以得到当前的最大回文右边界(R)和对应回文中心(c);我们能将将情况分为四种:
 *   1.假设i在R右面(以后成为外部或内部) --> 则直接通过暴力的方式来求得回文半径
 *   2.如果i在R的内部有三种情况
 *   (1)i关于c的对称点i'的回文范围在L和R内部(其实只考虑左侧)
 *   	此时i的回文半径与i'相同
 *   (2)i关于c的对称点i'的回文范围在L和R外部
 *   	此时i的回文半径为R-i
 *   (3)i关于c的对称点i'的回文范围正好和L压线
 *   	此时i的回文半径要借助暴力的方法来获得,只不过可以直接比较R下一个元素和i对称的元素开始比较
 * 
 * @author Administrator
 *
 */
public class _04_Manacher算法之暴力解 {
	
	@Test
	public void main() {
		
		String str = "sas";
		//调用暴力解法获得结果
		int maxLength = getMaxHuiWenLength(str);
		System.out.println(maxLength);   //3/2=1  -->  采用取余法,只留整数部分
		
	}
	
	//题的暴力解决方式
	private int getMaxHuiWenLength(String str) {
		if (str==null) {
			return 0;
		}
		
		char[] str1 = str.toCharArray(); //字符串转换为字符数组
		char[] strArray = getFuZhou(str1); //调用方法添加虚轴
		int maxlength = Integer.MIN_VALUE;	//起初将最大值设置为最小值,遇到比他大的就替换,最后返回最大的值
		//然后从每个元素为中心判断时回文的长度
		for (int i = 0; i < strArray.length; i++) {
			int size = getLength(i,strArray); //调用方法获取该下标对应字符的长度
			maxlength = Math.max(maxlength,size); //将较大的赋值给maxlength
		}
		return maxlength/2;
	}
	
	//给定下标即字符列表,返回此下标为中心的回文长度
	private int getLength(int i, char[] strArray) {
		int len = 1; //回文的长度
		int index = 1;	//判断处距离回文中心的长度
		//只要没有越界,并且还对称则左右延长
		while(i-index >= 0 && 
				i+index < strArray.length &&
				strArray[i-index]==strArray[i+index]){
			
				len= len+2; //每次长度加2
				index++;	//向外扩一位
		}
		return len;
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
