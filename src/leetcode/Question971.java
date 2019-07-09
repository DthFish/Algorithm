package leetcode;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 971. 翻转二叉树以匹配先序遍历
 */
public class Question971 {

    public static void main(String[] args) {

    }

    private static int index = 0;

    public static List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> result = new ArrayList<>();
        index = 0;
        dps(root, result, voyage);
        if (!result.isEmpty() && result.get(0) == -1) {
            result.clear();
            result.add(-1);
        }

        return result;
    }

    private static void dps(TreeNode root, List<Integer> result, int[] voyage) {
        if (root != null) {
            if (root.val != voyage[index++]) {
                result.clear();
                result.add(-1);
                return;
            }
            // 左右交换的节点才添加进去
            if (index < voyage.length && root.left != null && root.left.val != voyage[index]) {
                result.add(root.val);
                dps(root.right, result, voyage);
                dps(root.left, result, voyage);
            } else {
                dps(root.left, result, voyage);
                dps(root.right, result, voyage);
            }
        }
    }
}
