package list;

@SuppressWarnings("WeakerAccess")
public class Node {
    public Node(int value) {
        this.value = value;
    }

    public int value;
    public Node next;

    @Override
    public String toString() {
        /*String next = "null";
        if (this.next != null) {
            next = this.next.toString();
        }
        return "value:" + value + "\r\nnext:" + next;*/
        return String.valueOf(value);
    }

    public static void printAll(Node node) {
        if (node == null) {
            System.out.println("[null]");
            return;
        }
        System.out.print("[");
        while (node != null) {
            System.out.print(node.value);
            node = node.next;
            if (node != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");

    }
}
