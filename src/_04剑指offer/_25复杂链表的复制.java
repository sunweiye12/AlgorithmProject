package _04剑指offer;

import java.util.HashMap;
import java.util.Map;

/*
 * 题目:输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 		返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * 思路:开辟一个HashMap的结构,key为原节点,value为key对应复制节点
 * 		然后等HashMap建立好了以后,
 * 		将value的next指针指向,key的next指针指向的value
 * 		将value的random指针指向,key的random指针指向的value
 */
public class _25复杂链表的复制 {
	
	public void main() {
		// TODO Auto-generated method stub

	}
	
	 public RandomListNode Clone(RandomListNode pHead){
		//basecase 
		if (pHead == null) { return null; }
		//创建容器
		Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
		
		RandomListNode cur = pHead;
		while(cur != null){
			map.put(cur, new RandomListNode(cur.label));
			cur = cur.next;
		}
		cur = pHead;
		while(cur != null){
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		RandomListNode node = map.get(pHead);
		return node;
	 }

//------------------------------------------------------------------------------
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
}
