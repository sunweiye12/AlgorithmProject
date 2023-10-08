package _04JianZhiOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/*
 * 题目:输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 		要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * 思路:二叉树的中序遍历为排序数列.中序遍历节点然后让他们串联起来
 * 		中序遍历的结果放到一个arraylist集合中,然后将他们手牵手穿起来,返回第一个元素
 */
public class _26二叉搜索树与双向链表 {
	
	@Test
	public void main() {
		System.out.println("hahah");
	}
	
	public TreeNode Convert(TreeNode head) {
		if (head == null) {
			return null;
		}
		if (head.left==null && head.right == null) { //一个的时候直接返回(**因为后面一个元素的话还要单独讨论,所之这里处理方便**)
			return head;
		}
		List<TreeNode> list = new  ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || head != null){
        	if (head != null) {
        		stack.push(head);
        		head = head.left;
			} else {
				head = stack.pop();
//				System.out.println(head.val);
				list.add(head);
				head = head.right;
			}
        }
        //遍历list
        for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				TreeNode node = list.get(i);
				node.left = null;
				node.right = list.get(i+1);
			} else if(i == list.size()-1){
				TreeNode node = list.get(i);
				node.left = list.get(i-1);
				node.right = null;
			} else {
				TreeNode node = list.get(i);
				node.left = list.get(i-1);
				node.right = list.get(i+1);
			}
		}
		return list.get(0);
    }
	
	
	//------------------------------------------------------------------------------------------
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
}
