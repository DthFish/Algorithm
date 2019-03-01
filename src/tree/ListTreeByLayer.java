package tree;

import java.util.ArrayDeque;

public class ListTreeByLayer {

    public static void main(String[] args) {
        int count = 10;
        TreeNode[] arr = new TreeNode[count + 1];
        for (int i = 1; i <= count; i++) {
            TreeNode treeNode = new TreeNode(i);
            arr[i] = treeNode;
        }

        for (int i = 1; i < count; i++) {
            if (i * 2 <= count) {
                arr[i].left = arr[i * 2];
            }

            if (i * 2 + 1 <= count) {
                arr[i].right = arr[i * 2 + 1];
            }
        }
        TreeNode root = arr[1];
        layerOrder(root);
        System.out.println("tree height:" + height(root));
    }

    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    public static void layerOrder(TreeNode root) {
        if (root == null) return;
        ArrayDeque<TreeNode> list = new ArrayDeque<>();
        list.offer(root);
        while (!list.isEmpty()) {
            TreeNode poll = list.poll();
            System.out.println(poll.value);
            if (poll.left != null) {
                list.offer(poll.left);
            }
            if (poll.right != null) {
                list.offer(poll.right);
            }
        }
    }

    public static int height(TreeNode root) {
        if (root == null) return -1;
        int leftH = height(root.left) + 1;
        int rightH = height(root.right) + 1;
        return leftH > rightH ? leftH : rightH;

    }
}
