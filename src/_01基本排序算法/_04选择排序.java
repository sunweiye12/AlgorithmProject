package _01���������㷨;

public class _04ѡ������ {
	/**
     * ˵����
     * 1. ��Ҫ���� n-1 ��ѭ����ÿһ��ѭ��������Ὣ��ѡ�����С��Ԫ�أ������ݷŵ�i��λ���ϡ�
     * -->������ÿһ�־�����i��λ�úͱ�����ÿһ��Ԫ�ؽ��жԱȣ�����С��һ���ŵ�i��λ���ϣ�
     *
	 * ʱ�临�Ӷ�: O(n^2)
	 * �ռ�ռ��: O(1)
	 * �ȶ���: ���ȶ�
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6,0};
        selectSort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	
	//ѡ������
	public static void selectSort(int[] arr){
		for(int i = 0;i < arr.length-1; i++){
			for(int j = i+1; j < arr.length; j++){
				if(arr[i]>arr[j]){
					swap(arr,i,j);
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
