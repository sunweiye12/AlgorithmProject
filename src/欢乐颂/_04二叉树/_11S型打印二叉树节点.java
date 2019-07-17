package 欢乐颂._04二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 题目:设计S型层次遍历树的算法，比如根节点是第一层，第二层从左至右遍历，第三层从右至左遍历，第四层再从左至右遍历，以此类推。 
		举例：应依次输出 1 2 3 6 5 4 7 8 9。
 */
public class _11S型打印二叉树节点 {

	public static void printSTree(TreeNode root) {
		
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>(); //存放奇数层节点
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        int currentLevel = 1;//第一层开始
        queue1.add(root);	 //将根节点放入第一层
        
        while (!queue1.isEmpty() || !queue2.isEmpty()) { 
            if (currentLevel % 2 == 1) {
                TreeNode tempNode = queue1.poll();
                System.out.println(tempNode.val);
                if (tempNode.right != null)
                    queue2.add(tempNode.right);
                if (tempNode.left != null)
                    queue2.add(tempNode.left);
                if (queue1.isEmpty()) {
                    currentLevel++;
                }
            }
            else {
                TreeNode tempNode = queue2.poll();
                System.out.println(tempNode.val);
                if (tempNode.right != null)
                	queue1.add(tempNode.right);
                if (tempNode.left != null)
                    queue1.add(tempNode.left);
                if (queue2.isEmpty()) {
                    currentLevel++;
                }
            }
 
        }
    }
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
 
        public TreeNode(int val) {
            this.val = val;
        }
    }
	public static void main(String[] args) {
	        TreeNode node1 = new TreeNode(1);
	        TreeNode node2 = new TreeNode(2);
	        TreeNode node3 = new TreeNode(3);
	        TreeNode node4 = new TreeNode(4);
	        TreeNode node5 = new TreeNode(5);
	        TreeNode node6 = new TreeNode(6);
	        TreeNode node7 = new TreeNode(7);
	        TreeNode node8 = new TreeNode(8);
	        TreeNode node9 = new TreeNode(9);
	        /**
	         *      1
	         *    /   \
	         *   2     3
	         *  / \   / \
	         * 4   8  9  5
	         / \
	         7   6
	         */
	        node1.left = node2;
	        node1.right = node3;
	        node2.left = node4;
	        node2.right = node8;
	        node3.left = node9;
	        node3.right = node5;
	        node4.right = node6;
	        node4.left = node7;
	        printSTree(node1);
	 }
}
