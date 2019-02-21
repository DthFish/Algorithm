package list;

/**
 * LeetCode 21
 * 合并两个有序链表：用哨兵（事先 new 的 head）简化逻辑
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        node.next = node1;
        node1.next = node2;

        Node node10 = new Node(1);
        Node node11 = new Node(2);
        Node node12 = new Node(3);
        node10.next = node11;
        node11.next = node12;

        Node.printAll(marge(node, node10));

    }

    public static Node marge(Node first, Node second) {

        Node head = new Node(0);
        Node current = head;

        while (first != null && second != null) {
            if (first.value < second.value) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        if (first == null) {
            current.next = second;
        } else {
            current.next = first;
        }

        return head.next;
    }
}
