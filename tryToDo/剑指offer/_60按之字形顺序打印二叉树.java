package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

/*
 * 题目:请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 		第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 思路:运用两个栈结构来实现二叉树的层次遍历
 * 		1.奇数栈用于存放奇数层上的元素,偶数栈用于存放偶数层 上的信息
 * 		2.将头元素放入技术栈中
 * 		3.进入循环,循环截至的条件为两个栈为空时
 */
public class _60按之字形顺序打印二叉树 {
	@Test
	public void main() {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.left.left = new TreeNode(3);
		head.right = new TreeNode(4);
		head.right.left = new TreeNode(5);
		head.right.right = new TreeNode(6);
		printTree(head);
		Print(head);
	}
	
	 public ArrayList<ArrayList<Integer> > Print(TreeNode head) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		//basecase
		if (head == null) 
			return list;
		//创建奇数栈和偶数栈
		Stack<TreeNode> jishu = new Stack<TreeNode>();
		Stack<TreeNode> oushu = new Stack<TreeNode>();
		boolean flag = false; //用于标记当前位于奇数还是偶数
		jishu.push(head);
		while(jishu.size()!=0 || oushu.size()!=0){
			if (!flag) { //进入奇数栈
				ArrayList<Integer> tem = new ArrayList<Integer>();
				while(jishu.size()!=0){
					TreeNode temNode = jishu.pop();
					tem.add(temNode.val);
//					System.out.println(temNode.val);
					if (temNode.left != null) 
						oushu.push(temNode.left);
					if (temNode.right != null) 
						oushu.push(temNode.right);
				}
				list.add(tem);
				flag = true;
			} else {
				ArrayList<Integer> tem = new ArrayList<Integer>();
				while(oushu.size()!=0){
					TreeNode temNode = oushu.pop();
					tem.add(temNode.val);
//					System.out.println(temNode.val);
					if (temNode.right != null) 
						jishu.push(temNode.right);
					if (temNode.left != null) 
						jishu.push(temNode.left);
				}
				list.add(tem);
				flag = false;
			}
		}
		return list;
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
