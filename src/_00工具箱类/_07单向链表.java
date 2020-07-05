package _00工具箱类;

import org.junit.Test;

public class _07单向链表 {
	@Test
	public void main() {
		//创建单向链表
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		//打印操作
		printLinkList(head);
	}

	private void printLinkList(ListNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.val+"-");
		printLinkList(head.next);
	}
	
	//定义节点
	class ListNode{
		public int val;	//元素的值
		public ListNode next;	//元素的指针
		public ListNode(int elem){
			this.val = elem;
		}
	}
}
