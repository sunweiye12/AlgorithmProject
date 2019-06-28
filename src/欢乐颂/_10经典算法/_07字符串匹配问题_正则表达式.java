package 欢乐颂._10经典算法;

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
 		2.加入说j没有来到尾部,j上面还有字符,这是应该考虑j+1的情况
 			1.如果j+1没有了,则只有i+1也没有,且
 */
public class _07字符串匹配问题_正则表达式 {
	
	@Test
	public void main() {
		String str = "aab";
		String exp = "c*a*b";
		//调用递归函数返回是否能匹配
		boolean h = isMatch(str.toCharArray(),exp.toCharArray(),0,0);
		System.out.println(h);
	}
	
	//递归解法	表示str[i...到最后]能否与exp[j...到最后]匹配成功
	private boolean isMatch(char[] str, char[] exp ,int i, int j) {
		//basecase j来到了exp的尾部时,不包含元素
		if (j == exp.length) {
			return i == str.length;
		}
		//exp的j上面还有字符,考虑j+1的情况
		if (j + 1 == exp.length || exp[j+1] != '*') {
			return i != str.length && (exp[j] == str[i] || exp[j] == '.')
					&& isMatch(str, exp, i + 1, j + 1);
		}
		
		//exp的j+1位置上不仅存在字符而且字符为 * 
		while(i != str.length && (exp[j] == str[i] || exp[j] == '.')){
			if (isMatch(str, exp, i, j+2)) {
				return true;
			}
			i++;
		}
		return isMatch(str, exp, i, j+2);
	}
}
