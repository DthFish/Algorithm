package leetcode;

import java.util.Arrays;

/**
 * 324. 摆动排序 II
 */
public class Question324 {

    public void wiggleSort(int[] nums) {

        Arrays.sort(nums);

        int smallLen = (nums.length & 1) > 0 ? nums.length / 2 + 1 : nums.length / 2;
        int[] small = new int[smallLen];
        int[] big = new int[nums.length / 2];

        System.arraycopy(nums, 0, small, 0, smallLen);
        System.arraycopy(nums, smallLen, big, 0, big.length);
        int i = 0;
        for (; i < big.length; i++) {
            nums[2 * i] = small[small.length - 1 - i];
            nums[2 * i + 1] = big[big.length - 1 - i];
        }
        if ((nums.length & 1) > 0 ) nums[2 * i] = small[small.length - 1 - i];

    }
}
