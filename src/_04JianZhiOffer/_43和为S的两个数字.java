package _04JianZhiOffer;
import java.util.ArrayList;

import org.junit.Test;
/*
 *��Ŀ:����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 *
 *˼·:	��һ��λ����Ϊ��1��Ԫ�ؿ�ʼ�����ҵ�2��Ԫ��,ֱ������Ԫ�صĺ͵���sum,����sumʱ����
 *	  	���Եڶ�λ����Ϊ��1��Ԫ��ʼ�����ҵ�2��Ԫ��,ͬ��
 *		ֱ���ҵ�ͷ,���߳���sum/2ʱ����,���û�ҵ����ؿ�,���򷵻س˻���С��Ԫ��
 */
public class _43��ΪS���������� {
	@Test
	public void main() {
		int[] arr = {1,2,6,7,8,9};
		int sum = 9;
		ArrayList<Integer> list = FindNumbersWithSum(arr,sum);
		System.out.println(list);
	}

	public ArrayList<Integer> FindNumbersWithSum(int [] arr,int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();  //���ڷ��صĽ��
		//basecase
		if (arr == null || arr.length < 2) {
			return list;
		}
		for (int x = 0; x < arr.length && arr[x] <= sum/2; x++) { //���
			for (int y = x+1; y < arr.length; y++) {  //��x��ϴ�¸�λ�ÿ�ʼ�ҵڶ���Ԫ��
				if (arr[x] + arr[y] == sum) {
					list.add(arr[x]);
					list.add(arr[y]);
				}
			}
		}
		int num = list.size()/2; //һ����num��Ԫ��
		if (num == 0) {
			return list;
		} else{
			//�õ���һ��
			int tem1 = list.remove(0); 
			int tem2 = list.remove(0);
			for (int i = 1; i < num; i++) {
				int tem3 = list.remove(0); 
				int tem4 = list.remove(0); 
				if ((tem1*tem2)>(tem3*tem4)) {
					tem1 = tem3;
					tem2 = tem4;
				}
			}
			list.add(tem1);
			list.add(tem2);
			return list;
		}
    }
}
