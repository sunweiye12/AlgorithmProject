package _1bytedance;

import java.util.ArrayList;
import java.util.List;

/*
 *题目: 二叉树的节点按照从上到下，从左到右，从1开始编号，其中空着的节点用“#”表示。输出树的左视图，如：
		输入：1 2 3 # 4 5 6 # # # # 7 8
		输出：1 2 4 7
 * 思路:左视图就是:打印每一层的第一个节点
 */
public class _14二叉树的左视图_0 {
	public List<Integer> rightSideView(TreeNode root) {
       List<Integer> list = new ArrayList<Integer>(); //创建用于返回是左视图节点
       rightSideView(root,list,0);
       return list;
    }
    public void rightSideView(TreeNode root, List<Integer> list ,int level) {
        if (root == null) {
            return;
        }
        //从第0层开始,每次将此层的最左面元素天剑到list,当添加一个以后此层就没办法在添加了
        if (level == list.size()) { 
            list.add(root.val);
        }
        rightSideView(root.left,list,level+1);
        rightSideView(root.right,list,level + 1);
     }
     
     public class TreeNode {
 		public int val;
 		public TreeNode left;
 		public TreeNode right;
 		public TreeNode(int data) {
 			this.val = data;
 		}
 	}
}
