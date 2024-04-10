package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:�������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��\
 * (ע��:1.�����������Ÿ���   2.���ӽṹ����������)
 * 
 * ˼·:��root1Ϊͷ��㿪ʼ����,ֱ���ҵ�һ���ڵ���root2���,�����������ڵ�Ϊͷ�ֱ��ж�
 */
public class _17�����ֽṹ88 {

	@Test
	public void main() {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		TreeNode root6 = new TreeNode(6);
		root1.left = root2;
		root1.right = root3;
		root2.left = root4;
		root2.right = root5;
		root3.left = root6;
		printTree(root1);
		boolean hasSubtree = HasSubtree(root1, root4); //�ж�root2�ǲ���root1���ӽڵ�
		System.out.println(hasSubtree);
	}
	
	public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //��Tree1��Tree2����Ϊ�յ�ʱ�򣬲Ž��бȽϡ�����ֱ�ӷ���false
        if (root2 != null && root1 != null) {
            //����ҵ��˶�ӦTree2�ĸ��ڵ�ĵ�
            //��������ڵ�ΪΪ����ж��Ƿ����Tree2
        		result = root1.val != root2.val ? result : doesTree1HaveTree2(root1,root2);
            //����Ҳ�������ô����ȥroot������ӵ�����㣬ȥ�ж�ʱ�����Tree2
                result = result ? result :HasSubtree(root1.left,root2);
            //������Ҳ�������ô����ȥroot���Ҷ��ӵ�����㣬ȥ�ж�ʱ�����Tree2
                result = result ? result:HasSubtree(root1.right,root2);
        }
        //���ؽ��
        return result;
    }
 
    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //���Tree2�Ѿ��������˶��ܶ�Ӧ���ϣ�����true
        if (node2 == null) {
            return true;
        }
        //���Tree2��û�б����꣬Tree1ȴ�������ˡ�����false
        //���������һ����û�ж�Ӧ�ϣ�����false
        if (node1 == null ||node1.val != node2.val) {  
        	return false;
        }
        //������ڵ��Ӧ���ϣ���ô�ͷֱ�ȥ�ӽڵ�����ƥ��
        return doesTree1HaveTree2(node1.left,node2.left) && doesTree1HaveTree2(node1.right,node2.right);
    }
	

	//----------------------------------------------------------------------
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	public void printTree(TreeNode head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public void printInOrder(TreeNode head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.val + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}
}
