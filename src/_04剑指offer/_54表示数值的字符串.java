package _04剑指offer;

import org.junit.Test;

/*
 * 题目:请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 	例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
 * 	但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 
 * 思路:不断做判断
 */
public class _54表示数值的字符串 {

	@Test
	public void main() {
		char[] str = "123.45e+6".toCharArray();
		boolean b = isNumeric(str);
		System.out.println(b);
	}
	public boolean isNumeric(char[] str) {
		//定义三个变量用来标记->符号、小数点、e是否出现过
		boolean sign = false;	//符号
		boolean decimal = false;//小数点
		boolean hasE = false;	//E
		
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length-1) return false; // 如果e出现在结尾,则false,(e后面一定要接数字)
                if (hasE) return false;  // 不能同时存在两个e
                hasE = true;
            }else if (str[i] == '+' || str[i] == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i-1] != 'e' && str[i-1] != 'E') return false;
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E') return false;
                //第一次出现
                sign = true;
            } else if (str[i] == '.') {
                // e后面不能接小数点，小数点不能出现两次 
                if (hasE || decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') // 不合法字符
                return false;
		}
		return true;
    }
}
