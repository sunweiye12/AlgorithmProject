package _04JianZhiOffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/*
 * ����:���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
 */
public class _61�Ѷ�������ӡ�ɶ��� {
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
		//��������ջ��ż��ջ
		Queue<TreeNode> jishu = new LinkedList<TreeNode>();
		Queue<TreeNode> oushu = new LinkedList<TreeNode>();
		boolean flag = false; //���ڱ�ǵ�ǰλ����������ż��
		jishu.add(head);
		while(jishu.size()!=0 || oushu.size()!=0){
			if (!flag) { //��������ջ
				ArrayList<Integer> tem = new ArrayList<Integer>();
				while(jishu.size()!=0){
					TreeNode temNode = jishu.poll();
					tem.add(temNode.val);
//					System.out.println(temNode.val);
					if (temNode.left != null) 
						oushu.add(temNode.left);
					if (temNode.right != null) 
						oushu.add(temNode.right);
				}
				list.add(tem);
				flag = true;
			} else {
				ArrayList<Integer> tem = new ArrayList<Integer>();
				while(oushu.size()!=0){
					TreeNode temNode = oushu.poll();
					tem.add(temNode.val);
//					System.out.println(temNode.val);
					if (temNode.left != null) 
						jishu.add(temNode.left);
					if (temNode.right != null) 
						jishu.add(temNode.right);
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
