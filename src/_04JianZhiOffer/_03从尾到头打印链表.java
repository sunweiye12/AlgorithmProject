package _04JianZhiOffer;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

/*
 * 题目:输入一个链表，按链表值*从尾到头*的顺序返回一个ArrayList。
 * 思路：要从尾部到头部的顺序放入,因此在写的时候从头部往尾部添加倒栈中.然后出栈在放到按照逆序放入链表里面
 * 时间复杂度O(n) 空间O(n)
 * 
 */
public class _03从尾到头打印链表 {

	@Test
	public void main() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ArrayList<Integer> list = printListFromTailToHead(head); //调用方法返回链表
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
	}
	public ArrayList<Integer> printListFromTailToHead(ListNode head) {
		if (head == null) {
			return new ArrayList<Integer>(); //返回空链表
		}
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>(); //创建一个返回的集合
		while (head != null) {
			stack.add(head.val);
			head = head.next;
		}
		while(!stack.isEmpty()){
			result.add(stack.pop());
		}
        return result;
    }
	
	//-----------工具-----------工具-----------工具-----------工具--------
	public class ListNode {
		int val;
       	ListNode next = null;

       	ListNode(int val) {
           this.val = val;
       	}
	}
}
