package leetcode;

import java.util.Stack;

import list.ListNode;

/**
 * leetcode 234. 回文链表
 * 请判断一个链表是否为回文链表。
 */
public class Question234 {

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
                stack.push(slow.val);
            } else {
                fast = null;
            }
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.peek() != slow.val) {
                return false;
            }

            stack.pop();
            slow = slow.next;
        }

        return true;

    }
}
