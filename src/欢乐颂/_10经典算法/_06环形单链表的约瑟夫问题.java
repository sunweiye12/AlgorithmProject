package 欢乐颂._10经典算法;

import org.junit.Test;
/*
【题目】：
　　	据说著名的犹太历史学家Josephus有过以下故事：在罗马人占领桥塔帕特后，39个犹太人与Josephus 及他的朋友躲到一个洞中，
	39个犹太人宁愿死也不要被敌人抓到，于是决定了一个自杀方式，41个人排成一个圆圈，由第一个人开始报数，报数到3的人就自杀，
	然后再有下一个人重新报1，报数到3的人再自杀。这样依次下去，直到剩下最后一个人时，那个人可以自由选择自己的命运。这就是著名的约瑟夫问题。
	现在请用单向环形链表描述该结构并呈现整个自杀过程。
　输入：一个环形单向链表的头节点head和报数的值m。
　返回：最后生存下来的节点，且这个节点自己组成环形单向链表，其他节点都删掉。
【进阶】：
　　如果链表的节点数为N，想在时间复杂度为O(N)时内完成原问题的要求，该怎么实现？
【思路】：
	思路1：遍历链表，不停转圈；
	进阶思路：已知条件为链表长度n、报数值m、最后剩得1个节点。
		那么可以寻找杀死一个节点前这个链表的各个节点的编号与杀死一个节点后整个链表的各个节点的编号之间的关系。
		也就是说可以得到杀死一个节点前后各节点的编号关系
		那么最后剩下的节点即为初始编号为4的节点。
　　有公式如下：old = (new + m - 1) % n + 1
 　　其中：new 为本次中的节点编号；
　　　　　 m 为报数值；
   　　　　  n 为本次中未被删除的节点的数量（初始为5，一次后为4、二次后为3、三次后为2）；
　　　　　 old为上一次本节点的序号。
 */
public class _06环形单链表的约瑟夫问题 {
	
	@Test
	public void main() {
		MyNode head = new MyNode(1);
		head.next = new MyNode(2);
		head.next.next = new MyNode(3);
		head.next.next.next = new MyNode(4);
		head.next.next.next.next = new MyNode(5);
		head.next.next.next.next.next = new MyNode(6);
		head.next.next.next.next.next.next = head;
		
		MyNode head1 = new MyNode(1);
		head1.next = new MyNode(2);
		head1.next.next = new MyNode(3);
		head1.next.next.next = new MyNode(4);
		head1.next.next.next.next = new MyNode(5);
		head1.next.next.next.next.next = new MyNode(6);
		head1.next.next.next.next.next.next = head1;
		int m = 3;
		//通过基础思路解题
		MyNode node = getLastLive(head,m);
		System.out.println(node.value);
		//通过进阶思路结题
		MyNode node1 = getLastLive_jinjie(head1,m);
		System.out.println(node1.value);
		//关键函数,给定一个总数,和数数的m,返回最后存活的人
		//System.out.println(getLive(6, m));
	}
	
	//进阶解法
	private MyNode getLastLive_jinjie(MyNode head, int m) {
		//basecase
		if (head==null || m <= 0) {
			throw new RuntimeException("输入错误");
		}
		//得到链表的长度
		MyNode cur = head.next;
		int size = 1;
		while(cur != head){
			cur = cur.next;
			size++;
		}

		//通过调用函数得到最后存活元素的初始编号
		int target = getLive(size,m);
		//通过他的编号找到该元素并返回
		while(--target != 0){
			head = head.next;
		}
		head.next=head; //将其自己包装成一个环形链表
		return head;
	}
	
	//通过给定初始节点的个数和M返回最后存活的对象为第几个
	private int getLive(int size, int m) {
		if (size == 1) {
			return 1;
		}
		return (getLive(size - 1, m) + m - 1) % size + 1;
	}

	//普通解法--返回最后一个存活的元素
	private MyNode getLastLive(MyNode head, int m) {
		//basecase
		if (head==null || m <= 0) {
			throw new RuntimeException("输入错误");
		}
		if (m == 1) { //如果m=1直接返回最后一个节点
			MyNode cur = head;
			while(cur.next != head){
				cur = cur.next;
			}
			return cur;
		}
		while(true){
			for (int i = 1; i < m-1; i++) { //每次将要找到要删除的前一个位置
				head = head.next;
			}
			MyNode cur = head;//他的下一个元素就是要删除的元素
			if (cur == cur.next) {
				break;
			}
			head.next = head.next.next;	//直接将他的下一个元素删除
			head = head.next;
		}
		return head;
	}

	//-----------------------------------------------------------------------------------
	class MyNode{
		public int value;	//元素的值
		public MyNode next;	//元素的指针
		public MyNode(int elem){
			this.value = elem;
		}
	}
}


