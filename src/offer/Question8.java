package offer;

/**
 * 二叉树的下一个节点：给定二叉树和一个节点，找出中序遍历的下一个节点（每个节点除了左右子节点还有一个指向父节点的引用）
 */
public class Question8 {
    private static class Node {
        String value;
        Node left;
        Node right;
        Node parent;

        public Node(String value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
            if (left != null) {
                left.parent = this;
            }
        }

        public void setRight(Node right) {
            this.right = right;
            if (right != null) {
                right.parent = this;
            }
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node d = new Node("d");
        Node e = new Node("e");
        Node h = new Node("h");
        Node i = new Node("i");
        Node c = new Node("c");
        Node f = new Node("f");
        Node g = new Node("g");

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        e.setLeft(h);
        e.setRight(i);
        c.setLeft(f);
        c.setRight(g);
        //dbheiafcg

        System.out.println("result:f" + "-find:" + findNext(a));
        System.out.println("result:h" + "-find:" + findNext(b));
        System.out.println("result:g" + "-find:" + findNext(c));
        System.out.println("result:b" + "-find:" + findNext(d));
        System.out.println("result:i" + "-find:" + findNext(e));
        System.out.println("result:c" + "-find:" + findNext(f));
        System.out.println("result:null" + "-find:" + findNext(g));
        System.out.println("result:e" + "-find:" + findNext(h));
        System.out.println("result:a" + "-find:" + findNext(i));

    }

    public static Node findNext(Node target) {
        //如果 target 有右子树，则为右子树的最左节点
        //如果 target 没有右子树，且为父节点的左节点，则为父节点
        //如果 target 没有右子树，且为父节点的右节点，则一直向上查找父节点直到该父节点为它的父节点的左节点，那么该父节点的父节点就是要找的节点
        //其余为空

        if (target.right != null) {
            Node temp = target.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } else if (target.parent != null && target.parent.left == target) {
            return target.parent;
        } else if (target.parent != null && target.parent.right == target) {
            Node temp = target.parent;
            while (temp.parent != null) {
                if (temp.parent.left == temp) {
                    return temp.parent;
                }
                temp = temp.parent;
            }
        }
        return null;
    }

}
