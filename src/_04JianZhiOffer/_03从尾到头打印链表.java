package _04JianZhiOffer;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

/*
 * ��Ŀ:����һ������������ֵ*��β��ͷ*��˳�򷵻�һ��ArrayList��
 * ˼·��Ҫ��β����ͷ����˳�����,�����д��ʱ���ͷ����β����ӵ�ջ��.Ȼ���ջ�ڷŵ��������������������
 * ʱ�临�Ӷ�O(n) �ռ�O(n)
 * 
 */
public class _03��β��ͷ��ӡ���� {

	@Test
	public void main() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ArrayList<Integer> list = printListFromTailToHead(head); //���÷�����������
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
	}
	public ArrayList<Integer> printListFromTailToHead(ListNode head) {
		if (head == null) {
			return new ArrayList<Integer>(); //���ؿ�����
		}
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>(); //����һ�����صļ���
		while (head != null) {
			stack.add(head.val);
			head = head.next;
		}
		while(!stack.isEmpty()){
			result.add(stack.pop());
		}
        return result;
    }
	
	//-----------����-----------����-----------����-----------����--------
	public class ListNode {
		int val;
       	ListNode next = null;

       	ListNode(int val) {
           this.val = val;
       	}
	}
}
