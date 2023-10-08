package _04JianZhiOffer;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

/*
 * ��Ŀ:��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ��
 * 		�ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 * ˼·:��������ջ�ṹ��ʵ�ֶ������Ĳ�α���
 * 		1.����ջ���ڴ���������ϵ�Ԫ��,ż��ջ���ڴ��ż���� �ϵ���Ϣ
 * 		2.��ͷԪ�ط��뼼��ջ��
 * 		3.����ѭ��,ѭ������������Ϊ����ջΪ��ʱ
 */
public class _60��֮����˳���ӡ������ {
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
		Stack<TreeNode> jishu = new Stack<TreeNode>();
		Stack<TreeNode> oushu = new Stack<TreeNode>();
		boolean flag = false; //���ڱ�ǵ�ǰλ����������ż��
		jishu.push(head);
		while(jishu.size()!=0 || oushu.size()!=0){
			if (!flag) { //��������ջ
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
