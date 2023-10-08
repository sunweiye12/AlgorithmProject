package _04JianZhiOffer;
/*
 * ��Ŀ:����һ�ö��������жϸö������Ƿ���ƽ���������
 * 
 * ˼·:ͨ������DP��ʵ��,ƽ���������ָ,����ڵ����������Ⱥ���������Ȳ������1
 * 		����ж�һ�����Ƿ�Ϊƽ�������,��Ҫ֪�����������Ƿ�Ϊƽ�������,���������Ƿ�Ϊƽ�������,�Ѿ����������������
 * 		,���������������Ϊƽ�������,�Һ��������1,�����Ϊƽ�������
 * 		��˵ݹ鷵�ؽ��Ϊ<isBal,hight>,�Ƿ�wiƽ�������,�Լ������ĸ߶�
 */
public class _40ƽ������� {
	
	public boolean IsBalanced_Solution(TreeNode root) {
        Result reslt = partion(root);
		return reslt.isBal;
    }
	
	private Result partion(TreeNode root) {
		if (root == null) {
			return new Result(true, 0); //�����Ļ���Ϊ��ƽ�������
		}
		if (root.left == null && root.right == null) {
			return new Result(true, 1);
		}
		//��ȡ�����������Ľ��
		Result leftResult = partion(root.left);
		Result rightResult = partion(root.right);
		//�����ܽ�
		if (!leftResult.isBal || !rightResult.isBal) { //���������һ����λƽ����,�����嶼����
			return new Result(false, 0);
		}
		if (Math.abs(leftResult.hight-rightResult.hight)>1) { //����߶Ȳ����1.�򷵻ز���ƽ����
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
