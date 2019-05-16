package list;

/**
 * LeetCode 141
 * 判断链表是否有环：用快慢指针，当快慢指针重合是表示有环
 */
public class CycleList {

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(hasCycle(node));

    }

    public static boolean hasCycle(ListNode node) {

        if (node == null || node.next == null) {
            return false;
        }
        ListNode slow = node;
        ListNode fast = node;
        do {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        } while (fast != null && fast.next != null);
        return false;
    }
}
