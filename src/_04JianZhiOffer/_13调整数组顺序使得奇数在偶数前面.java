package _04JianZhiOffer;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/*
 * ��Ŀ:����һ���������飬ʵ��һ�����������������������ֵ�˳��
	  ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�
	  ����֤������������ż����ż��֮������λ�ò���

      ˼·:1.����һ������arraylist,����ʢ������������,����mergeԭ��
      2.�����˱�����arr,��һ�齫���еĵ������Ž�ȥ,�ڶ����˵�е�ż���Ž�ȥ
      3.Ȼ���ڽ�arraylist��Ԫ�ض���ӵ�arr������
 */
public class _13��������˳��ʹ��������ż��ǰ�� {

	@Test
	public void main() {
		int[] arr = {1,3,9,4,2,8,7,1,4,11};
		reOrderArray(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void reOrderArray(int [] array) {
        List<Integer> list = new LinkedList<Integer>();
        
        for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) { //���������
				list.add(array[i]);
			}
		}
        for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) { //�����ż����
				list.add(array[i]);
			}
		}
        for (int i = 0; i < array.length; i++) {
        	array[i] = list.get(i);
		}
        
    }
}
