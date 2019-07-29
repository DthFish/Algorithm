package leetcode;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 */
public class Question628 {

    // 更快的方法是不用排序用遍历找出最小的两个数和最大的三个数做比较，意思一样就是了
    public int maximumProduct(int[] nums) {
        //如果没有负数就直接找排序后的最大的3个数

        //如果都是负数就直接找排序后的最大的3个数

        //还有2负数1正数的情况，要求是最小的两个负数相乘要比，第二和第三两个数相乘要大

        //那么是不是意味着无论啥情况无脑比较第三种情况就好了？
        Arrays.sort(nums);

        int maybe = nums[0] * nums[1] * nums[nums.length - 1];

        int maybe2 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];

        return maybe > maybe2 ? maybe : maybe2;
    }
}
