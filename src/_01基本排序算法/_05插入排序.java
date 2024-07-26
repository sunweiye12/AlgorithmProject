package _01���������㷨;

public class _05�������� {
	/**
	 * ʱ�临�Ӷ�: O(n)  O(n^2)
	 * �ռ�ռ��: O(1)
	 * �ȶ���: �ȶ�
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6};
        insertSort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	
	/**��������
	 * ��Ϊ��һ��Ԫ���������,�ӵڶ���Ԫ�ؿ�ʼ(��ǰ����),�ӵڶ���Ԫ�ؿ�ʼ��ǰ��ıȽ�,����ȱ����ͽ���,Ȼ���ں�ǰһλ�Ƚ�,
	 * ֱ������ǰһλ������С��Ԫ��,�ͽ���ѭ��(����ѭ����������,��������ͷ��)
	 * @param arr
	 */
	public static void insertSort(int[] arr){
		for(int i = 1;i < arr.length; i++){ //�ӵڶ����ڵ㿪ʼ��ǰ����
			for(int j = i; j > 0; j--){		//ÿ���ڵ���ཻ���Ĵ���
				if(arr[j] < arr[j-1]){	    //�������������ǰ���С�ͽ���λ��
					swap(arr,j,j-1);
				} else{						//�������ѭ��
					break;
				}
			}
			
		}
	}
	
	//Ԫ�ؽ����ķ���
	private static void swap(int[] arr,int i, int j) {
		arr[i]   = arr[i]^arr[j];
		arr[j]   = arr[i]^arr[j];
		arr[i]   = arr[i]^arr[j];
	}
}
