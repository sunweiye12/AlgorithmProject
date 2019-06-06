package 参考;

public class Code_01_KMP {

	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str, match));

	}
	
	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;	//甲
		int mi = 0;	//乙 
		int[] next = getNextArray(ms);	//获取Next数组
		while (si < ss.length && mi < ms.length) {
			if (ss[si] == ms[mi]) {	//甲乙同时移动 
				si++;
				mi++;
			} else if (next[mi] == -1) { //0位左对应的字符,即第一个字符
				si++; 	//甲向下走一个
			} else {	//甲不变,乙移动
				mi = next[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}

	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2; //下标
		int cn = 0;	//代表pos-1位置的next数,,我跳到的位置(就是每次前面要比较的的位置)
		//cn即代表位置,有代表前缀的长度
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) { //cn代表pos-1位置的next数,ms[cn]代表此字符前缀的下一个字符
				next[pos] = ++cn;	//如果pos-1位置和此字符前缀的下一个字符相等,则pos位置为pos-1位置的next数加一
				pos++;
			} else if (cn > 0) { //在两者不相等的情况下
				cn = next[cn];	//令cn等于 pos-1字符前缀的下一个字符所对应的next数
			} else {	//知道cn等于0或-1时代表,此时next数为0
				next[pos] = 0;
				pos++;
			}
		}
		return next;
	}

	

}
