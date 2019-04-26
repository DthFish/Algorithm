package leetcode;

import tree.TreeNode;

/**
 * leetcode 226:翻转二叉树
 */
public class Question226 {

    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }
}
