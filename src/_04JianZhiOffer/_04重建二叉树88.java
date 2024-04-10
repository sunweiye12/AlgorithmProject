package _04JianZhiOffer;
import org.junit.Test;
/*
 * 题目:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 		假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 		例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 		则重建二叉树并返回。
 * 
 * 思路:给定两个先序和中序数组,可以通过先序的第一个返回二叉树的头结点,
 * 		得到头节点以后,通过中序数组可一将数组分成两部分,分别头部左边的中序和右边的中序,
 * 		同时也可以将先序数组分成两部分,分别为左面的先序和右面的先序
 * 		然后在求出左子结点和右子节点对应的数组,利用相同原则,返回个上一级
 */
public class _04重建二叉树88 {
	
	@Test
	public void main() {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		Node head = reConstructBinaryTree(pre, in);
		printTree(head);  //直观打印二叉树
		

	}
	public Node reConstructBinaryTree(int [] pre,int [] in) {
		if (pre==null || in==null || pre.length == 0 || in.length == 0) {
			return null;
		}
		Node head = getTreeHead(pre,0,pre.length-1,in,0,in.length-1); //给出先序和中序数组
		
        return head;
    }
	
	//通过给定先序和后续,返回头节点
	public Node getTreeHead(int [] pre,int start1,int end1,int [] in,int start2,int end2){
		//BaseCase
		if (start1>end1||start2>end2) {
			return null;
		}
		
		Node head = new Node(pre[start1]);
		for(int i = start2; i <= end2 ;i++){
			if (in[i] == pre[start1]) { //如果相等则说明找到了中序中的切割点
				head.left = getTreeHead(pre, start1+1, start1+i-start2, in, start2, i-1);
				head.right = getTreeHead(pre, start1+i-start2+1, end1, in, i+1, end2);
				break;
			}
		}
		
		return head;
	}
		
	
	//-----------工具-----------工具-----------工具-----------工具--------
	public class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value = data;
		}
	}

	public void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public void printInOrder(Node head, int height, String to, int len) {
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

	public String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}
	
}
