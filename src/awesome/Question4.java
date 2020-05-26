package awesome;

import java.util.Arrays;

/**
 * 无序的整数数组，如果角标 i 对应的值为 ai，求找出任意一对 i<j 且 ai<aj;
 * 思路：对于角标 j 如果满足上述条件，那么一定有 aj > min(a0,a1...aj-1)，
 * 所以我们只要保留之前遍历过的最小的数和当前的 aj 对比就好了。
 */
public class Question4 {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 3, 1, 2, 0};
        System.out.println(Arrays.toString(find(arr)));
    }

    public static int[] find(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int[] result = new int[2];
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[minIndex] < arr[i]) {
                //找到了输出结果
                result[0] = arr[minIndex];
                result[1] = arr[i];
                return result;
            } else {
                minIndex = i;
            }
        }

        return null;
    }
}
