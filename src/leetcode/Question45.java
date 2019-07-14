package leetcode;

/**
 * 45. 跳跃游戏 II
 */
public class Question45 {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums[0];
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            right = Math.max(i + nums[i], right);
            if (right >= nums.length - 1) {
                return step + 1;
            }
            if (i == left) {
                step++;
                left = right;

            }
        }
        return step;

    }
}
