package _04JianZhiOffer;

import org.junit.Test;

/*
 * 题目:输入一个链表，输出该链表中倒数第k个结点。(因为如果有环的话,不会有倒数的概念,所以一定不会有环)
 * 
 * 思路:先求出链表一共有多少个节点,然后根据k来确定返回的是正数第多少个节点,
 * 		然后再将其返回(倒数第一个节点为最后一个节点)
 */
public class _14链表中倒数第K个节点 {

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
		int count = 0; //用于统计一共有多少各节点
		ListNode tem = head; //为了保持head的索引不变,以后还要用
		while (tem != null) {
			count++;
			tem = tem.next;
		}
		
		int res = count - k + 1; //正数第几个节点
		if (res <= 0 || res > count) {		//保障查询不越界
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
