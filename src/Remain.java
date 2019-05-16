/**
 * 未实现的算法，待实现:
 *
 * LeetCode 224 基本计算器 困难 栈相关 {@link stack.Calculator}
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class Remain {

    public static void main(String[] args) {

        /*int[] arr1 = {1, 4, 5};
        int[] arr2 = {2, 8, 9};
        int[] com = com(arr1, arr2);
        System.out.println(Arrays.toString(com));*/

       /* ListNode head = new ListNode(0, null);
        ListNode pre = head;
        for (int i = 1; i < 10; i++) {
            ListNode node = new ListNode(i, null);
            pre.next = node;
            pre = node;
        }
        printNode(head);
        printNode(reverse(head));*/
        /*ListNode first6 = new ListNode(6, null);
        ListNode first5 = new ListNode(5, first6);
        ListNode first4 = new ListNode(4, first5);
        ListNode first1 = new ListNode(1, first4);
        System.out.println(findMid(first1).val);

        ListNode second9 = new ListNode(9, null);
        ListNode second8 = new ListNode(8, second9);
        ListNode second2 = new ListNode(2, second8);

        printNode(com(first1, second2));*/

        /*
        int[] arr = {1, 2, 3, 10, 2147483647, 9};
        int[] arr = {0, 2, 2, 1, 1};

        System.out.println(firstMissingPositive(arr));*/

//        System.out.println(funNum(4));

//        System.out.println(plus(3));

//        System.out.println(climbStairs(44));


        int[] arr = {4, 5, 6, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
//        insertSort(arr);
//        selectSort(arr);
//        bubbleSort(arr);
//        quickSort(arr);
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));


        String total = "dfsadbcbcabcabcsdfbacbcbc";
        String patten = "abcabc";
        System.out.println(bm(total.toCharArray(), total.length(), patten.toCharArray(), patten.length()));


    }

    public static int knapsack(int[] weights, int n, int w) {
        boolean[][] status = new boolean[n][w + 1];
        status[0][0] = true;
        status[0][weights[0]] = true;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < w; j++) {

                if (status[i - 1][j]) {
                    status[i][j] = true;
                }
            }

            for (int j = 0; j < w - weights[i]; j++) {
                if (status[i - 1][j]) {
                    status[i][j + weights[i]] = true;
                }
            }

        }

        for (int i = w; i >= 0; i--) {
            if (status[n - 1][i]) {
                return i;
            }
        }
        return -1;
    }


    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSortPart(arr, 0, arr.length - 1);

    }

    public static int bm(char[] str, int n, char[] mod, int m) {
        int size = 256;
        int[] bc = new int[size];
        for (int i = 0; i < size; i++) {
            bc[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            bc[mod[i]] = i;
        }
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];

        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            int k = 0;
            while (j >= 0 && mod[j] == mod[m - 1 - k]) {
                --j;
                ++k;
                suffix[k] = j + 1;
            }

            if (j == -1) prefix[k] = true;
        }


        int i = 0;
        while (i <= n - m) {

            int j;
            for (j = m - 1; j >= 0; j--) {
                if (mod[j] != str[i + j]) break;
            }

            if (j < 0) {
                return i;
            }

            int x = j - bc[str[i + j]];
            int y = 0;
            if (j < m - 1) {
                int k = m - 1 - j;
                if (suffix[k] != -1) {
                    y = j - suffix[k] + 1;
                } else {
                    y = m;
                    for (int r = j + 2; r < m - 1; r++) {
                        if (prefix[m - r]) {
                            y = r;
                            break;
                        }
                    }

                }
            }

            i = i + Math.max(x, y);

        }
        return -1;

    }

    private static void mergeSortPart(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = (end + start) / 2;
        mergeSortPart(arr, start, middle);
        mergeSortPart(arr, middle + 1, end);
        merge(arr, start, middle, end);
    }

    private static void merge(int[] arr, int start, int middle, int end) {
        int[] tempArr = new int[end - start + 1];
        int tempIndex = 0;
        int first = start;
        int second = middle + 1;
        while (first <= middle && second <= end) {

            if (arr[first] <= arr[second]) {
                tempArr[tempIndex++] = arr[first++];
            } else {
                tempArr[tempIndex++] = arr[second++];
            }
        }

        int s = first;
        int e = middle;
        if (second <= end) {
            s = second;
            e = end;
        }
        while (s <= e) {
            tempArr[tempIndex++] = arr[s++];
        }

        for (int i = 0; i < end - start + 1; i++) {
            arr[start + i] = tempArr[i];
        }

    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSortPart(arr, 0, arr.length - 1);

    }

    private static void quickSortPart(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int point = point(arr, start, end);
        quickSortPart(arr, start, point - 1);
        quickSortPart(arr, point + 1, end);
    }

    private static int point(int[] arr, int start, int end) {
        int value = arr[end];
        int i = start;
        int temp;
        for (int j = i; j < end; j++) {
            if (arr[j] < value) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }

        temp = arr[end];
        arr[end] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }

    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }


    }

    public static void bubbleSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }


    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    private static int plus(int n) {
        if (n == 1) {
            return 1;
        }

        return plus(n - 1) * n;

    }

    private static int funNum(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        return funNum(n - 1) + funNum(n - 2);
    }

    private static void printNode(Node head) {

        while (head != null) {
            System.out.print(head.value + ",");
            head = head.next;
        }
        System.out.println();

    }

    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

    private static Node findMid(Node node) {
        if (node == null && node.next == null) {
            return node;
        }
        Node fast = node;
        Node slow = node.next;
        while (slow != null && slow.next != null) {
            fast = fast.next;
            slow = slow.next.next;
        }

        return fast;

    }

    private static Node com(Node first, Node second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        Node tempHead = new Node(-1, null);
        Node current = tempHead;
        while (first != null && second != null) {
            if (first.value <= second.value) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        if (first != null) {
            current.next = first;
        }
        if (second != null) {
            current.next = second;
        }


        return tempHead.next;
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        Arrays.sort(nums);
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            if (nums[i] == result && (i + 1 == nums.length || nums[i + 1] != result)) {
                result++;
            } else if (nums[i] != result) {
                break;
            }
        }
        return result;

    }

    private static Node reverse(Node head) {
        Node result = null;
        Node pre = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            if (next == null) {
                result = current;
            }
            current.next = pre;
            pre = current;
            current = next;
        }
        return result;
    }

    private static int[] com(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return arr2;
        }
        if (arr2 == null || arr2.length == 0) {
            return arr1;
        }

        int length = arr1.length + arr2.length;
        int[] result = new int[length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < length; i++) {

            if (index1 < arr1.length && index2 < arr2.length) {
                if (arr1[index1] <= arr2[index2]) {
                    result[i] = arr1[index1];
                    index1++;
                } else {
                    result[i] = arr2[index2];
                    index2++;
                }
            } else {
                if (index1 == arr1.length) {
                    result[i] = arr2[index2];
                    index2++;
                } else {
                    result[i] = arr1[index1];
                    index1++;
                }
            }
        }
        return result;

    }


}
