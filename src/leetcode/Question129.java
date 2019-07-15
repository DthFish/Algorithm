package leetcode;

import tree.TreeNode;

public class Question129 {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root, 0);

    }

    private int sum(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return val * 10 + node.val;
        }
        int sum = 0;
        if (node.left != null) {
            sum += sum(node.left, val * 10 + node.val);
        }
        if (node.right != null) {
            sum += sum(node.right, val * 10 + node.val);
        }

        return sum;
    }
}
