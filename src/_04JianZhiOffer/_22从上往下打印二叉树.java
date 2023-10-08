package _04JianZhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import _04JianZhiOffer._17�����ֽṹ88.TreeNode;

/*
 * ��Ŀ:�������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 * ˼·:�������Ĳ�α���.���ɶ�����ʵ��
 */
public class _22�������´�ӡ������ {

	
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
