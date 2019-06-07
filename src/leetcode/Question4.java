package leetcode;

/**
 * leetcode 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class Question4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 这里保证 m 比 n 小，是因为可以减少后面数组越界或是 -1 的问题
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;

            int[] tempArr = nums1;
            nums1 = nums2;
            nums2 = tempArr;
        }
        int iMin = 0;
        int iMax = m;
        int half = (m + n + 1) / 2;

        // 二分法，查找一个数 i 把两个数组分别分割成两部分，nums1 用 i 分割，nums2 用 j = half - i 分割
        // 以保证 nums1[0..i - 1] + nums2[0..j -1 ] 的长度和 nums1[i..m] + nums2[j..n] 的长度差不超过 1
        // 之后先忽略边界条件查找 nums1[i -1] <= nums2[j] && nums2[j - 1] <= nums1[i] 成立的 i
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = half - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0.0;
    }
}
