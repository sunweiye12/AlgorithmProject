package _04JianZhiOffer;

/*
 * ��Ŀ:��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
 */
public class _56�����л�����ڽ�� {

	
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
		//˵��������
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
