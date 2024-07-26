package _01���������㷨;

public class _07��������_1 {
	/**
	 * ˼·��
     *
     * ʱ�临�Ӷ�: O(nlogn)  O(n^2) ---ƽ��---->O(nlogn)
	 * �ռ�ռ��: O(logn)  -  O(n)
	 * �ȶ���: ���ȶ�
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6};
		fastSort(arr,0,arr.length-1);		//��������Ҫ��������,�Լ����鿪ͷ�ͽ�β���±�
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	//��������
	public static void fastSort (int[] arr,int first,int last){
		if (first >= last) { //�ݹ��ֹ������(������ֻ��һ��Ԫ��)
			return;
		}
		
		int mid_value = arr[first];	//ȡ��һ��Ԫ����Ϊ��׼Ԫ�������Ƚϡ�
		int low = first;
		int high = last;
		
		while (low < high) {
			//�������������α�����,���򽻻�
			while((low < high) && (arr[high]>=mid_value)){
				high -= 1;
			}
			arr[low] = arr[high];
			
			//����������ʱ�α�����,���򽻻�
			while((low < high) && (arr[low]<=mid_value)){
				low += 1;
			}
			arr[high] = arr[low];
		}
		
		//��ѭ�����˳���ζ��low = high,����ָ������
		arr[low] = mid_value;
		
		//ͨ���ݹ齫����������п���
		fastSort(arr,first,low-1);
		fastSort(arr,low+1,last);
	}
	
}
