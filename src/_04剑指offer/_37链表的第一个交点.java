package _04剑指offer;
/*
 * 题目:输入两个链表，找出它们的第一个公共结点。
 */
public class _37链表的第一个交点 {

	public ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		int size1 = 1;//用于统计list1的节点数
		int size2 = 1;//用于统计list2的节点数
		ListNode cur1 = head1;
		ListNode cur2 = head2;
		while(cur1.next != null) {
			size1++;
			cur1 = cur1.next;
		}
		while(cur2.next != null) {
			size2++;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) { //如果最后一个节点都不同说明不相交
			return null;
		}
		if (size1>size2) {
			for (int i = 0; i < size1-size2; i++) {
				head1 = head1.next;
			}
		} else {
			for (int i = 0; i < size2-size1; i++) {
				head2 = head2.next;
			}
		}
		while(head1 != head2){
			head1 = head1.next;
			head2 = head2.next;
		}
		return head1;
    }
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
}
