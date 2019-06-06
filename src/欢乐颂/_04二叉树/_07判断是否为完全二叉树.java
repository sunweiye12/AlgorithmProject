package 欢乐颂._04二叉树;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 完全二叉树:如果二叉树的深度为h，除第 h 层外，其它各层 (1～h-1)的结点数都达到最大个数，第 h层所有的结点都连续集中在最左边
 * 		1.二叉树按照层次遍历,遍历每个节点的情况如下(共有四种)
 * 		-->1.此节点左右节点都有-->继续遍历
 * 		-->2.此节点有右节点没有左节点-->返回false
 * 		-->3.此节点有左节点没有右节点-->继续遍历都为叶节点
 * 		-->4.此节点没有左右节点(叶节点)-->继续遍历都为叶节点
 */
public class _07判断是否为完全二叉树 {
	public static void main(String[] args) {
//		Tree mytree = new Tree(); 
//		mytree.add(4);
//		mytree.add(2);
//		mytree.add(6);
//		mytree.add(1);
//		mytree.add(3);
//		mytree.add(5);
//		mytree.add(7);
//		boolean b = isCompleteTree(mytree.head);
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.right = new Node(5);
		printTree(head);
		boolean b = isCompleteTree(head);
		System.out.println(b);
		
		head = new Node(100);
		head.left = new Node(21);
		head.right = new Node(-42);
		printTree(head);
		boolean b1 = isCompleteTree(head);
		System.out.println(b1);
	}
	
	//判断是否为完全二叉树(利用层次遍历实现)
	private static boolean isCompleteTree(Node head) {
		if (head==null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(head);
		boolean flag=false; //判断是否遇到了情况3和4
		while (!queue.isEmpty()) {
			head = queue.poll();
			{//局部代码块中包含的是判断逻辑
//				System.out.print(head.val+" ");
				if (head.right!=null&&head.left!=null&&!flag) {
				} else if (head.right!=null&&head.left==null&&!flag) {
					return false;
				} else {
					flag = true;
				}
				if (flag) {
					if (head.right!=null||head.left!=null) {
						return false;
					}
				}
			}
			if (head.left!=null) {
				queue.add(head.left);
			}
			if (head.right!=null) {
				queue.add(head.right);
			}
		}
		return true;
	}
	
	// for test -- print tree  ----工具打印类------工具打印类------工具打印类------工具打印类------工具打印类------
		public static class Node {
			public int val;
			public Node left;
			public Node right;

			public Node(int data) {
				this.val = data;
			}
		}
		
		public static void printTree(Node head) {
			System.out.println("Binary Tree:");
			printInOrder(head, 0, "H", 17);
			System.out.println();
		}

		public static void printInOrder(Node head, int height, String to, int len) {
			if (head == null) {
				return;
			}
			printInOrder(head.right, height + 1, "v", len);
			String val = to + head.val + to;
			int lenM = val.length();
			int lenL = (len - lenM) / 2;
			int lenR = len - lenM - lenL;
			val = getSpace(lenL) + val + getSpace(lenR);
			System.out.println(getSpace(height * len) + val);
			printInOrder(head.left, height + 1, "^", len);
		}

		public static String getSpace(int num) {
			String space = " ";
			StringBuffer buf = new StringBuffer("");
			for (int i = 0; i < num; i++) {
				buf.append(space);
			}
			return buf.toString();
		}
		
}
