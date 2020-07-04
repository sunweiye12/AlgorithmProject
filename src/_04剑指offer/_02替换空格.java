package _04剑指offer;

import org.junit.Test;

/*
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 思路:基于split()方法的复杂性使的处理边界为空格时增加了难度,此处利用的是将字符串转化为字符数组,
 * 		然后依次将它们链接起来
 * 		如果遇到的字符为' '则用"%20"来代替
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
