package _04JianZhiOffer;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/*
 * ��Ŀ:����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * 		������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 * 
 * ˼·:����Array��sort�ŷ������,�����Զ����������
 */
public class _33�������ų���С���� {

	@Test
	public void main() {
		int[] arr = {3,32,321};
		String minNum = PrintMinNumber(arr);
		System.out.println(minNum);
	}
	
	public String PrintMinNumber(int[] arr) {
		String[] arr1 = new String[arr.length];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = String.valueOf(arr[i]);
		}
		//ͨ���趨�ıȽϲ�������������(�Զ����������ʱ**ֻ�ܹ��������������ͽ�������)
		Arrays.sort( arr1,new Comparator<String>() {
			public int compare(String o1, String o2) {
				return (o1+o2).compareTo(o2+o1);  //�ַ������õıȽϷ���compareTo
			}
		});
		String result = "";
		//������õ��ַ�������ƴ�ӳ��ַ���
		for (int i = 0; i < arr1.length; i++) {
			result += arr1[i];
		}
		return result;
    }
}
