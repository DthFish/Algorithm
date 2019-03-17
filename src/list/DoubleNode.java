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

    public static void main(String[] args) {
        //3,1,4,7,5,8,9,6
        final DoubleNode three = new DoubleNode(3);
        final DoubleNode one = new DoubleNode(1);
        final DoubleNode four = new DoubleNode(4);
        final DoubleNode seven = new DoubleNode(7);
        final DoubleNode five = new DoubleNode(5);
        final DoubleNode eight = new DoubleNode(8);
        final DoubleNode nine = new DoubleNode(9);
        final DoubleNode six = new DoubleNode(6);
        three.next = one;
        one.pre = three;
        one.next = four;
        four.pre = one;
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
//        while (head != null) {
//            System.out.println(head.value);
//            head = head.next;
//        }
        DoubleNode tail = six;
//        while (tail != null) {
//            System.out.println(tail.value);
//            tail = tail.pre;
//        }
        //--------------上面准备的数据
        quickSort(head, tail);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }

    }

    private static void quickSort(DoubleNode head, DoubleNode tail) {
        if (head == tail || head == null || tail == null) {
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
                if (point != index) {
                    DoubleNode temp = new DoubleNode(-1);

                    temp.next = point.next;
                    point.next = temp;
                    temp.pre = point;
                    if (temp.next != null) {
                        temp.next.pre = temp;
                    }

                    DoubleNode pre = point.pre;
                    DoubleNode next = point.next;

                    DoubleNode indexPre = index.pre;
                    DoubleNode indexNext = index.next;

                    if (pre != null)
                        pre.next = index;
                    index.pre = pre;
                    index.next = next;
                    next.pre = index;

                    if (indexPre != null)
                        indexPre.next = point;
                    point.pre = indexPre;
                    point.next = indexNext;
                    indexNext.pre = point;

                    index.next = index.next.next;
                    if (index.next != null) {
                        index.next.pre = index;
                    }


                    temp = point;
                    point = index;
                    index = temp;
                }

                point = point.next;

            }

            index = index.next;
        }
        if (point != tail) {
            DoubleNode temp = new DoubleNode(-1);

            temp.next = point.next;
            point.next = temp;
            temp.pre = point;
            if (temp.next != null) {
                temp.next.pre = temp;
            }


            DoubleNode pre = point.pre;
            DoubleNode next = point.next;

            DoubleNode tailPre = tail.pre;
            DoubleNode tailNext = tail.next;

            if (pre != null)
                pre.next = tail;
            tail.pre = pre;
            tail.next = next;
            next.pre = tail;
            if (tailPre != null)
                tailPre.next = point;
            point.pre = tailPre;
            point.next = tailNext;
            if (tailNext != null)
                tailNext.pre = point;

            tail.next = tail.next.next;
            if (tail.next != null) {
                tail.next.pre = tail;
            }

            temp = point;
            point = tail;
            tail = temp;
        }
        System.out.println(point.value);
        return point;
    }

}
