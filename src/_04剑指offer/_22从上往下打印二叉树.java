package _04剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import _04剑指offer._17树的字结构88.TreeNode;

/*
 * 题目:从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路:二叉树的层次遍历.理由队列来实现
 */
public class _22从上往下打印二叉树 {

	
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        	TreeNode tem = queue.poll();
        	System.out.println(tem.val);
        	list.add(tem.val);
        	if (tem.left != null) {
				queue.add(tem.left);
			}
        	if (tem.right != null) {
				queue.add(tem.right);
			}
        }
        return list;
    }
}
