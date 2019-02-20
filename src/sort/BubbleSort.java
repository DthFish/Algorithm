package sort;

import java.util.Arrays;

/**
 * 冒泡排序改进版，可以对于原本逆序度不高的有所提升
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {3, 5, 4, 1, 2, 6};
        bubbleSort(arr2, arr2.length);
        System.out.println(Arrays.toString(arr2));


    }

    public static void bubbleSort(int[] arr, int n) {
        if (n < 1) return;
        for (int i = 0; i < n; i++) {
            // 对于效率的改进，如果有一次遍历都没有交换数据的话，那么意味着已经完成后面可以不再进行了
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }

    }
}
