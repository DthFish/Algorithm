package leetcode;

import tree.TreeNode;

/**
 * 671. 二叉树中第二小的节点
 */
public class Question671 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);

        System.out.println(findSecondMinimumValue(root));
    }

    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int min = -1;
        if (root.left != null) {
            if (root.left.val > root.val) {
                min = root.left.val;
            } else {
                min = findSecondMinimumValue(root.left);
            }
        }

        if (root.right != null) {
            if (root.right.val > root.val) {
                if (min >= 0) {
                    min = Math.min(min, root.right.val);
                } else {
                    min = root.right.val;
                }
            } else {
                if (min >= 0) {
                    final int right = findSecondMinimumValue(root.right);
                    min = Math.min(min, right >= 0 ? right : min);

                } else {
                    min = findSecondMinimumValue(root.left);
                }

            }
        }


        return min;
    }
}
