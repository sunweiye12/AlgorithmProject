package _04剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class _62序列化二叉树_先序 {
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.right.right = new TreeNode(5);
		printTree(head);

		String pre = serialByPre(head);
		System.out.println("序列化之后字符串: " + pre);
		head = reconByPreString(pre);
		System.out.print("反序列化之后, ");
		printTree(head);
	}

	//对二叉树进行序列化的方法(先序的方式)
	public static String serialByPre(TreeNode head) {
		if (head == null) {
			return "#!";
		}
		String res = head.val + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}
	
	
	//反序列化得到二叉树的头结点(先序的方式)
	public static TreeNode reconByPreString(String preStr) {
		String[] values = preStr.split("!");	//用!切分元素
		//将元素都添加到队列中
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i < values.length; i++) {
			queue.add(values[i]);	 //offer和add方法相同
		}
		return reconPreOrder(queue);
	}
	//根据队列创建二叉树并且返回根节点(先序的方式)
	public static TreeNode reconPreOrder(Queue<String> queue) {
		String value = queue.poll();	//队列头中拿出一个元素
		if (value.equals("#")) {		//如果第一个元素为空,则说明二叉树根节点为空
			return null;
		}
		//创建一个节点
		TreeNode head = new TreeNode(Integer.parseInt(value));
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;
	}
	
//--------------------------------------------------------------------------------------------------------
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
