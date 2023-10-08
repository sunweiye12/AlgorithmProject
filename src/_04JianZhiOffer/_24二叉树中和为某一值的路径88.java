package _04JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

/*
 * ��Ŀ:����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * 	       ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 * 
 * ˼·:����ÿһ��·��,��Ϊÿһ��·������һ��list,�����Ϊ
 */
public class _24�������к�Ϊĳһֵ��·��88 {

	@Test
	public void main() {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(7);
		head.left.left = new TreeNode(4);
		head.right = new TreeNode(2);
		head.right.left = new TreeNode(5);
		head.right.right = new TreeNode(4);
		printTree(head);
		
		ArrayList<ArrayList<Integer>> findPath = FindPath(head, 8); //�õ�������,���ճ��Ƚ�������

		Collections.sort(findPath,new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o2.size() - o1.size();  //�ַ������õıȽϷ���compareTo
			}
		});
		

		for (ArrayList<Integer> arrayList : findPath) {
			System.out.println(arrayList);
		}
	}


	ArrayList<ArrayList<Integer>> reList = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		if (root == null) {
			return reList;
		}
		
		list.add(root.val);
		target -= root.val;
		if (target == 0 && root.left == null && root.right == null) {//����β��������Ϊtarget
			reList.add(new  ArrayList<Integer>(list)); 
			//�˴�Ҫ���½�һ��list����,������ֱ�ӽ�list����,��Ϊlist�ں��滹���ܻ��õ�,���ܻ�仯
		}
		FindPath(root.left, target); //�ж���ڵ��ܷ�ӵ�����
        FindPath(root.right, target); //�ж��ҽڵ��ܷ�ӵ�����
        list.remove(list.size()-1);  //��ȱ���ʱ������һ��Ҫɾ�����һ��Ԫ��
		return reList;
    }
	
//-----------------------------------------------------------------------------------------------------	
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
