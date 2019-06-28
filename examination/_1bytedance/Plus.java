package _1bytedance;
import org.junit.Test;
/*
 * 题目:两个链表表示整数,每个节点表示一位数,冲头结点开始表示个位,编写一个函数,对着两个数求和,用链表的形式返回
 */
public class Plus {

	@Test
	public void mian() {
		
		ListNode node1 = new ListNode(9);
		node1.next = new ListNode(2);
		node1.next.next = new ListNode(3);

		ListNode node2 = new ListNode(4);
		node2.next = new ListNode(1);
		node2.next.next = new ListNode(3);
		node2.next.next.next = new ListNode(2);
		node2.next.next.next.next = new ListNode(2);
		ListNode plusAB = plusAB(node1, node2);
		jianshi(plusAB);
		printNode(plusAB);

	}

	// 给定链表的头部返回一个新的链表
	public ListNode plusAB(ListNode a, ListNode b) {
		// basecase
		if (a == null && b == null) {
			return null;
		}
		int anum = a == null ? 0 : a.val;
		int bnum = b == null ? 0 : b.val;
		ListNode head = new ListNode(anum + bnum);
		if (a == null) {
			head.next = plusAB(null, b.next);
		} else if (b == null) {
			head.next = plusAB(a.next, null);
		} else {
			head.next = plusAB(a.next, b.next);
		}
		return head;
	}

	// 如果大于10的话,会向前进一位
	private void jianshi(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode cur = head;
		while (cur != null) {
			if (cur.val >= 10) {
				cur.val -= 10;
				cur = cur.next;
				cur.val += 1;
			} else {
				cur = cur.next;
			}
		}
	}

	// ------------工具-----------------
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	private void printNode(ListNode plusAB) {
		// TODO Auto-generated method stub
		if (plusAB != null) {
			System.out.print(plusAB.val + " ");
			printNode(plusAB.next);
		}
	}
}
