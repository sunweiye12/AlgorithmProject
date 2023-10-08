package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:����һ����������������е�����k����㡣(��Ϊ����л��Ļ�,�����е����ĸ���,����һ�������л�)
 * 
 * ˼·:���������һ���ж��ٸ��ڵ�,Ȼ�����k��ȷ�����ص��������ڶ��ٸ��ڵ�,
 * 		Ȼ���ٽ��䷵��(������һ���ڵ�Ϊ���һ���ڵ�)
 */
public class _14�����е�����K���ڵ� {

	@Test
	public void main() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		System.out.println(FindKthToTail(head, 1).val);
	}
	
	
	public ListNode FindKthToTail(ListNode head,int k) {
		if (head == null || k <= 0) {
			return null;
		}
		int count = 0; //����ͳ��һ���ж��ٸ��ڵ�
		ListNode tem = head; //Ϊ�˱���head����������,�Ժ�Ҫ��
		while (tem != null) {
			count++;
			tem = tem.next;
		}
		
		int res = count - k + 1; //�����ڼ����ڵ�
		if (res <= 0 || res > count) {		//���ϲ�ѯ��Խ��
			return null;
		}
		while(res > 1) {
			head = head.next;
			res--;
		}
		return head;
    }
	
	private class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
}
