package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:�����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * 		����һ���������ַ�����S���������ѭ������Kλ������������
 * 		���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
 * ˼·:ͨ��������ʵ��:���ַ���ת��Ϊ�ַ�����
 */
public class _44����ת�ַ��� {

	@Test
	public void main() {
		String str = "abcXYZdef";
		int num = 3;
		String str1 = LeftRotateString(str, num);
		System.out.println(str1);
	}
	
	public String LeftRotateString(String str,int n) {
		//basecase
		if (str == null || str.equals("")) {
			return "";
		}
		char[] arr = str.toCharArray();
		for(int i = 0;i < n;i++){
			partion(arr); //�����ƶ�һλ
		}
		String ret = "";
		for (int i = 0; i < arr.length; i++) {
			ret += arr[i];
		}
		return ret;
    }

	private void partion(char[] arr) {
		if (arr.length==1) {
			return;
		}
		char tem = arr[0];
		for (int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1]; 
		}
		arr[arr.length-1] = tem;
	}
}
