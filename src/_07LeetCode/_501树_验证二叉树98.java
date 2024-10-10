package _07LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * ����: https://leetcode.cn/problems/validate-binary-search-tree/description
 *  ��֤�Ƿ�Ϊ������������
 *  �������������壺
 *  1. ����ÿ���������ԣ����ڵ�������е����ӽڵ�
 *  2. ����ÿ���������ԣ����ڵ�С�����е����ӽڵ�
 *
 *  �������ı�����
 *  ǰ���������->��->��
 *  �����������->��->��
 *  ������������->��->��
 *
 *  �ݹ�ⷨ����ʱ�临�Ӷ�O(n)��
 *  �ݹ���ֹ�����ǵ������ڵ�Ϊ�յ�ʱ�����������true;
 *  �����Ϊ�յĻ�����Ҫ�жϣ��������ֵ�����ֵ��С��root���ұ�����ֵ����Сֵ������root��
 *
 *  ��������Ԥ����һ����Сֵ�����ֵ��
 *
 */

public class _501��_��֤������98 {

    @Test
    public void main() {
        System.out.println("��ʼ");
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

//        System.out.println(isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        preTraversal(root);
        inTraversal(root);
        backTraversal(root);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

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

    // ǰ�����
    public void preTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preTraversal(root.left);
            preTraversal(root.right);
        }

    }

    // �������
    public void inTraversal(TreeNode root) {
        if (root != null) {
            preTraversal(root.left);
            System.out.println(root.val);
            preTraversal(root.right);
        }

    }

    // �������
    public void backTraversal(TreeNode root) {
        if (root != null) {
            preTraversal(root.left);
            preTraversal(root.right);
            System.out.println(root.val);
        }

    }

}

