package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 * ˼·:����split()�����ĸ�����ʹ�Ĵ���߽�Ϊ�ո�ʱ�������Ѷ�,�˴����õ��ǽ��ַ���ת��Ϊ�ַ�����,
 * 		Ȼ�����ν�������������
 * 		����������ַ�Ϊ' '����"%20"������
 */
public class _02�滻�ո� {

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
