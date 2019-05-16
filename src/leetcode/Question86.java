package leetcode;


import list.ListNode;

/**
 * LeetCode 86. 分隔链表
 * 思路1：见下代码实现，思路2：用两个头节点分别记录大于等于 x 和小于 x 的节点，拼接
 */
public class Question86 {

    public static void main(String[] args) {
        //1->4->3->2->5->2
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(2);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(2);
        node5.next = node6;
        ListNode.printAll(partition(node1,3));

    }

    /**
     * 顺序查找大于等于 x 的第一个数 n，然后向后遍历，如果比 x 小则插入到 n 前面
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode current = tempHead;

        //查找大于等于 x 的第一个节点的前一个节点
        ListNode pre = null;
        while (current.next != null) {
            if (current.next.val >= x) {
                pre = current;
                break;
            }
            current = current.next;
        }

        while (current.next != null) {
            if (current.next.val < x) {
                // 插入到 pre 之后
                ListNode temp = current.next;
                current.next = temp.next;

                temp.next = pre.next;
                pre.next = temp;
                pre = pre.next;
            } else {
                current = current.next;
            }
        }

        return tempHead.next;
    }
}
