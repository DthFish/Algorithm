package awesome;

import tree.TreeNode;

/**
 * 给定一个二叉搜索树(BST)，找到树中第K小的节点，如下输入 3 得到是 3
 *       5
 *      / \
 *     3  6
 *    / \
 *   2  4
 *  /
 * 1
 */
public class Question1 {

    public static void main(String[] args) {

        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);

        five.right = six;
        five.left = three;
        three.right = four;
        three.left = two;
        two.left = one;

        System.out.println(find(five,3).val);



    }

    private static int sK = 0;
    private static TreeNode sMark;
    // 先序遍历
    private static TreeNode find(TreeNode root, int k) {
        sMark = null;
        sK = k;
        mark(root);
        return sMark;
    }

    private static void mark(TreeNode root) {
        if(root == null || sK == 0) {
            return;
        }
        mark(root.left);
        sK--;
        if(sK == 0){
            sMark = root;
        }
        mark(root.right);
    }

}
