package list;

@SuppressWarnings("WeakerAccess")
public class ListNode {
    public ListNode(int val) {
        this.val = val;
    }

    public int val;
    public ListNode next;

    @Override
    public String toString() {
        /*String next = "null";
        if (this.next != null) {
            next = this.next.toString();
        }
        return "val:" + val + "\r\nnext:" + next;*/
        return String.valueOf(val);
    }

    public static void printAll(ListNode node) {
        if (node == null) {
            System.out.println("[null]");
            return;
        }
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");

    }
}
