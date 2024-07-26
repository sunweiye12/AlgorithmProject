package _01���������㷨;

public class _03ð������ {
/**
 * ˼·��
 * 1. ��Ҫ����n-1�ֱȽϣ���ѭ����
 * 2. ÿһ�ֶ���Ҫ�Ƚ� n-1-i ��,����һ���������Ǹ����ŵ� n-1-id λ���ϡ� ��ÿ�ֱȽ��ж���������һ��ֵ���ƣ�
 * �Ż���ʩ�� ���ӵ���һ����ʶλ�������ʶλ���������ĳһ�ֱȽϺ󣬱ȽϵĹ��������û�з���������֤���������Ѿ������ˣ�����ֹ���漸�ֵĽ���
 * ʱ�临�Ӷ�: O(n) -> O(n^2)
 * �ռ�ռ��: O(1)
 * �ȶ���: �ȶ�
 * @param args
 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6};
        bubbleSort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	
	//ð������
	public static void bubbleSort(int[] arr){
		for(int i = 0;i < arr.length-1; i++){
			boolean flag = true;  // ���ӵ���һ����ʶλ�������ʶλ���������ĳһ�ֱȽϺ󣬱ȽϵĹ��������û�з���������֤���������Ѿ������ˣ�����ֹ���漸�ֵĽ���
			for(int j = 0; j < arr.length-1-i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					flag = false;
				}
			}
			if(flag){
				break;
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
