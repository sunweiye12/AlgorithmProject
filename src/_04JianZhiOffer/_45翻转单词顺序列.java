package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish����������
 * 	��ȴ������������˼�����磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
 * 	Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 * 
 * ˼·:ͬ���ο�������������ʵ�ַ�ת,��ȡ����ĳ���len,��תlen/2�˼���
 * 		ע��:�˼�ֻ�ǵ��ʵ�˳���ǵ���,����ÿ������û�е�,��������˼·����
 * 		������͸��split������ԭ�����ַ����и�,Ȼ���ڰ��������˼·����
 */
public class _45��ת����˳���� {
	
	@Test
	public void main() {
//		String str = "student. a am I";
		String str = " ";
		String str1 = ReverseSentence(str);
		System.out.println(str1+"-");
	}
	
	public String ReverseSentence(String str) {
		//basecase
		if(str==null || str.equals("")){
			return "";
		}
		if(str.equals(" "))
			return " ";
		String[] arr = str.split(" ");
		int size = arr.length/2;
		for (int i = 0; i < size; i++) {
			swap(arr,i,arr.length-1-i);
		}
		String ret = "";
		for (String c : arr) {
			ret += c+" ";
		}
		return ret.trim();
    }

	private void swap(String[] arr, int i, int j) {
		String tem = arr[i];
		arr[i] = arr[j];
		arr[j] = tem;		
	}
}
