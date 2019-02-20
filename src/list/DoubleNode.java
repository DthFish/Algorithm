package list;

@SuppressWarnings("WeakerAccess")
public class DoubleNode {
    public DoubleNode(int value) {
        this.value = value;
    }

    public int value;
    public DoubleNode pre;
    public DoubleNode next;

    @Override
    public String toString() {

        /*String next = "null";
        if (this.next != null) {
            next = this.next.toString();
        }
        return "value:" + value + "\r\nnext:" + next;*/
        return String.valueOf(value);

    }
}
