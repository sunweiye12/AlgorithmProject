package _07LeetCode;

import org.junit.Test;


/**
 * ����: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree
 *
 * ��ʽ1����Ҫ����һ��set�ṹ��������Ҫ������һ���ڵ�1�����������ĸ��ڵ㣨ֱ��root���ŵ����set�С�
 * ֮�������жϽڵ�2���丸�ڵ��Ƿ��ڽ���У�����ڼ��������䷵�ء�������������������������ò���һ���ڵ�ĸ��ڵ㡣������
 *
 * ��ʽ2��ͨ���ݹ���ʵ�֣�
 *       ǰ���Ƕ��������������Խṹ������ġ���˴� root��ʼ�жϣ����root����������ֵ������һ����������root��С��������ֵ�м䣬�򷵻�root��
 *       �������������ֵ����rootС����ݹ������ڵ㡣
 *       �������������ֵ����root����ݹ�����ҽڵ㡣
 *
 */

public class _502��_�����������������������235 {



    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void main() {
        System.out.println("��ʼ");
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode tmp = lowestCommonAncestor(root,root.left,root.right);
        System.out.println(tmp.val);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode max = p;
        TreeNode min = q;
        if (max.val < min.val) {
            max = q;
            min = p;
        }

        if (root.val > max.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < min.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;

    }

    // �Ż��棨˼·һ�£�
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

}

