package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 403:青蛙过河
 * 不知道为啥 LeetCode 上执行的结果和这里不一样
 */
public class Question403 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 5, 6, 8, 12, 17};
        int[] arr2 = {0, 1, 3, 6, 7};
        int[] arr3 = {0, 2147483647};
        int[] arr4 = {0, 1, 3, 4, 5, 7, 9, 10, 12};
        int[] arr5 = {0, 1};
        System.out.println(canCross(arr));
        System.out.println(canCross(arr2));
        System.out.println(canCross(arr3));
        System.out.println(canCross(arr4));
        System.out.println(canCross(arr5));

    }

    public static boolean canCross(int[] stones) {
        Map<Long, Boolean> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put((long) stones[i], true);
        }

        return canCrossStep(map, 0, stones[stones.length - 1], 1);
    }

    private static boolean canCrossStep(Map<Long, Boolean> map, long from, long to, long step) {
        if (from > to || step <= 0) return false;

        if (from == to) return true;

        boolean flag = false;
        if (step - 1 > 0) {
            Boolean aBoolean = map.get(from + step - 1);
            aBoolean = aBoolean == null ? false : aBoolean;
            flag = aBoolean && canCrossStep(map, from + step - 1, to, step - 1);
        }

        Boolean aBoolean = map.get(from + step + 1);
        aBoolean = aBoolean == null ? false : aBoolean;
        Boolean aBoolean1 = map.get(from + step);
        aBoolean1 = aBoolean1 == null ? false : aBoolean1;
        return flag || (aBoolean && canCrossStep(map, from + step + 1, to, step + 1)) ||
                (aBoolean1 && canCrossStep(map, from + step, to, step));

    }
}
