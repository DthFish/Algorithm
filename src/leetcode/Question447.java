package leetcode;

import java.util.HashMap;

/**
 * leetcode 447. 回旋镖的数量
 */
public class Question447 {

    public static int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length <= 1) {
            return 0;
        }
        int result = 0;
        HashMap<Double, Integer> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {

            for (int j = 0; j < points.length; j++) {
                if(i == j){
                    continue;
                }
                double dis = Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2);
                if (map.containsKey(dis)) {
                    Integer count = map.get(dis);
                    result += count * 2;
                    map.put(dis, count + 1);
                } else {
                    map.put(dis, 1);

                }
            }
            map.clear();
        }

        return result;
    }
}
