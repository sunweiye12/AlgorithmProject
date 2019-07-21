package 剑指offer;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * 题目:在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
 * 	例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * 思路:利用set集合来进行判重,将重复的元素从链表中删除
 */
public class _57删除链表中重复的结点 {

	@Test
	public void main() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next.next = new ListNode(1);
		 head = deleteDuplication(head);
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
	public ListNode deleteDuplication(ListNode head){
		//basecase
		if (head==null || head.next == null) {
			return head;
		}
		//创建一个用于排重的集合
		Set<Integer> set = new HashSet<Integer>();
		ListNode tem = head;
		while(tem != null){
			if (set.contains(tem.val)) { //说明有重复元素
				while(containNode(head,tem.val)){ //判断链表中是否包含值为tem.val的节点
					head = cremoveNode(head,tem.val);  //将链表中置为tem.val的节点删除,返回新的head
				}
			} else {
				set.add(tem.val);
			}
			tem = tem.next;
		}
		return head;
    }
	
	//将值为val的节点删除(链表中一定包含此元素)
	private ListNode cremoveNode(ListNode head, int val) {
		if (head.next == null) {
			//如果此元素就是头节点,则直接返回空
			return null;  
		}
		//-如果头结点是要删除的节点
		if (head.val == val) {
			head = head.next;
			return head;  
		}
		//-如果其他节点是要删除的节点
		ListNode tem = head;
		while(tem.next != null){
			if(tem.next.val == val){//如果碰到
				tem.next = tem.next.next;
				return head;
			}
			tem = tem.next;
		}
		return head;
	}

	//判断链表中是否存在值为val的节点
	private boolean containNode(ListNode head, int val) {
		ListNode tem = head;
		if (tem == null) {
			return false;
		}
		while(tem != null){
			if (tem.val == val) {
				return true;
			}
			tem = tem.next;
		}
		return false;
	}
//-----------------------------------------------------------------------------------------------
	public class ListNode {
	    int val;
	    ListNode next = null;
	
	    ListNode(int val) {
	        this.val = val;
	    }
	}
}
