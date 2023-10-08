package _04JianZhiOffer;

import java.util.Stack;

import org.junit.Test;

/*
 * ��Ŀ:����һ��������ת��������������ı�ͷ��
 * 
 * ˼·:���ڵ�˳��ŵ�ջ��,Ȼ���ڳ�ջ˳����˼Ҵ�����
 */
public class _15��ת���� {

	@Test
	public void main() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ListNode reverseList = ReverseList(head);
		printLinkList(reverseList);
	}
	
	public ListNode ReverseList(ListNode head) {
		if (head == null || head.next == null) { //��ֻ��һ���ڵ����û�нڵ�����
			return head;
		}
		Stack<ListNode> stack = new Stack<ListNode>();
		//��ͷ��β��Ԫ��ѹջ
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		head = stack.pop();  //�ó��µ�ͷ�ڵ�
		ListNode tem = head;
		while(stack.size() != 0){		
			tem.next = stack.pop();
			tem = tem.next;
		}
		tem.next = null;//�ǵý���ǰ��ڵ��nextְλ��
		
		return head;
    }
	
	private class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	//��ӡ���������һ������
	private void printLinkList(ListNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.val+"-");
		printLinkList(head.next);
	}
}
