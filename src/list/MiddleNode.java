package list;

/**
 * LeetCode 876
 * 链表的中间结点：快慢指针
 */
public class MiddleNode {

    public static void main(String[] args) {

        Node node = new Node(1);
//        Node node1 = new Node(2);
//        Node node2 = new Node(3);
//        node.next = node1;
//        node1.next = node2;

        Node.printAll(middleNode(node));

    }

    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

}
