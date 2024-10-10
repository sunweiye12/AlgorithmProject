package _01���������㷨;


public class _08�鲢����_2 {
	/**
	 * ʱ�临�Ӷ�: O(nlogn) O(nlogn) ---ƽ��---->O(nlogn)
	 * �ռ�ռ��: O(n)   ---->  �˴����÷���һ��������,��Ҳ��Ҫ����һ������Ŀռ�
	 * �ȶ���: �ȶ�
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6};
		mergeSort(arr,0,arr.length-1);  //��ԭ���������޸�
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	//�鲢����
	public static void mergeSort(int[] arr, int left, int right) {

	    if (left == right) {	//����Ϊֻ��һ��Ԫ��ʱ����
	       return;
	    }
	    
	    //��ȡ�м�ֵ
	    int mid = left+(( right - left) >> 1);  //�����ƶ�һλ�������2
	    
	    //���õݹ��������з�
	    mergeSort(arr, left, mid);
	    mergeSort(arr, mid + 1, right);
	    
	    //���úϲ�����,�ϲ��зֺõĲ���
	    merge(arr, left ,mid ,right);	
	}

	// �������Ѿ��ź���Ĳ��ֺϲ���һ�����򲿷�
	public static void merge(int[] arr, int left ,int mid ,int right) {

	    int[] result = new int[right - left + 1];  //����������,����Ϊ�������鳤��֮��
	    int p = 0;			//�½�������±�
	    int lp = left; 		//��ಿ���±�
	    int rp = mid+1; 	//�Ҳಿ���±�
	    
	    while (lp <= mid && rp <= right) {
	       result[p++] = (arr[lp] > arr[rp] ? arr[lp++] : arr[rp++]);
	    }
	    //������һ����������ʱ,��������
	    //�ֱ�û��Ū���Ԫ��ֱ����ӵ�������
	    while (lp <= mid) {
	       result[p++] = arr[lp++];
	    }
	    while (rp <= right) {
	       result[p++] = arr[rp++];
	    }
	    
	    //result���Ѿ��ź��������(��ֻ��arr������left��right��һ��)������ֵ��arr�Ĺ̶�λ������
	    for (int i = 0; i < result.length; i++) {
			arr[i+left] = result[i];
		}
	}

}
