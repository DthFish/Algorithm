package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 78. 子集
 */
public class Question78 {

    public static void main(String[] args) {
        int[] nums  = {1,2,3};
        System.out.println(subsets(nums));
        System.out.println(subsets2(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            final int size = result.size();
            for (int i = 0; i < size; i++) {
                final ArrayList<Integer> sub = new ArrayList<>(result.get(i));
                sub.add(num);
                result.add(sub);
            }
        }
        return result;
    }
    // 利用二进制 0 表示没有那个元素 1 表示有，来添加元素
    public static List<List<Integer>> subsets2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<>();

            for (int j = 0; j < nums.length; j++) {
                if((i >> j & 1) == 1){
                    sub.add(nums[j]);
                }
            }
            result.add(sub);

        }
        return result;
    }
}
