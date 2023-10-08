package _04JianZhiOffer;

import java.util.Stack;

import org.junit.Test;

/*
 * 题目:输入一个链表，反转链表后，输出新链表的表头。
 * 
 * 思路:将节点顺序放到栈中,然后在出栈顺序给人家穿起来
 */
public class _15反转链表 {

	@Test
	public void main() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ListNode reverseList = ReverseList(head);
		printLinkList(reverseList);
	}
	
	public ListNode ReverseList(ListNode head) {
		if (head == null || head.next == null) { //当只有一个节点或者没有节点的情况
			return head;
		}
		Stack<ListNode> stack = new Stack<ListNode>();
		//从头到尾将元素压栈
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		head = stack.pop();  //拿出新的头节点
		ListNode tem = head;
		while(stack.size() != 0){		
			tem.next = stack.pop();
			tem = tem.next;
		}
		tem.next = null;//记得将最前面节点的next职位空
		
		return head;
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
