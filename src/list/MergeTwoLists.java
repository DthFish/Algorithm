package list;

/**
 * LeetCode 21
 * 合并两个有序链表：用哨兵（事先 new 的 head）简化逻辑
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node.next = node1;
        node1.next = node2;

        ListNode node10 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        node10.next = node11;
        node11.next = node12;

        ListNode.printAll(marge(node, node10));

    }

    public static ListNode marge(ListNode first, ListNode second) {

        ListNode head = new ListNode(0);
        ListNode current = head;

        while (first != null && second != null) {
            if (first.val < second.val) {
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
