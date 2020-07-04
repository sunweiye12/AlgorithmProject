package _04剑指offer;

import java.util.Stack;

import org.junit.Test;

/*
 * 题目:给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 		例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 
 * 注意:中序遍历的第K个节点
 */
public class _63二叉搜索树的第k个结点 {

	@Test
	public void main( ) {
		
	}
	
	TreeNode KthNode(TreeNode root, int k){
		//basecase
		if(root == null || k <= 0){
			return null;
		}
		//中序遍历
        Stack<TreeNode> stack = new  Stack<TreeNode>();
        int i = 0;
        while(!stack.isEmpty() || root != null){
        	if(root != null){
        		stack.push(root);
        		root = root.left;
        	} else{
        		root = stack.pop();
//        		System.out.println(root.val);
        		i++;
        		if(i == k){
        			return root;
        		}
        		root = root.right;
        	}
        }
		return null;
    }
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
}
