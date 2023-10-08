package _04JianZhiOffer;

import org.junit.Test;

/*
 * 题意:输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 
 * 思路:可以通过递归来实现,一个树的高度
 * 		如果此节点没有左树也没有右树,则高度为1
 * 		否则的的话此树的高度为左树高度与右树高度较大的那个加1(其中要判断是否为空)
 */
public class _39二叉树的深度 {

	@Test
	public void main() {
		
	}
	
	public int TreeDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) {
			return 1;
		}
		//获取左树和右树的高度
		int	leftLen = TreeDepth(root.left);
		int	rightLen = TreeDepth(root.right);
		return Math.max(leftLen, rightLen)+1;
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
