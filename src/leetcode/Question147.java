package leetcode;

import list.Node;

/**
 * leetcode 147. 对链表进行插入排序
 */
public class Question147 {

    public static void main(String[] args) {
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(1);
        node2.next = node3;
        Node node4 = new Node(3);
        node3.next = node4;
        Node.printAll(insertionSortList(node1));

    }

    public static Node insertionSortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node tempHead = new Node(-1);
        tempHead.next = head;
        Node current = head;
        while (current.next != null) {
            if (current.value > current.next.value) {
                Node temp = current.next;
                current.next = temp.next;
                Node pre = tempHead;
                while (pre.next.value < temp.value){
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
