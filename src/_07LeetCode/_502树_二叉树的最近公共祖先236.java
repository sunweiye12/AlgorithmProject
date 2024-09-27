package _07LeetCode;

import org.junit.Test;

import java.util.HashSet;


/**
 * ����: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
 *
 *
 * ��ʽ1��������Ҫֱ���������ڵ��Ƿ������������������У����ֻ������һ�������������µݹ鼴�ɡ�
 *      ��ô���֪���أ��õ����ڵ�����ж�p q �Ƿ��root��ͬ����ֱͬ�ӷ��� root
 *      �������е�����������ֵ�ŵ�һ��set�У�
 *      1. ���p��q ����set�� -�� �ݹ���
 *      2. ���p��q ������set�� -�� �ݹ���
 *      3. ���򷵻�root
 *  �����ʽ��Ҫ�ж������ҽڵ�Ĳ�������˲������Ž⡣
 *
 *
 *  ��ʽ2������һ�ּ򻯵ĵ��Ʒ�ʽ��û���õ�Ƕ�׵ı�������˼��һЩ��
 *      ���Ƶ�ԭ���ǣ����ܲ����������֧���ҵ�p����q
 *      ��ֹ�����ǣ�root = null ������ root���� p��q������root��
 *      ��ֱ���ڵ㣬���ҽڵ���뵽��һ������У��õ����������left��right���ֱ�������������������Ƿ��ҵ�p����q��
 *
 *      ����ֵ�� ���� left �� right ����չ��Ϊ���������
 *          �� left �� right ͬʱΪ�� ��˵�� root ���� / �������ж������� p,q ������ null ��
 *          �� left �� right ͬʱ��Ϊ�� ��˵�� p,q ������ root �� ��� ���ֱ��� �� / ������������� root Ϊ����������ȣ����� root ��
 *          �� left Ϊ�� ��right ��Ϊ�� ��p,q ������ root ���������У�ֱ�ӷ��� right ������ɷ�Ϊ���������
 *              p,q ����һ���� root �� ������ �У���ʱ right ָ�� p������Ϊ p ����
 *              p,q ���ڵ㶼�� root �� ������ �У���ʱ�� right ָ�� ����������Ƚڵ� ��
 *          �� left ��Ϊ�� �� right Ϊ�� ������� 3. ͬ��
 *
 *
 */

public class _502��_�������������������236 {



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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode tmp = lowestCommonAncestor(root,root.left,root.left.right.right);
        System.out.println(tmp.val);

    }

    // ����2���Ż��汾
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // �ݹ��ս���
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // �ֱ������������п����ܲ����õ�p����q������ò����᷵��null
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        // ���߶�û���õ�
        if (left != null && right != null) {
            return root;
        }
        // ����û���õ�
        if (left == null) {
            return right;
        }
        // ����û���õ�
        if (right == null) {
            return left;
        }
        return root;
    }

    // ��ʼ�汾
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        // ������Ҷ���ϵ����нڵ㣬����һ��set
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        HashSet<Integer> setZuo = new HashSet<>();
        getSet(root.left, setZuo);
        if (setZuo.contains(p.val) && setZuo.contains(q.val)) {
            return lowestCommonAncestor(root.left,p,q);
        }
        if (!setZuo.contains(p.val) && !setZuo.contains(q.val)) {
            return lowestCommonAncestor(root.right,p,q);
        }

        return root;
    }

    private void getSet(TreeNode root, HashSet<Integer> setZuo) {
        if (root != null) {
            setZuo.add(root.val);
            getSet(root.left, setZuo);
            getSet(root.right, setZuo);
        }
    }

}

