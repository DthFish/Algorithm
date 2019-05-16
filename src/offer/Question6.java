package offer;

import list.ListNode;

/**
 * 剑指 offer 6：从尾到头打印链表
 */
public class Question6 {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        for (int i = 1; i < 10; i++) {
            pre.next = new ListNode(i);
            pre = pre.next;
        }
        reversePrintList(head);


    }

    private static void reversePrintList(ListNode head){
        if(head == null){
            return;
        }
        reversePrintList(head.next);
        System.out.println(head.val);
    }
}
