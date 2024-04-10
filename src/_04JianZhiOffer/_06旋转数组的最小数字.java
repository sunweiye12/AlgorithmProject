package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� 
 * 		����һ���Ǽ�����������һ����ת��
 * 		�����ת�������СԪ�ء� 
 * 		��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * 		 NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * ˼·1:����ԭ�����ǷǼ����������,�����˵����һ���Լ�����һ��λ��һ�����ڵ��ڱ���  ����{1,2,3,4,5}
 * 		����ת�������������ȵ���(�����),Ȼ��֪�����������Ԫ�ر��Լ���С,��˵����һ��Ԫ�ؾ���ԭ�����ͷԪ��,����С     ����{3,4,5,1,2}
 * 		�������������,��û���ҵ�,˵��,����û�н���,��һ��Ϊ��С��Ԫ��   O(n)
 * ˼·2:����һ��ȫ����Сֵ��������,������Сֵ   O(n)
 * �Ż�˼·3:���ö��ַ����������⣬low = 0,high = length-1,mid = low + (high - low)/2
		��Ҫ�������������
		(1)array[mid] > array[high]:��ʱ��С����һ����mid���ұߡ�low = mid + 1
		(2)array[mid] == array[high]:�������������array���� [1,0,1,1,1] ����[1,1,1,0,1]����ʱ��С���ֲ����ж���mid���
			�����ұ�,��ʱֻ��һ��һ���� :high = high - 1
		(3)array[mid] < array[high]:��ʱ��С����һ������array[mid]������mid����ߡ���Ϊ�ұ߱�Ȼ���ǵ����ġ�
			��:high = mid
 */
public class _06��ת�������С���� {

	@Test
	public void main() {

	}
	
	
	public int minNumberInRotateArray(int [] array) {
		//basecase
		if (array == null || array.length == 0) {
			return 0;
		}
		if (array.length == 1) {
			return array[0];
		}
		for (int i = 0; i < array.length-1; i++) {
			if (array[i]>array[i+1]) { //�����һ��Ԫ�ر��Լ�С��˵��,��һ��Ԫ�ؾ���ԭ����ĵ�һ��Ԫ��,���䷵��
				return array[i+1];
			}
		}
		return array[0];	//���������һ�鶼û���ҳ�,��˵��,��С��Ԫ��Ϊ��һ��Ԫ��
    }
	
	public int minNumberInRotateArray1(int [] array) {
		//basecase
		if (array == null || array.length == 0) {
			return 0;
		}
		if (array.length == 1) {
			return array[0];
		}
		for (int i = array.length-1; i > 0; i--) {
			if (array[i] > array[0]) { 		//��������Ԫ����ǰ��.���ҵ���һ����array[0]���Ԫ��ʱ,ֹͣ�����һ��
				return array[i+1];
			}
		}
		return array[0];	//���������һ�鶼û���ҳ�,��˵��,��С��Ԫ��Ϊ��һ��Ԫ��
    }
	
	public int minNumberInRotateArray3(int [] array) {
        int low = 0 ; int high = array.length - 1;   
        while(low < high){
            int mid = low + (high - low) / 2;        
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }   
        }
        return array[low];
    }
	
	
}
