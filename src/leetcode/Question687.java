package leetcode;

import tree.TreeNode;

/**
 * 687. 最长同值路径
 */
public class Question687 {
    public static void main(String[] args) {

    }

    static int result = 0;

    public static int longestUnivaluePath(TreeNode root) {
        result = 0;
        findPath(root);
        return result;
    }

    private static int findPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findPath(root.left);
        int right = findPath(root.right);
        // 这里不能省略 为 left = left + 1; 因为如果左边一旦不成立，我们就要将左边的答案舍弃
        int allowLeft = 0;
        int allowRight = 0;
        if (root.left != null && root.left.value == root.value) {
            allowLeft = left + 1;
        }

        if (root.right != null && root.right.value == root.value) {
            allowRight = right + 1;
        }
        // 这里是因为最长路径可能从左子树通过父节点连接到右子树
        result = Math.max(result, allowLeft + allowRight);
        return Math.max(allowLeft, allowRight);
    }
}
