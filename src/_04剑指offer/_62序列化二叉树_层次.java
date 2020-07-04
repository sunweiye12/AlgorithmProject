package _04剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class _62序列化二叉树_层次 {
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(100);
		head.left = new TreeNode(21);
		head.left.left = new TreeNode(37);
		head.right = new TreeNode(-42);
		head.right.left = new TreeNode(0);
		head.right.right = new TreeNode(666);
		printTree(head);


		String level = serialByLevel(head);
		System.out.println("序列化之后字符串: " + level);
		head = reconByLevelString(level);
		System.out.print("反序列化之后, ");
		printTree(head);
	}
	
	//层次遍历序列化
	public static String serialByLevel(TreeNode head) {
		if (head == null) {
			return "#!";
		}
		String res = head.val + "!";
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			if (head.left != null) {
				res += head.left.val + "!";
				queue.offer(head.left);
			} else {
				res += "#!";
			}
			if (head.right != null) {
				res += head.right.val + "!";
				queue.offer(head.right);
			} else {
				res += "#!";
			}
		}
		return res;
	}

	//层次遍历反序列化
	public static TreeNode reconByLevelString(String levelStr) {
		String[] values = levelStr.split("!");
		int index = 0;
		TreeNode head = generateNodeByString(values[index++]);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (head != null) {
			queue.offer(head);
		}
		TreeNode node = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			node.left = generateNodeByString(values[index++]);
			node.right = generateNodeByString(values[index++]);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return head;
	}

	public static TreeNode generateNodeByString(String val) {
		if (val.equals("#")) {
			return null;
		}
		return new TreeNode(Integer.valueOf(val));
	}
	
	// for test -- print tree  ----工具打印类------工具打印类------工具打印类------工具打印类------工具打印类------
		public static class TreeNode {
			public int val;
			public TreeNode left;
			public TreeNode right;

			public TreeNode(int data) {
				this.val = data;
			}
		}
		
		public static void printTree(TreeNode head) {
			System.out.println("Binary Tree:");
			printInOrder(head, 0, "H", 17);
			System.out.println();
		}

		public static void printInOrder(TreeNode head, int height, String to, int len) {
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
