package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 539. 最小时间差
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
 */
public class Question539 {

    public int findMinDifference(List<String> timePoints) {

        int[] minutes = new int[timePoints.size()];

        for (int i = 0; i < timePoints.size(); i++) {
            String s = timePoints.get(i);
            String[] split = s.split(":");
            minutes[i] = ((split[0].charAt(0) - '0') * 10 + (split[0].charAt(1) - '0')) * 60
                    + ((split[1].charAt(0) - '0') * 10 + (split[1].charAt(1) - '0'));
        }

        Arrays.sort(minutes);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.length; i++) {
            min = Math.min(min, minutes[i] - minutes[i - 1]);
        }
        min = Math.min(min, minutes[0] + 24 * 60 - minutes[minutes.length - 1]);

        return min;
    }
}
