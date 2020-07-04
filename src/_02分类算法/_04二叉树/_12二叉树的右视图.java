package _02分类算法._04二叉树;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/*
 * 思路:利用双队列来实现
 */
public class _12二叉树的右视图 {
	@Test
	public void main() {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.left.left = new TreeNode(3);
		head.right = new TreeNode(4);
		head.right.left = new TreeNode(5);
		head.right.right = new TreeNode(6);
		printTree(head);
		rightSideView(head);
	}
	
	private void rightSideView(TreeNode head) {
	 	if (head == null) {
	        return;
	    }
	 	ArrayList<Integer> list = new ArrayList<Integer>();
	 	list.size();
	 	//创建两个队列用来存储奇数和单数行
	 	Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
	 	Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
	 	boolean isJi = true;
	 	queue1.add(head);
	 	while(!queue1.isEmpty() || !queue2.isEmpty()){
	 		if (isJi) { //如果是奇数行
				while(!queue1.isEmpty()){
					head = queue1.poll();
					if (queue1.size() == 0) {
						System.out.println(head.val);
					}
					if (head.left  != null) {
						queue2.add(head.left);
					}
					if (head.right  != null) {
						queue2.add(head.right);
					}
				}
				isJi = false;
			} else{
				while(!queue2.isEmpty()){
					head = queue2.poll();
					if (queue2.size() == 0) {
						System.out.println(head.val);
					}
					if (head.left  != null) {
						queue1.add(head.left);
					}
					if (head.right  != null) {
						queue1.add(head.right);
					}
				}
				isJi = true;
			}
	 	}
	 	
	}

    //--------------------------------------------------------------
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
