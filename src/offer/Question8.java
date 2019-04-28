package offer;

import tree.ListTreeByLayer;
import tree.TreeNode;

import java.util.Arrays;

/**
 * 给出二叉树的先序和中序遍历，还原二叉树
 */
public class Question8 {

    public static void main(String[] args) {
        int[] first = {4, 3, 2, 6, 8, 7, 9};
        int[] mid = {2, 3, 8, 6, 4, 7, 9};

        TreeNode root = build(first, mid);
        //验证就直接后续遍历了
        ListTreeByLayer.postOrder(root);

    }


    public static TreeNode build(int[] first, int[] mid) {
        if (first == null || mid == null || first.length != mid.length || first.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(first[0]);
        int indexMid = 0;
        for (int i = 0; i < mid.length; i++) {
            if (mid[i] == first[0]) {
                indexMid = i;
                break;
            }
        }

        int[] leftFirst = Arrays.copyOfRange(first, 1, 1 + indexMid);
        int[] leftMid = Arrays.copyOfRange(mid, 0, indexMid);
        node.left = build(leftFirst, leftMid);
        int[] rightFirst = Arrays.copyOfRange(first, 1 + indexMid, first.length);
        int[] rightMid = Arrays.copyOfRange(mid, indexMid + 1, mid.length);
        node.right = build(rightFirst, rightMid);
        return node;
    }
}
