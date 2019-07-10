package leetcode;

import tree.TreeNode;

import java.util.HashMap;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class Question105 {

    int[] preorder;
    int[] inorder;
    int pre;
    HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.preorder = preorder;
        this.inorder = inorder;
        int index = 0;
        for (int i : inorder) {
            indexMap.put(i, index++);
        }
        pre = 0;

        return helper(0, preorder.length);
    }

    private TreeNode helper(int inLeft, int inRight) {
        if (inLeft == inRight) {
            return null;
        }
        int rootVal = preorder[pre];
        pre++;
        TreeNode root = new TreeNode(rootVal);
        int index = indexMap.get(rootVal);
        root.left = helper(inLeft, index);
        root.right = helper(index + 1, inRight);
        return root;

    }
}
