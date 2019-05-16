package list;

/**
 * LeetCode 19
 * 删除链表的倒数第N个节点：用双指针保证只需遍历一遍就找到需要删除的节点的前一个节点，然后利用哨兵可以简化边际条件的判断
 * 边际条件啊啊啊啊啊啊，头疼
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node.next = node1;
        node1.next = node2;

        ListNode.printAll(removeNthFromEnd(node, 1));

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;

        ListNode rangeStart = tempHead;
        ListNode rangeEnd = tempHead;
        //查找需要删除的节点的前一个节点
        for (int i = 0; i < n; i++) {
            rangeEnd = rangeEnd.next;
        }
        while (rangeEnd.next != null) {
            rangeStart = rangeStart.next;
            rangeEnd = rangeEnd.next;
        }
        rangeStart.next = rangeStart.next.next;
        return tempHead.next;
    }
}
