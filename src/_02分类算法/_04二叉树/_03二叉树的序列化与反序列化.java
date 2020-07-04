package _02分类算法._04二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
	扩展:所谓的序列化就是将二叉树转化为固定格式的字符串以用来进行存储
	  	而反序列化则是将序列化的字符串转换成二叉树
	  	(需要在一个值的结尾加!作为分隔符,在空位置用#代替)
 * @author Administrator
 */
public class _03二叉树的序列化与反序列化 {
	
	public static void main(String[] args) {
		Node head = null;
		printTree(head);

		String pre = serialByPre(head);
		System.out.println("序列化之后字符串: " + pre);
		head = reconByPreString(pre);
		System.out.print("反序列化之后, ");
		printTree(head);

		String level = serialByLevel(head);
		System.out.println("序列化之后字符串:  " + level);
		head = reconByLevelString(level);
		System.out.print("反序列化之后, ");
		printTree(head);

		System.out.println("====================================");

		head = new Node(1);
		printTree(head);

		pre = serialByPre(head);
		System.out.println("序列化之后字符串: " + pre);
		head = reconByPreString(pre);
		System.out.print("反序列化之后, ");
		printTree(head);

		level = serialByLevel(head);
		System.out.println("序列化之后字符串: " + level);
		head = reconByLevelString(level);
		System.out.print("反序列化之后, ");
		printTree(head);

		System.out.println("=================================");

		head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.right = new Node(5);
		printTree(head);

		pre = serialByPre(head);
		System.out.println("序列化之后字符串: " + pre);
		head = reconByPreString(pre);
		System.out.print("反序列化之后, ");
		printTree(head);

		level = serialByLevel(head);
		System.out.println("序列化之后字符串: " + level);
		head = reconByLevelString(level);
		System.out.print("反序列化之后, ");
		printTree(head);

		System.out.println("====================================");

		head = new Node(100);
		head.left = new Node(21);
		head.left.left = new Node(37);
		head.right = new Node(-42);
		head.right.left = new Node(0);
		head.right.right = new Node(666);
		printTree(head);

		pre = serialByPre(head);
		System.out.println("序列化之后字符串: " + pre);
		head = reconByPreString(pre);
		System.out.print("反序列化之后, ");
		printTree(head);

		level = serialByLevel(head);
		System.out.println("序列化之后字符串: " + level);
		head = reconByLevelString(level);
		System.out.print("反序列化之后, ");
		printTree(head);

		System.out.println("====================================");

	}

	//对二叉树进行序列化的方法(先序的方式)
	public static String serialByPre(Node head) {
		if (head == null) {
			return "#!";
		}
		String res = head.value + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}
	//反序列化得到二叉树的头结点(先序的方式)
	public static Node reconByPreString(String preStr) {
		String[] values = preStr.split("!");	//用!切分元素
		//将元素都添加到队列中
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i < values.length; i++) {
			queue.offer(values[i]);	 //offer和add方法相同
		}
		return reconPreOrder(queue);
	}
	
	//根据队列创建二叉树并且返回根节点(先序的方式)
	public static Node reconPreOrder(Queue<String> queue) {
		String value = queue.poll();	//队列头中拿出一个元素
		if (value.equals("#")) {		//如果第一个元素为空,则说明二叉树根节点为空
			return null;
		}
		//创建一个节点
		Node head = new Node(Integer.parseInt(value));
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;
	}
	
//-----------------------------------------------------------------------------------------------------
//----------------------------------------按层进行序列化很反序列化-------------------------------------------
//-----------------------------------------------------------------------------------------------------
	public static String serialByLevel(Node head) {
		if (head == null) {
			return "#!";
		}
		String res = head.value + "!";
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			if (head.left != null) {
				res += head.left.value + "!";
				queue.offer(head.left);
			} else {
				res += "#!";
			}
			if (head.right != null) {
				res += head.right.value + "!";
				queue.offer(head.right);
			} else {
				res += "#!";
			}
		}
		return res;
	}

	public static Node reconByLevelString(String levelStr) {
		String[] values = levelStr.split("!");
		int index = 0;
		Node head = generateNodeByString(values[index++]);
		Queue<Node> queue = new LinkedList<Node>();
		if (head != null) {
			queue.offer(head);
		}
		Node node = null;
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

	public static Node generateNodeByString(String val) {
		if (val.equals("#")) {
			return null;
		}
		return new Node(Integer.valueOf(val));
	}


	
	
	// for test -- print tree  ----工具打印类------工具打印类------工具打印类------工具打印类------工具打印类------
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
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
		String val = to + head.value + to;
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
