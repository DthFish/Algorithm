package leetcode;

import tree.TreeNode;

/**
 * leetcode 104:二叉树的最大深度
 */
public class Question104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
