package _02分类算法._10经典问题;

import org.junit.Test;

/*
 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
	'.' 匹配任意单个字符。
 	'*' 匹配零个或多个前面的元素。(不能放到首位)
	匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
说明:
	s 可能为空，且只包含从 a-z 的小写字母。
	p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
例子:
	输入: s = "aa"	p = "a"
	输出: false  解释: "a" 无法匹配 "aa" 整个字符串
	输入: s = "aab"  p = "c*a*b"
	输出: true 	解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
	输入: s = "aa"	p = "a*"
	输出: true	解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
	
解题思路:递归版;
 	设计一个递归函数参数为(str,exp,i,j)表示exp从j位置开始能不能匹配上str从i位置开始的字符串
 		1.假设j位置为exp.length,来到了末尾没有元素,只有当i位置也来到str.length时,才会返回true
 		2.假如说j没有来到尾部,j上面还有字符,这是应该考虑j+1的情况
 			1.如果j+1没有了,则只有i+1也没有,且
 */
public class _07字符串匹配问题_正则表达式 {
	
	@Test
	public void main() {
		String str = "aab";
		String exp = "c*a*b";
		//调用递归函数返回是否能匹配(str从0开始,exp从0开始是否能匹配上)
		boolean h = isMatch(str.toCharArray(),exp.toCharArray(),0,0);
		System.out.println(h);
	}
	
	//递归解法	表示str[i...到最后]能否被exp[j...到最后]的字符串匹配成功 || (前面的不用考虑)
	private boolean isMatch(char[] str, char[] exp ,int i, int j) {
		//basecase j来到了exp的尾部时,不包含元素
		//有效性检验：exp到尾没有元素了，只有str也到尾没有元素了，才匹配成功
		if (i == str.length && j == exp.length) { 
			return true;
		}
		//exp先到尾没有元素了，而str没有到达尾部,则匹配失败
		if (i != str.length && j == exp.length) {
		    return false;
		}
		
		//因为*这个字符比较特殊,因此判断i~ 和j~ 时 要考虑 j+1位置是否为 * (首先j+1不越界)
		//	1.如果j+1位置上不是*,则如果匹配成功必须有i和j的位置能匹配上即:exp[j] == str[i] || exp[j] == '.'  ,否则一定false
		//		当满足上面条件时(i和j的位置能匹配上),i~ 和j~ 都能匹配上,必须还有isMatch(str,exp,i+1,j+1)为true
		//	2.如果j+1位置上式*,如果j+1位置为*,则将j和*看做整体
		//		1.如果i位置和j位置匹配不成功,则只能让j位置的数为0个,问题转换为isMatch(str,exp,i,j+2)
		//		2.如果i位置和j位置匹配成功,则j*,为0个j时,如果isMatch(str,exp,i,j+2)能成功就返回true,否则
		//							则j*,为1个j时,如果isMatch(str,exp,i+1,j+2)能成功就返回true,否则
		//							则j*,为2个j时,如果isMatch(str,exp,i+2,j+2)能成功就返回true,否则,直到i越界
		
		//当j到达终止位置的时候,也就是最后一个字符时,则必须有 
		if (j == exp.length - 1 || exp[j+1] != '*') { //当exp最后一个字符,或者exp
			return i != str.length && (exp[j] == str[i] || exp[j] == '.')
					&& isMatch(str, exp, i + 1, j + 1);
		}
		
		//exp的j+1的字符为 * ,并且i和j位置的字符可以匹配上 
		while(i != str.length &&  (exp[j] == str[i] || exp[j] == '.')){
			if (isMatch(str, exp, i, j+2)) {
				return true;
			}
			i++;
		}
		//exp的j+1的字符为 * ,并且i和j位置的字符不可以匹配 
		return isMatch(str, exp, i, j+2);
	}
}
