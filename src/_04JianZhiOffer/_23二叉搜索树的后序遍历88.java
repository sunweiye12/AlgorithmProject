package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * 		����������Yes,�������No��
 * 		ע:�������������������������ֶ�������ͬ��
 * 
 * ˼·:���������������ĺ������,���һ���ڵ�Ϊ���ڵ�,��������е�����,С�������Һ���
 * 		���Խ�������������һ���ڵ�ȥ��,��ʣ�µĲ��ֿ�������ͷ���ֳ�����������,���������������󲿷ֶ�С��root,�Ҳ��ֶ�����root
 * 		Ȼ�����εݹ�
 */
public class _23�����������ĺ������88 {

	@Test
	public void main() {
		int[] arr = {1,4,3,6,8,7,9}; //����һ����������������Ľ��һ��
		boolean isBST = partion(arr,0,arr.length-1);
		System.out.println(isBST);
	}

	private boolean partion(int[] arr, int start, int end) {
		//basecase(ֻ��һ���ڵ� �Ļ�Ҳ��ƽ�������)
		if (start >= end) {
			return true;
		}
		int index = start; //index���ڼ�¼���������ڵ��λ��
		for(index = start;index < end ;index++){
			if (arr[index] > arr[end]) { //���ҵ���һ����arr[end]���������,��ζ��indexָ���ҽڵ�ĵ�һ��λ��
				break;
			}
		}

		for (int i = index; i < end; i++) { //���������е��Һ���Ӧ�ö�����arr[end],������BST
			if (arr[i] <= arr[end]) {
				return false;
			}
		}
		//Ȼ���жϷָ����������Ƿ�ΪBST
		return partion(arr, start, index-1) && partion(arr, index, end-1);
	}
}
