package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 90:给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 */
public class Question90 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 2};


        System.out.println(subsetsWithDup(nums));

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> level = new ArrayList<>();
        result.add(level);
        dfs(result, level, 0, nums);

        return result;
    }

    /**
     * 回溯算法
     */
    private static void dfs(List<List<Integer>> result, List<Integer> level, int depth, int[] nums) {
        for (int i = depth; i < nums.length; i++) {

            if (i > depth && nums[i - 1] == nums[i]) {
                continue;
            }
            level.add(nums[i]);
            result.add(new ArrayList<>(level));
            dfs(result, level, i + 1, nums);
            level.remove(level.size() - 1);

        }
    }

}
