package 欢乐颂._03链表;

/**
 * 【题目】 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个
	整 数pivot。
	实现一个调整链表的函数，将链表调整为左部分都是值小于 pivot
	的节点，中间部分都是值等于pivot的节点，右部分都是值大于 pivot的节点。
	除这个要求外，对调整后的节点顺序没有更多的要求。
	 例如：链表9->0->4->5->1，pivot=3。 
	 调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。
	 总之，满 足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部分为空），右部分都是大于3的节点即可。
	 对某部分内部的节点顺序不做要求。(不要求稳定性)
	
	【进阶题目】： 在原问题的要求之上再增加如下两个要求。
	在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左到右的顺序与原链表中节点的先后次序一致。 
	例如：链表9->0->4->5->1，pivot=3。
	调整后的链表是0->1->9->4->5。 
	在满足原问题要求的同时，左部分节点从左到右为0、1。在原链表中也 是先出现0，后出现1；中间部分在本例中为空，不再
	讨论；右部分节点 从左到右为9、4、5。在原链表中也是先出现9，然后出现4，最后出现5。
	如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)。
	
	题目一思路:得到链表的长短,并创建一个链表长度,节点类型的数组,将每一个链表元素放入数组中
			按照荷兰国旗问题对数组处理,阱吃力好的数组元素,串联起来
	
	进阶问题思路:设置三个指针分别为less mid 和 high 三个指针分别遍历列表使
			less指向第一个值小于pivot的节点
			mid指向第一个值等于pivot的节点
			high指向第一个值大于pivot的节点
			然后依次从自己指向的链表向下遍历,如果less指向的节点的下一个节点值小于等于less.则将next指针指向它.否则跳过
			如果mid指向的节点的下一个节点值等于mid.则将next指针指向它.否则跳过
			如果high指向的节点的下一个节点值大于等于high.则将next指针指向它.否则跳过
			然后将三个连表串联起来(注意其中的链表可能会为空,空链表不能直接用next指针)
 * @author Administrator
 *
 */
public class _03单向链表的荷兰国旗问题 {
	
	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		//打印链表元素
		printLinkedList(head1);
//		head1 = listPartition1(head1, 5);
		head1 = listPartition2(head1, 5);
		printLinkedList(head1);
	}
	
	//方法一:将列表调整为数组,排序后再拼接为链表--------------------------------------------
	public static Node listPartition1(Node head, int pivot) {
		//没有节点或者只有一个节点
		if (head == null || head.next==null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		while (cur != null) {
			i++;
			cur = cur.next;
		}
		Node[] arr = new Node[i];
		i = 0;
		cur = head;
		for (i = 0; i < arr.length; i++) {
			arr[i] = cur;
			cur = cur.next;
		}
		//调用partition来对数组排序
		arrPartition(arr, pivot);
		//将排序好的数组用链表串起来
		for (i = 1; i < arr.length; i++) {
			arr[i - 1].next = arr[i];
		}
		arr[i - 1].next = null;
		return arr[0];
	}
	//荷兰国旗问题(快排)
	public static void arrPartition(Node[] arr, int pivot) {
		int index = 0;
		int left = -1;
		int right = arr.length;
		while (index != right) {
			if (arr[index].value < pivot) {
				swap(arr, ++left, index++);
			} else if (arr[index].value > pivot) {
				swap(arr, --right, index);
			} else {
				index++;
			}
		}
	}
	
	
	//方法二:划分为三条链表来实现--------------------------------------------
	public static Node listPartition2(Node head, int pivot) {
		//分别定义三个链表的头指针和尾指针
		Node sH = null; // small head
		Node sT = null; // small tail
		Node eH = null; // equal head
		Node eT = null; // equal tail
		Node bH = null; // big head
		Node bT = null; // big tail
		//为了保存next指针而存在
		Node next = null; 
		//将每一个节点都分配给这三个链表
		while (head != null) {
			//这两部是为了只将head值一个节点添加到三指针上,因此令head.next = null;
			//去掉head后面对链表.next = head.next;是为了寻找到下一个
			next = head.next;
			head.next = null;
			if (head.value < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value == pivot) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		//将所有节点都分配完毕后进行三个链表的拼接
		// small and equal reconnect
		if (sT != null) {	//说明小于队列有元素
			sT.next = eH;	//将小于队列的尾部连接等于队列的头部
			eT = eT == null ? sT : eT;	//如果等于队列没有元素就将等于队列的尾部置为小于队列的尾部
		}
		// all reconnect
		if (eT != null) {	//如果等于队列的尾部有元素,则将等于队列的尾部与大于队列的头部向连接
			eT.next = bH;
		}
		//如果小于队列中有元素则将小于队列的头部返回,否则判断等于队列如果有元素的话返回等于对列的头部,否则返回大于队列的头部
		return sH != null ? sH : eH != null ? eH : bH;
	}
	
	
	//工具类------工具类------工具类------工具类------工具类------工具类------工具类------工具类------工具类------工具类------
	//列表交换元素
	public static void swap(Node[] arr, int a, int b) {
		Node tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	//工具方法
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
}
