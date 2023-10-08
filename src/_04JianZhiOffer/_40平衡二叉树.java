package _04JianZhiOffer;
/*
 * 题目:输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 
 * 思路:通过树形DP来实现,平衡二叉树是指,任意节点的左子树深度和右子树深度差都不超过1
 * 		因此判断一个数是否为平衡二叉树,需要知道其左子树是否为平衡二叉树,其右子树是否为平衡二叉树,已经其左右子树的深度
 * 		,如果其左右子树都为平衡二叉树,且韩都差不超过1,则此树为平衡二叉树
 * 		因此递归返回结果为<isBal,hight>,是否wi平衡二叉树,以及子数的高度
 */
public class _40平衡二叉树 {
	
	public boolean IsBalanced_Solution(TreeNode root) {
        Result reslt = partion(root);
		return reslt.isBal;
    }
	
	private Result partion(TreeNode root) {
		if (root == null) {
			return new Result(true, 0); //空树的话认为是平衡二叉树
		}
		if (root.left == null && root.right == null) {
			return new Result(true, 1);
		}
		//获取左右两棵树的结果
		Result leftResult = partion(root.left);
		Result rightResult = partion(root.right);
		//进行总结
		if (!leftResult.isBal || !rightResult.isBal) { //如果子树有一个部位平衡树,则整体都不是
			return new Result(false, 0);
		}
		if (Math.abs(leftResult.hight-rightResult.hight)>1) { //如果高度差大于1.则返回不是平衡树
			return new Result(false, 0);
		}
		return new Result(true, Math.max(leftResult.hight, rightResult.hight)+1);
	}
	class Result{
		boolean isBal = false;
		int hight = 0;
		public Result(boolean isBal, int hight) {
			super();
			this.isBal = isBal;
			this.hight = hight;
		}
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
