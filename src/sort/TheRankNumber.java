package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 用时间复杂度为 n 的方法，找的第 n 大的数
 * 快排分区思想：查找一组数中第 K 大的数，把大的分左边，小的分右边；求得控制点角标 p 后比较 K 和 p 大小，如果相等，该角标的里面的值就是要找的数；
 * 否则若 K > p 则再右边找，若 K < p 则在左边找；时间复杂度可以控制在 O(n)
 */
public class TheRankNumber {

    public static void main(String[] args) {
        int size = 101;
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        System.out.println(Arrays.toString(arr));

        System.out.println(theRankNumber(arr, size, 1));
        System.out.println(Arrays.toString(arr));


    }

    public static int theRankNumber(int[] arr, int n, int rank) {

        return theRankNumberPart(arr, 0, n - 1, rank);
    }

    private static int theRankNumberPart(int[] arr, int start, int end, int rank) {
        int index = partition(arr, start, end);

        if (index == rank - 1) {
            return arr[index];
        } else if (index > rank - 1) {
            return theRankNumberPart(arr, start, index - 1, rank);
        } else {
            return theRankNumberPart(arr, index + 1, end, rank);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int value = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] > value) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        arr[end] = arr[i];
        arr[i] = value;

        return i;
    }
}
