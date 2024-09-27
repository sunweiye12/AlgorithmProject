package _07LeetCode;

import org.junit.Test;

import java.util.HashSet;


/**
 * 链接: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
 *
 *
 * 方式1：首先需要直到这两个节点是否都在左子树或右子树中，如果只在其中一个子树中则向下递归即可。
 *      那么如何知道呢？拿到根节点后，先判断p q 是否和root相同，相同直接返回 root
 *      遍历所有的左子树，将值放到一个set中：
 *      1. 如果p，q 都在set中 -》 递归左
 *      2. 如果p，q 都不在set中 -》 递归右
 *      3. 否则返回root
 *  这个方式需要有多层遍历右节点的操作，因此不是最优解。
 *
 *
 *  方式2：另外一种简化的地推方式：没有用到嵌套的遍历，因此简洁一些；
 *      递推的原则是：我能不能在这个分支中找到p或者q
 *      终止条件是：root = null ，或者 root等于 p或q，返回root；
 *      会分别将左节点，和右节点放入到下一层递推中，得到两个结果，left，right，分别代表，在左树和右树中是否找到p或者q。
 *
 *      返回值： 根据 left 和 right ，可展开为四种情况；
 *          当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
 *          当 left 和 right 同时不为空 ：说明 p,q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
 *          当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
 *              p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
 *              p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
 *          当 left 不为空 ， right 为空 ：与情况 3. 同理；
 *
 *
 */

public class _502树_二叉树的最近公共祖先236 {



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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode tmp = lowestCommonAncestor(root,root.left,root.left.right.right);
        System.out.println(tmp.val);

    }

    // 方案2：优化版本
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 递归终结者
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // 分别在左，右子树中看看能不能拿到p或者q，如果拿不到会返回null
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        // 两边都没有拿到
        if (left != null && right != null) {
            return root;
        }
        // 左面没有拿到
        if (left == null) {
            return right;
        }
        // 右面没有拿到
        if (right == null) {
            return left;
        }
        return root;
    }

    // 初始版本
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        // 遍历左叶子上的所有节点，返回一个set
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

