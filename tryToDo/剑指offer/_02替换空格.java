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
		StringBuffer str1 = new StringBuffer("We Are Happy");
		String str2 = replaceSpace(str1);
		System.out.println(str1);
		System.out.println(str2);
	}
	public String replaceSpace(StringBuffer str) {
		char[] strArr = str.toString().toCharArray();
        String strReturn = "";
        for(int i = 0;i < strArr.length;i++){
            if(strArr[i] == ' '){
                strReturn += "%20";
            } else {
                strReturn += strArr[i];
            }
        }
        return strReturn;
    }
}
