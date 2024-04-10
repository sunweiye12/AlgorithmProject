package _04JianZhiOffer;

import org.junit.Test;
/*
 * ��Ŀ:��һ�Ŷ��������о���ת
 * 
 * ˼·:�ݹ�˼·:
 * 	1�����������Ľڵ�Ϊ��,����û���ӽڵ�,��ֱ��return����
 *	2����ͽ��������ҽڵ�
 *	3Ȼ��ݹ��������
 *	4�ݹ�����Һ���
 */

public class _18�������ľ��� {

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
		//���rootΪ�վͷ���
		if (root == null) {
			return;
		}
		//�������Ϊ������ҲΪ�յĻ�,ֹͣ����
		if (root.left == null && root.right == null ) {
			return;
		}
		//���������Һ��ӽ���
		TreeNode tem = root.left;
		root.left = root.right;
		root.right = tem;
		//Ȼ�����ӽڵ����
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
