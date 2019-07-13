package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 822. 翻转卡片游戏
 */
public class Question822 {
    //关键是去掉正反面都相等的数，在剩余的里面找最小的
    public int flipgame(int[] fronts, int[] backs) {
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        for (int i = 0; i < fronts.length; i++) {
            if (set.contains(fronts[i])) {
                continue;
            }
            min = Math.min(min, fronts[i]);
        }
        for (int i = 0; i < backs.length; i++) {
            if (set.contains(backs[i])) {
                continue;
            }
            min = Math.min(min, backs[i]);
        }

        return min > 2000 ? 0 : min;
    }
}
