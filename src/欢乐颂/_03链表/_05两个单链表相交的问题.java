package 欢乐颂._03链表;

/**
 * 【题目】 在本题中，单链表可能有环，也可能无环。
 * 给定两个单链表的头节点 head1和head2，这两个链表可能相交，也可能不相交。
 * 请实现一个函数， 如果两个链表相交，请返回相交的第一个节点；如果不相交，返回null 即可。
 *  要求：如果链表1的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，
 *  额外空间复杂度请达到O(1)。
 *  
 *  思路:1.首先判断一个链表有没有环,如果有环的话返回第一个入环的节点
 *  	两种方式来完成:第一种是将其依次放入HashSet集合中,每次放入前查看是否包含如果有包含的则说明有环,第一个节点就为此节点(此方法需要额外辅助空间)
 *  		第二种方法:是快慢指针法,设置一个快指针(依次走两步)和一个慢指针(一次走一步),如果快指针走到头说明无环,在这之前若快慢指针相遇说明存在环,
 *  		在相遇的时候,快指针指向head位置转变为慢指针,慢指针不变,他俩在此相遇的点就是入环点
 *  	2.判断两个链表是否能相交,首先要知道他们各自是否有环
 *  		情况1:链表A有环,链表B无环-----则必然不相交
 *  		情况2:链表A无环,链表B无环-----可能会相交
 *  		情况3:链表A有环,链表B有环-----可能会相交(相交且交点在环上)
 *  		情况3:链表A有环,链表B有环-----可能会相交(相交且交点在环外)
 * @author Administrator
 */
public class _05两个单链表相交的问题 {
	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->7->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		
		System.out.println(getIntersectNode(head1, head2).value);

	}
	
	//获取两个链表的相交结点,如果不相交则返回null
	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		//分别判断两个链表是否有环,并返回入环节点
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if (loop1 == null && loop2 == null) {
			//两个无环链表的相交情况
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			//两个有环链表的相交情况
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}
	
	//分别判断两个链表是否有环,并返回入环节点,如果无环则返回null
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		//必须如此设置才能找到入环点
		Node n1 = head.next; 		// n1 -> 慢指针和其初始节点
		Node n2 = head.next.next; 	// n2 -> 快指针和其初始节点
		while (n1 != n2) { 			//两个指针相遇时跳出循环
			if (n2.next == null || n2.next.next == null) {
				return null;		//快指针走到头,返回null
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}
		//相遇后快指针指向head
		n2 = head; 	// n2 -> walk again from head
		while (n1 != n2) { //再次相遇则为入环点
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}
	
	//判断两个没有换的链表是否相交
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		//统计两个链表长度之差
		int n = 0;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		//如果两个链表相交的话肯定是从后面相交,因此尾节点一定相同,如果不同说明不相交直接返回null
		if (cur1 != cur2) {
			return null;
		}
		//若尾节点相同则说明一定在尾节点或之前相交
		//找出较长的那个链表为cur1
		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		//取绝对值
		n = Math.abs(n);
		//从头部开始消去长链表多出的部分
		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}
		//然后同时一步步向下走,第一个相遇的节点就是相交点
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	
	//判断两个有环的链表是否相交
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		if (loop1 == loop2) {	//交点为一处,说明在环外相交,或相交于环上一点
			//与判断无环两个列表的情况相同(只不过结束点为loop而不是null)
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {		//说明相交于环上两点
			cur1 = loop1.next;
			while (cur1 != loop1) {	//当cur1 == loop1时跳出循环,说明遍历完环一遍
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			//如果整个换上都没有发现loop2说明两个链表没有相交
			return null;
		}
	}
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
}
