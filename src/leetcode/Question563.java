package leetcode;

import tree.TreeNode;

/**
 * leetcode 563. 二叉树的坡度
 *
 * 给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 */
public class Question563 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        node.left = node1;
        node.right = node2;
        System.out.println(findTilt(node));
    }

    private static int tilt = 0;

    public static int findTilt(TreeNode root) {
        tilt = 0;
        sum(root);
        return tilt;
    }

    public static int sum(TreeNode root) {
        if (root == null) return 0;
        int sumLeft = sum(root.left);
        int sumRight = sum(root.right);
        tilt += Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + root.val;
    }
}
