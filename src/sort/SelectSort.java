package sort;

import java.util.Arrays;

/**
 * 选择排序：为不稳定排序，如{5,8,5,2,9}这个数组两个 5 最后的位置就是互换过的
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        selectSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    public static void selectSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }

    }
}
