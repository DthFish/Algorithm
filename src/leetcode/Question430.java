package leetcode;

public class Question430 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }


    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        if (head.child != null) {
            Node node = head.child;
            // child 的最后一个节点
            while (node.next != null) {
                node = node.next;
            }

            node.next = head.next;
            if (head.next != null) {
                head.next.prev = node;
            }
            head.next = head.child;
            head.child.prev = head;

            head.child = null;
        }
        flatten(head.next);

        return head;
    }
}
