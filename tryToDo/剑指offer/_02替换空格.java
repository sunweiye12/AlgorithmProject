package 剑指offer;

import org.junit.Test;

/*
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * 思路:1.假如有多个连续空格如何
 */
public class _02替换空格 {

	@Test
	public void main() {
		StringBuffer str1 = new StringBuffer(" 你  好 好 ");
		String str2 = replaceSpace(str1);
//		System.out.println(str1);
//		System.out.println(str2);
	}
	public String replaceSpace(StringBuffer str) {
		if (str==null ) {
			return null;
		}
		if (str.equals(" ")) {
			return "%20";
		}
    	String[] strArr = str.toString().split(" ");
    	System.out.println(strArr.length);
    	for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
    	String strTem = "";
    	for (int i = 0; i < strArr.length; i++) {
    		if (i==strArr.length-1) {
    			strTem += strArr[i];
			} else{
				strTem += strArr[i] + "%20";
			}
		}
		return strTem;
    }
}
