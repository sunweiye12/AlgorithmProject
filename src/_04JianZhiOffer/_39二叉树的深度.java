package _04JianZhiOffer;

import org.junit.Test;

/*
 * ����:����һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 * 
 * ˼·:����ͨ���ݹ���ʵ��,һ�����ĸ߶�
 * 		����˽ڵ�û������Ҳû������,��߶�Ϊ1
 * 		����ĵĻ������ĸ߶�Ϊ�����߶��������߶Ƚϴ���Ǹ���1(����Ҫ�ж��Ƿ�Ϊ��)
 */
public class _39����������� {

	@Test
	public void main() {
		
	}
	
	public int TreeDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) {
			return 1;
		}
		//��ȡ�����������ĸ߶�
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
