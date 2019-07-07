package 剑指offer;

import org.junit.Test;

import 剑指offer._17树的字结构$$.TreeNode;
/*
 * 题目:将一颗二叉树进行镜像反转
 * 
 * 思路:递归思路:
 * 	1首先如果传入的节点为空,或者没有子节点,则直接return结束
 *	2否则就交换其左右节点
 *	3然后递归调用左孩子
 *	4递归调用右孩子
 */

public class _18二叉树的镜像 {

	@Test
	public void main() {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		TreeNode root6 = new TreeNode(6);
		root1.left = root2;
		root1.right = root3;
		root2.left = root4;
		root2.right = root5;
		root3.left = root6;
		printTree(root1);
		Mirror(root1);
		printTree(root1);
	}
	
	public void Mirror(TreeNode root) {
		//如果root为空就返回
		if (root == null) {
			return;
		}
		//如果左面为空右面也为空的话,停止交换
		if (root.left == null && root.right == null ) {
			return;
		}
		//否者让左右孩子交换
		TreeNode tem = root.left;
		root.left = root.right;
		root.right = tem;
		//然后其子节点遍历
		Mirror(root.left);
		Mirror(root.right);
    }
	
	//-------------------------------------------------------------------------------------
	//----------------------------------------------------------------------
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
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
