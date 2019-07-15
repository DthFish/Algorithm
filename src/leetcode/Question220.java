package leetcode;

/**
 * 220. 存在重复元素 III
 * <p>
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，
 * 并且 i 和 j 之间的差的绝对值最大为 ķ。
 */
public class Question220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int j;
            for (int step = 1; step <= k; step++) {
                j = i + step;
                if (j >= nums.length)
                    break;
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t && j - i <= k)
                    return true;
            }
        }
        return false;

    }
}
