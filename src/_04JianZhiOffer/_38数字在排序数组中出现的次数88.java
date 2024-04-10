package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:ͳ��һ�����������������г��ֵĴ�����
 * 
 * ˼·:��Ϊ�����ж������������Կ�����΢��һ�£���������k������λ�ã���������k-0.5��k+0.5
		��������Ӧ�ò����λ�ã�Ȼ��������ɡ�(���Ǹ���������Ч�ʵ�)
      ˼·:(�ص��Ƕ��ֲ�������Ҫ)
 */
public class _38���������������г��ֵĴ���88 {
	
	@Test
	public void main() {
		int[] arr = {0,1,1,2,3,5,5,5,6};
		int k = GetNumberOfK(arr, 1);
		System.out.println(k);
	}
	
	public int GetNumberOfK(int [] arr , int k) {
        if(arr.length == 0 || arr == null){
            return 0;
        }
        int firstK = getFirstK(arr, k, 0, arr.length-1); //��ȡ��ͷ���±�(���Ҳ��������±�Ϊ-1)
        int lastK = getLastK(arr, k, 0, arr.length-1);	 //��ȡ��β���±�
        if(firstK == -1 || lastK == -1){
             return 0;
        }
        return lastK - firstK + 1; //���ظ���
    }
	
	//�ݹ�д��
    private int getFirstK(int [] arr , int k, int start, int end){
    	if (end < start) {
			return -1; //ÿ�в��ҵ�����-1
		}
    	int mid = (end + start) >> 1;
    	if (arr[mid] > k) {
    		return getFirstK(arr, k, start, mid-1);
		} else if(arr[mid] < k){
			return getFirstK(arr, k, mid+1, end);
		} else if (mid-1>=0 && arr[mid-1] == k) {
			return getFirstK(arr, k, start, mid-1);
		} else {
			return mid;
		}
    }
    //ѭ��д��
    private int getLastK(int [] arr , int k, int start, int end){
    	if (end < start) {
			return -1;
		}
    	int mid = (start + end) >> 1;
    	if (arr[mid] > k) {
    		return getLastK(arr, k, start, mid-1);
		} else if(arr[mid] < k){
			return getLastK(arr, k, mid+1, end);
		} else if( mid+1 <= end && arr[mid+1] == k){
			return getLastK(arr, k, mid+1, end);
		} else {
			return mid;
		}
    }
}
