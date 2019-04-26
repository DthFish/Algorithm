package leetcode;

import tree.TreeNode;

/**
 * leetcode 112:给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class Question112 {

    private static boolean find = false;

    public static boolean hasPathSum(TreeNode root, int sum) {

        if (find) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if(root.left == null && root.right == null && root.value == sum){
            find = true;
            return true;
        }
        return hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value);
    }

}
