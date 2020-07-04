package _02分类算法._03链表;

import java.util.HashMap;

/**
 * 【题目】 一种特殊的链表节点类描述如下：
	public class Node { 
		public int value; 
		public Node next;
		public	Node rand;
		public Node(int data) { 
			this.value = data; 
		}
	}
	
	Node类中的value是节点值，next指针和正常单链表中next指针的意义一 样，都指向下一个节点，
	rand指针是Node类中新增的指针，这个指针可能指向链表中的任意一个节点，也可能指向null。 
	给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个 函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。 
	【进阶题目】：
	不使用额外的数据结构，只用有限几个变量，且在时间复杂度为 O(N)内完成原问题要实现的函数
	
	思路1:将链表依次存放到一个HashMap中,Key为节点本身,Value为复制产生的新节点,
		也就是每一个原节点都对应着一个新节点,然后将新节点的下一个next指针指向其原节点next指针所对应的value值
		即:map.get(cur).next = map.get(cur.next);
		然后令rand指针同样执行  map.get(cur).rand = map.get(cur.rand); 
		最后返回头结点所对应的value值
	
	进阶思路2:链表中将每个元素复制一份放到自己的next指针下,然后在通过next指针连接下一个元素,
			这样相当于每一个指针的下一个元素就是自己的复制元素
			第一个节点是源节点,第二个节点是其复制节点,源节点的rand指向节点的下一个节点,就是其复制节点rand所指向的节点
			通过这种方式找到所有复制节点的rand指向的节点,然后在以两步为单位将复制节点用next指针串联起来
 * @author Administrator
 */
public class _04复制随机指针节点的链表 {
	public static void main(String[] args) {
		Node head = null;
		Node res1 = null;
		Node res2 = null;

		//设置链表
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		//设置rand指针
		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

//		printRandLinkedList(head);
//		res1 = copyListWithRand1(head);
//		printRandLinkedList(res1);
		
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

	}
	public static class Node {
		public int value;
		public Node next;
		public Node rand;

		public Node(int data) {
			this.value = data;
		}
	}
	
	//方法一
	public static Node copyListWithRand1(Node head) {
		//创建一个HashMap的辅助结构
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		//head节点所指向的节点不能变因为后面还要用到,所以不能直接head = head.next;
		//利用一个cur的临时指针
		Node cur = head;
		while (cur != null) {
			//将每一个节点和其对应的复制节点放到map中
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			//分别给每个复制节点分配next指针和rand指针
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		//返回复制列表的头结点
		return map.get(head);
	}

	//方法二
	public static Node copyListWithRand2(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		Node next = null;
		// 将每一个元素的复制元素链到自己后面
		while (cur != null) {
			next = cur.next;
			cur.next = new Node(cur.value);
			cur.next.next = next;
			cur = next;
		}
		
		cur = head;
		Node curCopy = null;
		// 为每一个复制节点寻找自己rand指向的节点
		while (cur != null) {
			next = cur.next.next; //每次跳两部
			curCopy = cur.next;
			curCopy.rand = cur.rand != null ? cur.rand.next : null;
			cur = next;
		}
		
		cur = head;
		Node res = head.next;//复制节点的头结点
		// 将所有的复制节点用next连接起来
		while (cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			cur.next = next;
			curCopy.next = next != null ? next.next : null;
			cur = next;
		}
		return res;
	}

	//工具类------工具类------工具类------工具类------工具类------工具类------工具类------工具类------工具类------
	public static void printRandLinkedList(Node head) {
		Node cur = head;
		System.out.print("order: ");
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:  ");
		while (cur != null) {
			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}
}
