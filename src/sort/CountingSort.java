package sort;

import java.util.Arrays;

/**
 * 计数排序：
 * 1. 计算最大值
 * 2. 用最大值 + 1 求得计数数组的大小并初始化
 * 3. 计数
 * 4. 计数数组累加,累加后的数组角标表示"原数组的元素的值",里面的值表示"原数组小于等于该'角标数字'的值的个数"
 * 5. 从后往前遍历原数组，计数数组里的数 - 1，就是排序完成的角标，一个数排完后计数数组里面的值也要减去 1（因为可能有多个相同的数在排序）
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        System.out.println(Arrays.toString(arr));
        countingSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }


    public static void countingSort(int[] arr, int n) {
        if (n <= 1) return;
        //计算最大值
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //初始化计数数组
        int[] countArr = new int[max + 1];
        for (int i = 0; i < max + 1; i++) {
            countArr[i] = 0;
        }
        //计数
        for (int i = 0; i < n; i++) {
            countArr[arr[i]]++;
        }
        //计数数组累计
        for (int i = 1; i < max + 1; i++) {
            countArr[i] = countArr[i] + countArr[i - 1];
        }

        //从后往前遍历原数组，countArr 里的数 - 1，就是排序完成的角标，一个数排完后 countArr 里面的值也要减去 1
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            result[--countArr[arr[i]]] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = result[i];
        }

    }
}
