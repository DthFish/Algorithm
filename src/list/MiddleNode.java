package list;

/**
 * LeetCode 876
 * 链表的中间结点：快慢指针
 */
public class MiddleNode {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(3);
//        node.next = node1;
//        node1.next = node2;

        ListNode.printAll(middleNode(node));

    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

}
