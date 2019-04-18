package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * LeetCode 239:给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口最大值。
 */
public class Question239 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 5, 6, 8, 12, 17};
        int[] arr2 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] arr3 = {11, 2, 9};
        int[] arr4 = {1, 3, 1, 2, 0, 5};


        System.out.println(Arrays.toString(maxSlidingWindow(arr, 2)));
        System.out.println(Arrays.toString(maxSlidingWindow(arr2, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(arr3, 2)));
        System.out.println(Arrays.toString(maxSlidingWindow(arr4, 3)));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (queue.peekFirst() == i - k) {
                    queue.pollFirst();
                }
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return result;

    }

}
