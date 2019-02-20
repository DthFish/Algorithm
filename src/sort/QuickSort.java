package sort;

import java.util.Arrays;

/**
 * 快速排序：分区思想，取最后一个元素当控制点，把元素按大小分隔到控制点的两边，再分别处理两边。
 * 该思想可用于查找一组数中第 K 大的数，把大的分左边，小的分右边；求得控制点 p 后比较 K 和 p 大小，如果相等，该角标的里面的值就是要找的数；
 * 否则若 K > p 则再右边找，若 K < p 则在左边找；时间复杂度可以控制在 O(n)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        quickSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int n) {
        quickSortPart(arr, 0, n - 1);

    }

    private static void quickSortPart(int[] arr, int start, int end) {
        if (start >= end) return;

        int point = partition(arr, start, end);
        quickSortPart(arr, start, point - 1);
        quickSortPart(arr, point + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int value = arr[end];
        int i = start;
        int temp;
        for (int j = start; j < end; j++) {
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

}
