package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:��һ���ַ���ת����һ������(ʵ��Integer.valueOf(string)�Ĺ��ܣ�����string����������Ҫ��ʱ����0)��
 * 		Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
 * ˼·:���Ƚ��Ӵ�ת��Ϊ�ַ�����
 */
public class _50���ַ���ת�������� {

	@Test
	public void main() {
		String str = "-2147483647";
		int toInt = StrToInt(str);
		System.out.println(toInt);
	}
	
	public int StrToInt(String str) {
		//basecase
		if (str == null || str.length() == 0) {
			return 0;
		}
		//��ȡ�ַ�����
		char[] arr = str.toCharArray();
		//���ű�־λ(�ж����޷���λ)
		boolean Fu = false; //Ĭ��Ϊ����
		if (arr[0] == '+' || arr[0] == '-') {
			if (arr[0] == '-') Fu = true;
			
			char[] arr1 = new char[arr.length-1];
			for (int i = 0; i < arr1.length; i++) {
				arr1[i] = arr[i+1];
			}
			arr = arr1; //��������
		}
		
		//��arr������ַ�����ת��Ϊint����
		int[] arrInt = new int[arr.length];
		for (int i = 0; i < arrInt.length; i++) {
			if (arr[i] >= '0' && arr[i] <= '9') {
				arrInt[i] = (int)(arr[i]-'0');
			} else { //����в����ϸ�ʽ��ֱ�ӷ���
				return 0;
			}
		}
		int res = 0; //���ص�����
		int ind = 1; //ÿ�εĽ���
		for (int i = arrInt.length-1; i >= 0; i-- ) {
			int tem = arrInt[i] * ind;
			res += tem; 
			ind = ind * 10;
		}
		if (Fu) {
			return res * -1;
		}
		return res;
    }
}
