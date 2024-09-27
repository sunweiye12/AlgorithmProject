package _07LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * 链接: https://leetcode.cn/problems/validate-binary-search-tree/description
 *  验证是否为二叉搜索树：
 *  二叉搜索树定义：
 *  1. 对于每个子树而言，父节点大于所有的左子节点
 *  2. 对于每个子树而言，父节点小于所有的右子节点
 *
 *  二叉树的遍历：
 *  前序遍历：中->左->右
 *  中序遍历：左->中->右
 *  后续遍历：左->右->中
 *
 *  递归解法：（时间复杂度O(n)）
 *  递归终止条件是当遇到节点为空的时候结束，返回true;
 *  如果不为空的话则需要判断，左边所有值的最大值都小于root；右边所有值的最小值都大于root；
 *
 *  所以我们预设了一个最小值和最大值。
 *
 */

public class _501树_验证二叉树98 {

    @Test
    public void main() {
        System.out.println("开始");
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

    // 前序遍历
    public void preTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preTraversal(root.left);
            preTraversal(root.right);
        }

    }

    // 中序遍历
    public void inTraversal(TreeNode root) {
        if (root != null) {
            preTraversal(root.left);
            System.out.println(root.val);
            preTraversal(root.right);
        }

    }

    // 后序遍历
    public void backTraversal(TreeNode root) {
        if (root != null) {
            preTraversal(root.left);
            preTraversal(root.right);
            System.out.println(root.val);
        }

    }

}

