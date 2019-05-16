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
        return "val:" + val + "\r\nnext:" + next;*/
        return String.valueOf(value);

    }

    public static void main(String[] args) {
        //3,1,4,7,5,8,9,6
        final DoubleNode three = new DoubleNode(3);
        final DoubleNode one = new DoubleNode(1);
        final DoubleNode two = new DoubleNode(2);
        final DoubleNode four = new DoubleNode(4);
        final DoubleNode seven = new DoubleNode(7);
        final DoubleNode five = new DoubleNode(5);
        final DoubleNode eight = new DoubleNode(8);
        final DoubleNode nine = new DoubleNode(9);
        final DoubleNode six = new DoubleNode(6);
        three.next = one;
        one.pre = three;
        one.next = two;
        two.pre = one;
        two.next = four;
        four.pre = two;
        four.next = seven;
        seven.pre = four;
        seven.next = five;
        five.pre = seven;
        five.next = eight;
        eight.pre = five;
        eight.next = nine;
        nine.pre = eight;
        nine.next = six;
        six.pre = nine;

        DoubleNode head = three;
        DoubleNode tail = six;
        //--------------上面准备的数据
        quickSort(head, tail);
        printList(head);

    }

    private static void printList(DoubleNode head) {
        while (head != null) {
            if (head.next == null) {
                System.out.println(head.value);
            } else {
                System.out.print(head.value);
            }
            head = head.next;
        }
    }

    private static void quickSort(DoubleNode head, DoubleNode tail) {
        //特别注意：链表操作 pre next 会超过原来的 head 或者 tail
        if (head == tail || head == null || tail == null || head.pre == tail || tail.next == head) {
            return;
        }

        DoubleNode point = quickSortPoint(head, tail);
        quickSort(head, point.pre);
        quickSort(point.next, tail);

    }

    private static DoubleNode quickSortPoint(DoubleNode head, DoubleNode tail) {

        DoubleNode point = head;
        DoubleNode index = head;
        while (index != null && index != tail) {
            if (index.value < tail.value) {
                if (index != point) {
                    int temp = point.value;
                    point.value = index.value;
                    index.value = temp;
                }
                point = point.next;
            }
            index = index.next;
        }
        if (point != tail) {
            int temp = point.value;
            point.value = tail.value;
            tail.value = temp;
        }
        return point;
    }
}


