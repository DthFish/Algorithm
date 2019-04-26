package leetcode;

import tree.TreeNode;

import java.util.ArrayList;
/**
 * leetcode 98:验证二叉查找树
 */
public class Question98 {

    public static void main(String[] args) {

    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        ArrayList<Integer> list = new ArrayList<>();
        addToList(root, list);
        boolean result = true;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static void addToList(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        addToList(root.left, list);
        list.add(root.value);
        addToList(root.right, list);
    }
}
