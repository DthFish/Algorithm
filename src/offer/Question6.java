package offer;

import list.Node;

/**
 * 剑指 offer 6：从尾到头打印链表
 */
public class Question6 {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node pre = head;
        for (int i = 1; i < 10; i++) {
            pre.next = new Node(i);
            pre = pre.next;
        }
        reversePrintList(head);


    }

    private static void reversePrintList(Node head){
        if(head == null){
            return;
        }
        reversePrintList(head.next);
        System.out.println(head.value);
    }
}
