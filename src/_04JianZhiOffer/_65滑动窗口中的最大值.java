package _04JianZhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;


/*
 * ��Ŀ:����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 * 	 ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
 * 		��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ  {4,4,6,6,6,5}�� 
 * 		�������{2,3,4,2,6,2,5,1}�Ļ�������������6���� 
 * 		{[2,3,4],2,6,2,5,1}�� 
 * 		{2,[3,4,2],6,2,5,1}�� 
 * 		{2,3,[4,2,6],2,5,1}�� 
 * 		{2,3,4,[2,6,2],5,1}�� 
 * 		{2,3,4,2,[6,2,5],1}�� 
 * 		{2,3,4,2,6,[2,5,1]}
 */
public class _65���������е����ֵ {
	

	public static void main(String[] args) {
		System.out.println("�ӼӼ�");
	}
	public ArrayList<Integer> maxInWindows(int [] arr, int size){
		//BaseCase
		//�������صĽ������
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (arr==null||size<=0||size>arr.length) {
			return list;
		}
		//����һ����������˫���б�
		LinkedList<Integer> queue = new LinkedList<Integer>();  //�����п���ֻ���±�,����ֵ���Ը���arr[]��ȡ��
		for (int i = 0; i < arr.length; i++) {
			//���������
			while (!queue.isEmpty()&&arr[queue.getFirst()]<=arr[i]) {
				//������в�Ϊ��,�Ҷ���ͷ����Ԫ�رȵ�ǰԪ��С��ɾ������ͷ��Ԫ��
				queue.pollFirst();
			}
			//����ͽ�Ԫ�شӶ��е�ͷ�����(�˴�ָ����Ԫ�ص��±�)
			queue.addFirst(i);
			
			//�˴�i-wΪ���ڵ�β��λ��
			if (i-size == queue.getLast()) {
				queue.pollLast();
			}
			if (i+1-size >= 0) {
				list.add(arr[queue.getLast()]);
			}
		}
		return list;
    }
}
