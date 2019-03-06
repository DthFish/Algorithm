package sort;

import java.util.Arrays;

/**
 * 堆排序：1. 先进行堆化；2. 然后堆顶移到最后算是排序完成，进一步对剩下的数据堆化
 * 注意：堆化过程中每次和节点交换的是左右子节点较大的那个
 * 时间复杂度：O(nlogn)
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {-1, 4, 5, 6, 3, 2, 1};
        heapSort(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // n 表示数据的个数，数组 a 中的数据从下标 1 到 到 n 的位置
    public static void heapSort(int[] arr, int n) {
        if (n <= 1) return;
        buildHeap(arr, n);
        int k = n;
        while (k > 1) {
            swap(arr, 1, k);
            k--;
            heap(arr, k, 1);
        }
    }

    private static void buildHeap(int[] arr, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heap(arr, n, i);
        }
    }

    private static void heap(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && arr[i] < arr[i * 2]) maxPos = i * 2;

            if (i * 2 + 1 <= n && arr[maxPos] < arr[i * 2 + 1]) maxPos = i * 2 + 1;

            if (maxPos == i) break;

            swap(arr, i, maxPos);
            i = maxPos;

        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
