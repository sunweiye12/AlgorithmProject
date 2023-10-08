package _04JianZhiOffer;

import java.util.Stack;

import org.junit.Test;

/*
 * ��Ŀ:����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣
 * 		���磬 ��5��3��7��2��4��6��8��    �У��������ֵ��С˳�����С����ֵΪ4��
 * 
 * ע��:��������ĵ�K���ڵ�
 */
public class _63�����������ĵ�k����� {

	@Test
	public void main( ) {
		
	}
	
	TreeNode KthNode(TreeNode root, int k){
		//basecase
		if(root == null || k <= 0){
			return null;
		}
		//�������
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
