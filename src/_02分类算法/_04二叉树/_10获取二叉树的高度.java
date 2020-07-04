package _02分类算法._04二叉树;

import java.util.Stack;

import _02分类算法._04二叉树._00二叉树.TreeNode;

public class _10获取二叉树的高度 {

	/**
     * 递归求深度
     * @param root
     * @return
     */
	public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左子树的深度
        int left = treeDepth(root.left);
        // 计算右子树的深度
        int right = treeDepth(root.right);
        // 树root的深度=路径最长的子树深度 + 1
        return left >= right ? (left + 1) : (right + 1);
    }
	
	
	/**
     * 非递归，借助栈来计算深度(层数)
     * 比如                root，先放入栈中
     *         5          当前栈的元素数量为1，len=1，取出栈中此时所有的元素，即5，然后将其子节点3和7放入栈中
     *     3       7      当前栈的元素数量为2，len=2，所以连续从栈中pop两次，使栈中不在含有该层元素，同时将下层节点2和4放入栈中
     * 2       4          当前栈的元素数量为2，len=2，所以连续从栈中pop两次
     *                    记录深度，所以每次pop出栈中所有元素(某层的所有节点)只需深度+1，即depth++
     * @param root
     * @return
     */
    public static int treeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 初始化深度
        int depth =  0;
        // 存放每层树节点的栈
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // 将树的根(即第一层)放入栈中
        stack.push(root);
        while (!stack.isEmpty()) {
            // 当栈不为空时，层数+1，
            // 因为每次都会pop出当前层的所有节点，并将该层所有节点的子节点放入栈中
            depth++;
            // 当前栈中元素的数量
            int length = stack.size();
            while (length-- > 0) {
                // 取出栈中所有的节点，并将对应节点的子节点放入栈中
                TreeNode node = stack.pop();
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return depth;
    }
}
