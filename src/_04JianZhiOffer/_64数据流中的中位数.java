package _04JianZhiOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/*
 * ��Ŀ:��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 * 	������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * 	����ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
 * 
 * ˼·:
 */
public class _64�������е���λ�� {
	
	@Test
	public static void main(String[] args) {
		
	}
	 
	PriorityQueue<Integer> minHeap = new  PriorityQueue<Integer>(20); //�����λ�����Ԫ��
	PriorityQueue<Integer> maxHeap = new  PriorityQueue<Integer>(20,new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	});
	
	//����һ��Ԫ��
	public void Insert(Integer num){
		//ά�������ѵĴ�С��������1(һֱʹmaxHeap��size����minHeap)
		//��������Ԫ�����ʱ,�²����value,���������minHeap�����ֵ���������뵽minHeap��
		//���Ұ�minHeap����Сֵ�ƶ���maxHeap��������뵽maxHeap
		if (maxHeap.size() == minHeap.size()) {
             if (minHeap.peek() != null && num > minHeap.peek()) {
            	 minHeap.offer(num);
                 maxHeap.offer(minHeap.poll());
             } else {
                 maxHeap.offer(num);
             }
         } else {
             if (num < maxHeap.peek()) {
            	 maxHeap.offer(num);
                 minHeap.offer(maxHeap.poll());
             } else {
                 minHeap.offer(num);
             }
         }
	}
	
	//��ȡ��λ��
	public Double GetMedian(){
		if (maxHeap.isEmpty()) {
		     return (double)-1; 
		}
		if (maxHeap.size() == minHeap.size()) {
			int num1 = minHeap.peek();
			int num2 = maxHeap.peek();
		     return (double)(num1 + num2)/2;
		} else {
		     return (double)maxHeap.peek();
		}
	}
}
