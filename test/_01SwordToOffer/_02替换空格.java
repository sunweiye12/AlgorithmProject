package _01SwordToOffer;

import org.junit.Test;

/*
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * 思路:由于Split()方法的诡异性导致在处理空格在遍及情况时非常诡异,
 * 		因此此题中采用的是将字符串转换成字符数组,然后再将其串联起来,如果遇到的字符是' ',则用"%20"代替
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
