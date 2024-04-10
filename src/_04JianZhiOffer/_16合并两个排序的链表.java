package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * 
 * ˼·1:��������,mergeSort��mergeԭ����ʵ��,����һ���µ�������,ʱ��O(n) �ռ�O(n)----
 */
public class _16�ϲ�������������� {
	
	@Test
	public void main() {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(4);
		list1.next.next = new ListNode(5);
		list1.next.next.next = new ListNode(9);
		
		ListNode list2 = new ListNode(2);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(6);
		list2.next.next.next = new ListNode(7);
		
		ListNode merge = Merge(list1, list2);
		printLinkList(merge);
	}
	
	public ListNode Merge(ListNode list1,ListNode list2) {
		ListNode head =  new ListNode(1);  //�������ܶ�
		ListNode tem = head;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val ) {
				tem.next = list1;
				tem = tem.next;
				list1 = list1.next;
			} else {
				tem.next = list2;
				tem = tem.next;
				list2 = list2.next;
			}
		} 
		
		while(list1 != null){
			tem.next = list1;
			tem = tem.next;
			list1 = list1.next;
		}
		
		while(list2 != null){
			tem.next = list2;
			tem = tem.next;
			list2 = list2.next;
		}
        return head.next;
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
