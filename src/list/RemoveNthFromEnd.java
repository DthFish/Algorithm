package list;

/**
 * LeetCode 19
 * 删除链表的倒数第N个节点：用双指针保证只需遍历一遍就找到需要删除的节点的前一个节点，然后利用哨兵可以简化边际条件的判断
 * 边际条件啊啊啊啊啊啊，头疼
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        node.next = node1;
        node1.next = node2;

        Node.printAll(removeNthFromEnd(node, 1));

    }

    public static Node removeNthFromEnd(Node head, int n) {
        if (head == null) {
            return null;
        }
        Node tempHead = new Node(0);
        tempHead.next = head;

        Node rangeStart = tempHead;
        Node rangeEnd = tempHead;
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
