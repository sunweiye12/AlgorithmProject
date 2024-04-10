package _04JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/*
 *��Ŀ: ����n���������ҳ�������С��K������
 *		��������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 *˼·:���������,����ǰk����
 */
public class _30��С��K���� {

	@Test
	public void main() {
		int[] input = {4,5,1,6,2,7,3,8};
		ArrayList<Integer> list = GetLeastNumbers_Solution(input, 10);
		System.out.println(list);
	}
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>(); //����һ�����ڷ��� ����
		//basecase
		if (input == null || input.length == 0 || k <= 0) {
			return list;
		}
		//Ĭ����������
		Arrays.sort(input); 
		int tem = 0;
		//������k��������Ԫ�ظ���ʱ,ȫ������******
		while(tem < k && tem < input.length){ 
			list.add(input[tem]);
			tem++;
		}
		return list;
    }
}
