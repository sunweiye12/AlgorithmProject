package _04JianZhiOffer;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * ��Ŀ:��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 
 * 	���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 * 
 * ˼·:����set��������������,���ظ���Ԫ�ش�������ɾ��
 */
public class _57ɾ���������ظ��Ľ�� {

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
		//����һ���������صļ���
		Set<Integer> set = new HashSet<Integer>();
		ListNode tem = head;
		while(tem != null){
			if (set.contains(tem.val)) { //˵�����ظ�Ԫ��
				while(containNode(head,tem.val)){ //�ж��������Ƿ����ֵΪtem.val�Ľڵ�
					head = cremoveNode(head,tem.val);  //����������Ϊtem.val�Ľڵ�ɾ��,�����µ�head
				}
			} else {
				set.add(tem.val);
			}
			tem = tem.next;
		}
		return head;
    }
	
	//��ֵΪval�Ľڵ�ɾ��(������һ��������Ԫ��)
	private ListNode cremoveNode(ListNode head, int val) {
		if (head.next == null) {
			//�����Ԫ�ؾ���ͷ�ڵ�,��ֱ�ӷ��ؿ�
			return null;  
		}
		//-���ͷ�����Ҫɾ���Ľڵ�
		if (head.val == val) {
			head = head.next;
			return head;  
		}
		//-��������ڵ���Ҫɾ���Ľڵ�
		ListNode tem = head;
		while(tem.next != null){
			if(tem.next.val == val){//�������
				tem.next = tem.next.next;
				return head;
			}
			tem = tem.next;
		}
		return head;
	}

	//�ж��������Ƿ����ֵΪval�Ľڵ�
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
