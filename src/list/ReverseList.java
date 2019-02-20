package list;

/**
 * LeetCode 206
 * 反转单链表：1.循环实现;2.递归实现
 * 要经常回顾和思考呀
 */
public class ReverseList {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Node head = new Node(0);
        Node current = head;
        for (int i = 1; i < 3; i++) {
            current.next = new Node(i);
            current = current.next;
        }
        System.out.println(head);

        Node reversed = reverse(head);
        System.out.println(reversed);
    }

    private static Node reverse2(Node node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            Node headNode = reverse2(node.next);
            node.next.next = node;
            node.next = null;
            return headNode;
        }
    }

    private static Node reverse(Node node) {
        Node current = node;
        Node pre = null;
        Node head = null;
        while (current != null) {
            Node next = current.next;
            if (next == null) {
                head = current;
            }
            current.next = pre;
            pre = current;
            current = next;

        }
        return head;
    }

}
