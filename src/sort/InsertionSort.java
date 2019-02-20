package sort;

import java.util.Arrays;

/**
 * 插入排序，记得插入的操作在位移操作之后（腾出插入的位置）
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertionSort(int[] arr, int n) {
        if (n < 1) return;
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;

        }
    }
}
