package _07LeetCode;

import org.junit.Test;


/**
 * 链接: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree
 *
 * 方式1：需要借助一个set结构；首先需要将其中一个节点1，和其连续的父节点（直到root）放到这个set中。
 * 之后，依次判断节点2和其父节点是否在结合中，如果在集合中则将其返回。（这个解决不了问题的事我们拿不到一个节点的父节点。。。）
 *
 * 方式2：通过递归来实现：
 *       前提是二叉搜索树，所以结构是有序的。因此从 root开始判断，如果root等于这两个值的其中一个，或者是root大小在这两个值中间，则返回root。
 *       否则，如果这两个值都比root小，则递归进入左节点。
 *       否则，如果这两个值都比root大，则递归进入右节点。
 *
 */

public class _502树_二叉搜索树的最近公共祖先235 {



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
        System.out.println("开始");
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

    // 优化版（思路一致）
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

