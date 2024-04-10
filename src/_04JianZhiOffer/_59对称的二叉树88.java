package _04JianZhiOffer;

import org.junit.Test;
/*
 * ��Ŀ:��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 * 
 * ˼·:base
 * 		���ͷ���Ϊ��,����û�����Һ���,�򷵻�true
 * 		���ֻ����һ������,��Ϊfalse
 * 		����������Ӷ������,�򷵻�false
 * 	  �����������ֵ���,��׼��Ϊ�ж�������������Ϊͷ�Ķ������Ƿ�Ϊ�ԳƵ�.����ͷβhead1��head2
 * 		1.���head1��head2��Ϊ��,�򷵻�true
 * 		2.���head1��head2��ֻ��һ��Ϊ����һ����Ϊ���򷵻�false
 * 		3.������Ϊ��ʱ,�������ֵ��ͬҲ����false
 * 		4.������϶������ʾhead1��head2��ͬ,Ȼ��
 * 			�ж�partion(head1.right,head2.left) && partion(head1.left, head2.right);
 * 		���ؽ��
 * 
 */
public class _59�ԳƵĶ�����88 {

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
		//basecase    ����Ϊ�ջ���ֻ��ͷ�ڵ�ʱ
		if (head == null || (head.left == null && head .right == null)) {
			return true;
		}
		//��ֻ��һ������ ���� ��������ֵ��ͬʱ����false
		if(head.left == null || head.right == null || head.left.val != head.right.val){
			return false;
		}
		//����Ϊ��(��ֵ���)
		return partion(head.left,head.right); //�ж����������Ƿ�Ϊ�ԳƵ�
    }
	
	//�ж���head1��head2Ϊͷ���������ǲ��ǶԳƵ�
	private boolean partion(TreeNode head1, TreeNode head2) {
		//basecase ���Ҷ�Ϊ��
		if (head1 == null && head2 == null) {
			return true;
		}
		//����ֻ��һ��
		if ((head1 != null&&head2 == null) || (head1 == null&&head2 != null)) {
			return false;
		}
		//���Ҷ���,�Ҳ���
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
