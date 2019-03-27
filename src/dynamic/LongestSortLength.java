package dynamic;

/**
 * 最长递增子序列长度：例如：2, 9, 3, 6, 5, 1, 7;最长子序列2,3,4,7;子序列长度4
 */
public class LongestSortLength {

    public static void main(String[] args) {
        int[] nums = {2, 9, 3, 6, 5, 1, 7};
        int[] nums2 = {3, 5, 8, 9, 1, 7};
        System.out.println(maxLength(nums, nums.length));
        System.out.println(maxLength(nums2, nums2.length));
    }

    private static int maxLength(int[] nums, int length) {
        if (length < 2) {
            return length;
        }
        int[] states = new int[length];
        states[0] = 1;
        for (int i = 1; i < length; i++) {//考察第 i 个数字，需要考察 i 之前的子序列即 j < i
            int max = 0;
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {

                    if (states[j] > max) {
                        max = states[j];
                    }
                }
            }
            states[i] = max + 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (states[i] > max) {
                max = states[i];
            }
        }

        return max;
    }


}
