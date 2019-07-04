package _0工具箱类;

import org.junit.Test;

/**
 * 直观打印二叉树
 * @author Administrator
 *
 */

public class _05直观打印二叉树 {
	
	@Test
	public void main() {
		
		TreeNode head = new TreeNode(100);
		head.left = new TreeNode(21);
		head.left.left = new TreeNode(37);
		head.right = new TreeNode(-42);
		head.right.left = new TreeNode(0);
		head.right.right = new TreeNode(666);
		printTree(head);

	}
	
	public class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int data) {
			this.val = data;
		}
	}

	public void printTree(TreeNode head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public void printInOrder(TreeNode head, int height, String to, int len) {
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

	public String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}
}

