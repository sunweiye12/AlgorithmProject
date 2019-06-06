package 欢乐颂._07递归;

import java.util.LinkedList;

import org.junit.Test;

/*
 * 递归来来解决二叉树问题
 * 题目:给定一个二叉树的头结点.返回二叉树中的最大和最小值
 * 
 * 用于解决所有二叉树的问题:
 * 	将问题分解:假如说给你一个头结点可能会存在一下情况
 * 		1.最小值和最大值来自左子树
 * 		2.最小值和最大值来自右子树
 * 		3.自己为头可能是最大值或最小值的一个
 * 
 * 	我们进行是那个面的分解所需要的条件:
 * 		1.左树中的最大值
 * 		2.左树中的最小值
 * 		3.右树中的最大值
 * 		4.右树中的最小值
 * 	化简为每次递归函数主要返回的参数:
 * 		1.此节点为头的子树的最大值
 * 		2.此节点为头的子树的最小值
 * 
 * 
 * 第一步:先写一个返回值类
 * 第二部:完成patition
 * 		1.写递归函数的截止返回
 * 		2.分别得到左子树和右子树的返回值
 * 		3.通过左右子树的返回值来得到当前节点的返回值返回给父
 */

public class _02棵树的最大值和最小值_递归法 {
	@Test
	public void main() {
		Tree mytree = new Tree();
		mytree.add(5);
		mytree.add(3);
		mytree.add(8);
		mytree.add(1);
		mytree.add(4);
		mytree.add(7);
		mytree.add(1);

		System.out.println(patition1(mytree.head).max);
		System.out.println(patition1(mytree.head).min);
	}

	// 创建一个返回值类型的类
	public class ReturnDate {
		int max;
		int min;
		public ReturnDate(int max, int min) {
			this.max = max;
			this.min = min;
		}
	}

	public ReturnDate patition1(Node head) {
		if (head == null) {
			throw new RuntimeException("输入有错!");
		}
		return patition(head);
	}

	public ReturnDate patition(Node head) {
		// 递归截止条件
		if (head == null) {
			return new ReturnDate(Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		// 递归函数(假设左树环额右树都能得到返回值)----> 递归的调用可以当做是黑盒
		Node left = head.left;
		ReturnDate leftReturnDate = patition(left); // 左子树返回值
		Node right = head.right;
		ReturnDate rightReturnDate = patition(right); // 右子树返回值

		// 得到左右两边的返回值以后开始找出当前节点的信息返回给父
		int max = Math.max(head.value,
				Math.max(leftReturnDate.max, rightReturnDate.max));
		int min = Math.min(head.value,
				Math.min(leftReturnDate.min, rightReturnDate.min));

		return new ReturnDate(max, min);
	}

	// ------------------------------工具类--------------------------------------------------------
	// 创建树的节点对象
	class Node {
		int value;
		Node left = null;
		Node right = null;

		public Node(int val) {
			this.value = val;
		}
	}

	// 一个树的类
	class Tree {
		public Node head = null; // 存在一个结点元素

		// 添加元素(层级添加)
		public void add(int item) {
			Node node = new Node(item);
			if (head == null) {
				head = node;
				return;
			}

			LinkedList<Node> list = new LinkedList<Node>(); // 创建一个列表来存储元素
			list.add(head); // 每次追加到链表尾端
			while (list.size() != 0) {
				Node cur_node = list.getFirst(); // 每次从头部获取(并删除)
				list.removeFirst();
				if (cur_node.left == null) {
					cur_node.left = node;
					return;
				} else {
					list.add(cur_node.left);
				}

				if (cur_node.right == null) {
					cur_node.right = node;
					return;
				} else {
					list.add(cur_node.right);
				}
			}
		}
	}
}
