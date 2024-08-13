package _01���������㷨;


public class _08�鲢����_1 {
	/**
	 * ʱ�临�Ӷ�: O(nlogn) O(nlogn) ---ƽ��---->O(nlogn)
	 * �ռ�ռ��: O(n)   ---->  �鲢���򷵻�һ�����������Կռ�ռ�ô�
	 * �ȶ���: �ȶ�
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6};
		int[] arr1 = mergeSort(arr,0,arr.length-1);//�����µ�����
		for (int i : arr1) {
			System.out.print(i + " ");
		}
	}
	
	//�鲢����(����һ����������)
	public static int[] mergeSort(int[] arr, int left, int right) {

	    if (left == right) {	//����Ϊֻ��һ��Ԫ��ʱ����Ԫ�ر���
	       return new int[] {arr[left]};
	    }
	    int mid = right+(( left - right) >> 1);  // ���м�ֵ����ֹ�������������ֳ�������
	    
	    int[] l = mergeSort(arr, left, mid);
	    int[] r = mergeSort(arr, mid + 1, right);
	    return merge(l, r);
	}

	// �������Ѿ��ź��������ϲ���һ����������
	public static int[] merge(int[] l, int[] r) {

	    int[] result = new int[l.length + r.length];  //����������,����Ϊ�������鳤��֮��
	    int p = 0;	//�½�������±�
	    int lp = 0; //��������±�
	    int rp = 0; //�Ҳ������±�
	    
	    while (lp < l.length && rp < r.length) {
	       result[p++] = (l[lp] < r[rp] ? l[lp++] : r[rp++]);
	    }
	    //������һ����������ʱ,��������
	    //�ֱ�û��Ū���Ԫ��ֱ����ӵ�������
	    while (lp < l.length) {
	       result[p++] = l[lp++];
	    }
	    while (rp < r.length) {
	       result[p++] = r[rp++];
	    }
	    
	    return result;		//����һ�����������
	}

}
