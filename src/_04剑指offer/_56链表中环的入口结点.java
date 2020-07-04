package _04剑指offer;

/*
 * 题目:给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class _56链表中环的入口结点 {

	
	public ListNode EntryNodeOfLoop(ListNode head){
		//basecase
		if(head == null || head.next == null || head.next.next == null || head.next.next.next == null){
			return null;
		}

		ListNode slow = head.next;
		ListNode fast = head.next.next;
		
		while(slow != fast){
			if(fast.next == null || fast.next.next == null){
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		//说明碰到了
		fast = head;
		while(slow != fast){
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
    }
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
}
