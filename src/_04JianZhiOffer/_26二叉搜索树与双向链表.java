package _04JianZhiOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/*
 * ��Ŀ:����һ�ö��������������ö���������ת����һ�������˫������
 * 		Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * 
 * ˼·:���������������Ϊ��������.��������ڵ�Ȼ�������Ǵ�������
 * 		��������Ľ���ŵ�һ��arraylist������,Ȼ��������ǣ�ִ�����,���ص�һ��Ԫ��
 */
public class _26������������˫������ {
	
	@Test
	public void main() {
		System.out.println("hahah");
	}
	
	public TreeNode Convert(TreeNode head) {
		if (head == null) {
			return null;
		}
		if (head.left==null && head.right == null) { //һ����ʱ��ֱ�ӷ���(**��Ϊ����һ��Ԫ�صĻ���Ҫ��������,��֮���ﴦ����**)
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
        //����list
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
