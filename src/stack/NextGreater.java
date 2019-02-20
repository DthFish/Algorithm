package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * LeetCode 496
 * 下一个更大元素：用较大的数组配合 stack 和 map 构造一个"数与下一个更大元素"的映射（特别注意 while 循环的处理）
 * 多多思考这里构造过程的巧妙啊啊啊，还有 while 循环的地方
 * 方法2 用了桶排序的思想？
 */
public class NextGreater {

    public static void main(String[] args) {
        int[] nums1 = {2, 4}, nums2 = {1, 2, 3, 4};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
        int[] nums3 = {4, 1, 2}, nums4 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums3, nums4)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            if (stack.empty()) {
                stack.push(nums2[i]);
                continue;
            }
            // 注意可能多个数同时对应一个相同的大数
            while (!stack.empty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            // 大数自己也要对应更大的数
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            Integer integer = map.get(nums1[i]);
            result[i] = integer == null ? -1 : integer;
        }

        return result;

    }

    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return new int[0];
        int length1 = nums1.length;
        int length2 = nums2.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length2; i++) {
            max = Math.max(max, nums2[i]);
        }

        int[] result = new int[length1];
        int[] temp = new int[max + 1];
        // 构造一个 [0,max] 全为 -1 的数组（桶），
        for (int i = 0; i < max + 1; i++) {
            temp[i] = -1;
        }
        for (int i = 0; i < length2; i++) {
            for (int j = i + 1; j < length2; j++) {
                if (nums2[j] > nums2[i]) {
                    // 把下一个更大元素放桶里，角标就是元素，值就是下一个更大元素
                    temp[nums2[i]] = nums2[j];
                    break;
                }
            }
        }

        for (int i = 0; i < length1; i++)
            // nums1 里面的值就是 temp 的角标，里面的值就是我们要求的，因为找不到的都是 -1
            result[i] = temp[nums1[i]];

        return result;
    }
}
