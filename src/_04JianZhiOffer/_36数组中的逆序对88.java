package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:�������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * 		����һ������,�����������е�����Ե�����P��
 * 		����P��1000000007ȡģ�Ľ�������
 * 		 �����P%1000000007   (ע:��Ŀ��֤�����������û�е���ͬ������)
 * ˼·(�����㷨):����ɨ��ÿһ�����ֿ�ͷ�������   O(n2)   �ռ�O(1)
 * ˼·(����MegerSortԭ��):���Խ��������������,ֱ����С��ԪΪһ���ַ�Ԫ��ʱ,Ȼ��������úϲ�
 * 		�ںϲ��Ĺ�����,��������Զ���ͳ��   ʱ��O(nlogn)  �ռ�O(n)
 */
public class _36�����е������88 {

	@Test
	public void main() {
		int[] arr = {1,2,3,4,5,6,7,0};
		int num = InversePairs_baoli(arr);
		int num1 = InversePairs(arr);
		System.out.println(num1);
	}
	
	//����MegerSort������
	public int InversePairs(int[] arr) {
		if (arr==null || arr.length <= 1) {
			return 0;
		}
		int num = merge(arr,0,arr.length-1);
		return num;
	}
	
	//���ù鲢����˼·�ڽ������
    public  int merge(int[] arr,int left,int right) {
    	//�ݹ�Ľ�ֹ����
        if(left == right) 
            return 0;
      	//��ȡ�м��
        int mid = left + ((right - left) >> 1);
        return  merge(arr,left,mid)+ merge(arr,mid+1,right)+mergerSort(arr ,left,mid,right);
    }
    
    public  int mergerSort(int[] arr,int left,int mid,int right){
    	//������������
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid+1;
        int result = 0;
        //������������ֺϲ�Ϊ�����һ���ִ洢��help��
        while (p1 <= mid && p2 <= right){
        	//***�ص�***�����ַֿ�����.���������ֶ����ɴ�С�����,
        	//�������һ����AС�������һ����Bʱ.��ʱA����,��ΪA������B���ڵ�����,���Բ����γ������
            //�������һ����A���������һ����Bʱ.��ʱ�γ������,����һ������B�����������,Ҳ����˵B���������B������A��������
        	result += (arr[p1] > arr[p2] ? right-p2+1 : 0); //ֻ�е���������������������ʱ��Ż�ͳ�������
            help[i++] = (arr[p1] > arr[p2] ? arr[p1++] : arr[p2++]);
        }
        //��������һ����ͷʱ����һ��ֱ�Ӹ��Ƶ�result��
        while (p1 <= mid){
             help[i++] = arr[p1++];
        }
        while (p2 <= right){
             help[i++] = arr[p2++];
        }
      //���ⲿ���������洢��arr������λ��
        for (int j = 0; j < help.length; j++) {
			arr[j+left] = help[j];
		}
        return result;
    }

	//������
	public int InversePairs_baoli(int [] arr) {
		if (arr==null || arr.length <= 1) {
			return 0;
		}
		int retCount = 0;//���ڷ��صļ�����
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i]>arr[j]) {
					retCount++;
				}
			}
		}
        return retCount;
    }
}
