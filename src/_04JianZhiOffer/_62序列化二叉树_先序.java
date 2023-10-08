package _04JianZhiOffer;

import java.util.LinkedList;
import java.util.Queue;

public class _62���л�������_���� {
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.right.right = new TreeNode(5);
		printTree(head);

		String pre = serialByPre(head);
		System.out.println("���л�֮���ַ���: " + pre);
		head = reconByPreString(pre);
		System.out.print("�����л�֮��, ");
		printTree(head);
	}

	//�Զ������������л��ķ���(����ķ�ʽ)
	public static String serialByPre(TreeNode head) {
		if (head == null) {
			return "#!";
		}
		String res = head.val + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}
	
	
	//�����л��õ���������ͷ���(����ķ�ʽ)
	public static TreeNode reconByPreString(String preStr) {
		String[] values = preStr.split("!");	//��!�з�Ԫ��
		//��Ԫ�ض���ӵ�������
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i < values.length; i++) {
			queue.add(values[i]);	 //offer��add������ͬ
		}
		return reconPreOrder(queue);
	}
	//���ݶ��д������������ҷ��ظ��ڵ�(����ķ�ʽ)
	public static TreeNode reconPreOrder(Queue<String> queue) {
		String value = queue.poll();	//����ͷ���ó�һ��Ԫ��
		if (value.equals("#")) {		//�����һ��Ԫ��Ϊ��,��˵�����������ڵ�Ϊ��
			return null;
		}
		//����һ���ڵ�
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
