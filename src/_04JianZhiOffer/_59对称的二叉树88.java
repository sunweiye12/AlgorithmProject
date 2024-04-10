package _04JianZhiOffer;

import org.junit.Test;
/*
 * 题目:请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * 思路:base
 * 		如果头结点为空,或者没有左右孩子,则返回true
 * 		如果只包含一个孩子,则为false
 * 		如果两个孩子都不相等,则返回false
 * 	  如果两个孩子值相等,则准换为判断以这两个孩子为头的二叉树是否为对称的.两个头尾head1和head2
 * 		1.如果head1和head2都为空,则返回true
 * 		2.如果head1和head2中只有一个为空另一个不为空则返回false
 * 		3.当都不为空时,如果两个值不同也返回false
 * 		4.如果以上都满足表示head1和head2相同,然后
 * 			判断partion(head1.right,head2.left) && partion(head1.left, head2.right);
 * 		返回结果
 * 
 */
public class _59对称的二叉树88 {

	@Test
	public void main() {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.left.left = new TreeNode(3);
		head.right = new TreeNode(2);
		head.right.left = new TreeNode(5);
		head.right.right = new TreeNode(3);
		printTree(head);
		boolean b = isSymmetrical(head);
		System.out.println(b);
	}
	
	public boolean isSymmetrical(TreeNode head){
		//basecase    当其为空或者只有头节点时
		if (head == null || (head.left == null && head .right == null)) {
			return true;
		}
		//当只有一个孩子 或者 两个孩子值不同时返回false
		if(head.left == null || head.right == null || head.left.val != head.right.val){
			return false;
		}
		//都不为空(且值相等)
		return partion(head.left,head.right); //判断这两科树是否为对称的
    }
	
	//判断以head1和head2为头的两棵树是不是对称的
	private boolean partion(TreeNode head1, TreeNode head2) {
		//basecase 左右都为空
		if (head1 == null && head2 == null) {
			return true;
		}
		//左右只有一个
		if ((head1 != null&&head2 == null) || (head1 == null&&head2 != null)) {
			return false;
		}
		//左右都有,且不等
		if (head1.val != head2.val) {
			return false;
		}
		return partion(head1.right,head2.left) && partion(head1.left, head2.right);
	}

	//-----------------------------------------------------------------------------------------------
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
