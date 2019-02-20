package sort;

import java.util.Arrays;

/**
 * 并归排序：拆分，排序，合并
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        mergeSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int n) {
        mergeSortPart(arr, 0, n - 1);
    }

    public static void mergeSortPart(int[] arr, int start, int end) {
        if (start >= end) return;
        int middle = (start + end) / 2;
        mergeSortPart(arr, start, middle);
        mergeSortPart(arr, middle + 1, end);
        merge(arr, start, middle, end);
    }

    public static void merge(int[] arr, int start, int middle, int end) {
        int[] tempArr = new int[end - start + 1];
        int first = start;
        int second = middle + 1;
        int temp = 0;
        while (first <= middle && second <= end) {
            if (arr[first] <= arr[second]) {
                tempArr[temp++] = arr[first++];
            } else {
                tempArr[temp++] = arr[second++];
            }
        }

        int s = first;
        int e = middle;
        if (second <= end) {
            s = second;
            e = end;
        }
        while (s <= e) {
            tempArr[temp++] = arr[s++];
        }
        //注意：用下面这种写法的时候，不要用 temp++,first++ 这种形式因为 first 在循环判断里面有用到
        /*
        for (int i = 0; i <= middle - first; i++) {
            tempArr[temp + i] = arr[first + i];
        }
        for (int i = 0; i <= end - second; i++) {
            tempArr[temp + i] = arr[second + i];
        }
        */

        for (int i = 0; i <= end - start; i++) {
            arr[start + i] = tempArr[i];
        }
    }
}
