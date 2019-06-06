package 欢乐颂._04二叉树;

import org.junit.Test;

import 欢乐颂._04二叉树._00直观打印二叉树.Node;



/**
 * morris遍历:原则上是可以实现在O(logN)的时间复杂度下实现读取为O(1)空间复杂度
 * morris遍历的原则:
 * 	1.当前节点记为cur,如果cur无左孩子,cur向右移动(cur=cur.right)
 * 	2.如果cur有左孩子.找到cur左孩子树上最右的节点,记为mostright
 * 		1>如果mostright的right指针指向空,让其指向cur,然后cur向左移动
 * 		2>如果mostright的right指针指向cur,让其指回空
 * 		3>然后cur向右移动
 * 
 */
public class _09二叉树的Morris遍历 {
	@Test
	public void main() {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.right = new Node(5);
		printTree(head);
		morrisIn(head);	//调用morris的中序遍历结果
	}
	
	//中序遍历的结果
	private void morrisIn(Node head) {
		if (head == null) {
			return;
		}
		Node cur = head;
		Node mostRight = null;
		while(cur != null){
			mostRight = cur.left;
			if (mostRight != null) {
				while(mostRight.right != null && mostRight.right != cur){
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) {
					mostRight.right = cur;
					cur = cur.left;
					continue;
				} else{
					mostRight.right = null;
				}
			}
			System.out.print(cur.value + " ");
			cur = cur.right;
		}
		System.out.print(cur.value + " ");
	}


	//-----------工具类-----------工具类-----------工具类-----------工具类-----------工具类-----------
	public class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value = data;
		}
	}
	
	public void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public  String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}
}
