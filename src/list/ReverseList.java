package list;

/**
 * LeetCode 206
 * 反转单链表：1.循环实现;2.递归实现
 * 要经常回顾和思考呀
 */
public class ReverseList {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i = 1; i < 3; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        System.out.println(head);

        ListNode reversed = reverse(head);
        System.out.println(reversed);
    }

    private static ListNode reverse2(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            ListNode headNode = reverse2(node.next);
            node.next.next = node;
            node.next = null;
            return headNode;
        }
    }

    private static ListNode reverse(ListNode node) {
        ListNode current = node;
        ListNode pre = null;
        ListNode head = null;
        while (current != null) {
            ListNode next = current.next;
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
