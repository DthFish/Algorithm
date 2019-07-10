package leetcode;

import tree.TreeNode;

import java.util.HashMap;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class Question106 {

    HashMap<Integer, Integer> indexMap = new HashMap<>();
    int[] inorder;
    int[] postorder;
    int pre = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;

        pre = postorder.length;
        int index = 0;
        for (int i : inorder) {
            indexMap.put(i, index++);
        }
        return helper(0, postorder.length);


    }

    private TreeNode helper(int inLeft, int inRight) {
        if (inLeft == inRight) {
            return null;
        }
        int rootVal = postorder[pre - 1];
        pre--;
        TreeNode root = new TreeNode(rootVal);
        int index = indexMap.get(rootVal);
        //这里要从右往左，不然 pre 会出错
        root.right = helper(index + 1, inRight);
        root.left = helper(inLeft, index);
        return root;
    }
}
