package _04剑指offer;

import org.junit.Test;

/*
 * 题目:输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * 思路1:可以利用,mergeSort的merge原理来实现,创建一个新的链表返回,时间O(n) 空间O(n)----
 */
public class _16合并两个排序的链表 {
	
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
		ListNode head =  new ListNode(1);  //索引不能丢
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
	//打印单向链表的一个方法
	private void printLinkList(ListNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.val+"-");
		printLinkList(head.next);
	}
}
