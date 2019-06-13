package _0工具箱类;

import org.junit.Test;

public class _07单向链表的直观打印 {
	@Test
	public void main() {
		//创建单向链表
		MyNode head = new MyNode(1);
		head.next = new MyNode(2);
		head.next.next = new MyNode(3);
		head.next.next.next = new MyNode(4);
		head.next.next.next.next = new MyNode(5);
		head.next.next.next.next.next = new MyNode(6);
		//打印操作
		printLinkList(head);
	}

	//打印单向链表的一个方法
	private void printLinkList(MyNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value+"-");
		printLinkList(head.next);
	}
	
	//定义节点
	class MyNode{
		public int value;	//元素的值
		public MyNode next;	//元素的指针
		public MyNode(int elem){
			this.value = elem;
		}
	}
	
}
