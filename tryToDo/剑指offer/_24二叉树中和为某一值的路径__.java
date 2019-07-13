package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import _0工具箱类._05直观打印二叉树.TreeNode;

/*
 * 题目:输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 	       路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * 
 * 思路:遍历每一条路径,并为每一条路径创建一个list,如果和为
 */
public class _24二叉树中和为某一值的路径__ {

	@Test
	public void main() {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(7);
//		head.left.left = new TreeNode(4);
		head.right = new TreeNode(2);
		head.right.left = new TreeNode(5);
		head.right.right = new TreeNode(4);
		printTree(head);
		
		ArrayList<ArrayList<Integer>> findPath = FindPath(head, 8); //得到的数组,按照长度进行排序

		Collections.sort(findPath,new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o2.size() - o1.size();  //字符串内置的比较方法compareTo
			}
		});
		
		for (ArrayList<Integer> arrayList : findPath) {
			System.out.println(arrayList);
		}
	}

	private void swap(ArrayList<ArrayList<Integer>> findPath, int i, int j) {
		ArrayList<Integer> tem = findPath.get(i);
		findPath.add(i, findPath.get(j)); //增加了元素
		findPath.add(j, tem);
	}

	ArrayList<ArrayList<Integer>> reList = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		if (root == null) {
			return reList;
		}
		
		list.add(root.val);
		target -= root.val;
		if (target == 0 && root.left == null && root.right == null) {//到达尾部且正好为target
			reList.add(new  ArrayList<Integer>(list)); 
			//此处要重新建一个list放入,而不能直接将list放入,因为list在后面还可能会用到,可能会变化
		}
		FindPath(root.left, target); //判断左节点能否加到里面
        FindPath(root.right, target); //判断右节点能否加到里面
        list.remove(list.size()-1);  //深度遍历时向上走一步要删除最后一个元素
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
