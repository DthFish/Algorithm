package leetcode;

import list.ListNode;

/**
 * leetcode 147. 对链表进行插入排序
 */
public class Question147 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;
        ListNode node4 = new ListNode(3);
        node3.next = node4;
        ListNode.printAll(insertionSortList(node1));

    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode current = head;
        while (current.next != null) {
            if (current.val > current.next.val) {
                ListNode temp = current.next;
                current.next = temp.next;
                ListNode pre = tempHead;
                while (pre.next.val < temp.val){
                    pre = pre.next;
                }
                temp.next = pre.next;
                pre.next = temp;

            } else {
                current = current.next;
            }
        }

        return tempHead.next;
    }
}
