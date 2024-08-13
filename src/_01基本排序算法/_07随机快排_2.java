package _01���������㷨;
import org.junit.Test;


public class _07�������_2 {
	/**
	 * ʱ�临�Ӷ�: O(nlogn) --���������Ĺ���-->O(nlogn)
	 * �ռ�ռ��: 	O(logn)  --���������Ĺ���-->O(logn)
	 * �ȶ���: ���ȶ�
	 * @param args
	 */
	
	@Test
	public void main() {
		int[] arr = {5,3,2,8,5,9,21,6};
		fastSort(arr,0,arr.length-1);		//��������Ҫ��������,�Լ����鿪ͷ�ͽ�β���±�
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	
	//��������
	public void fastSort (int[] arr,int first,int last){
		
		if (first >= last) { //�ݹ��ֹ������(������ֻ��һ��Ԫ��)
			return;
		}
		
		//�������(***�ص�***)
		swap(arr,first,first+(int)(Math.random()*(last-first+1)));
		
		int mid_value = arr[first];	//��ȡ������±�
		
		int[] p = fast(arr, first, last, mid_value);
		
		//ͨ���ݹ齫����������п���
		fastSort(arr,first,p[0]-1);
		fastSort(arr,p[1]+1,last);
	}
	
	//������Ȳ��ֵ��±�ֵ   ---> ����Ϊ ����,��߽�,�ұ߽�,Ҫ�Ƚϵ���
	public int[] fast(int[] arr, int L ,int R ,int num){

		int less =L - 1;	//С��num��ָ�� (��ǰ�Լ����涼��С��num����)
		int more =R + 1;	//����num��	 (��ǰ�����涼�Ǵ���num����)
		int cur = L;		//����num��ָ��
		
		while (cur < more) { 		//ֻҪcur��moreû��������һֱѭ��
			if (arr[cur] < num) {
				swap(arr, ++less, cur++);
			} else if (arr[cur] > num) {
				swap(arr, --more, cur);		//�˴�cur���ܼ�һ,��Ϊ�ƹ�����more--��û�о����ж�,����Ҫ�ж�
			} else {		//������
				cur++;
			}
		}
		
		//�������д���num�򷵻ش���num���±귶Χ
		return new int[] {less+1,more-1};
	}
		
	//��������a�±��b�±��Ԫ��
	public void swap(int[] arr , int a ,int b){
		int tem = arr[a];
		arr[a] = arr[b];
		arr[b] = tem;
	}
	
}
