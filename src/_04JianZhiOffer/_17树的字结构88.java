package _04JianZhiOffer;

import org.junit.Test;

/*
 * 题目:输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）\
 * (注意:1.本来就是两颗个树   2.是子结构而不是子树)
 * 
 * 思路:以root1为头结点开始遍历,直到找到一个节点与root2相等,则以这两个节点为头分别判断
 */
public class _17树的字结构88 {

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
		boolean hasSubtree = HasSubtree(root1, root4); //判断root2是不是root1的子节点
		System.out.println(hasSubtree);
	}
	
	public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为空的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            //以这个根节点为为起点判断是否包含Tree2
        		result = root1.val != root2.val ? result : doesTree1HaveTree2(root1,root2);
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
                result = result ? result :HasSubtree(root1.left,root2);
            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
                result = result ? result:HasSubtree(root1.right,root2);
        }
        //返回结果
        return result;
    }
 
    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        //如果其中有一个点没有对应上，返回false
        if (node1 == null ||node1.val != node2.val) {  
        	return false;
        }
        //如果根节点对应的上，那么就分别去子节点里面匹配
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
