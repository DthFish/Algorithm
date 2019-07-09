package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 841. 钥匙和房间
 */
public class Question841 {

    public static void main(String[] args) {
        int[][] origin = {{1, 3}, {3, 0, 1}, {2}, {0}};
        List<List<Integer>> input = new ArrayList<>();
        for (int i = 0; i < origin.length; i++) {
            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j < origin[i].length; j++) {
                temp.add(origin[i][j]);
            }
            input.add(temp);
        }

        System.out.println(canVisitAllRooms(input));
    }

    // 广度优先搜索
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            Integer room = queue.poll();
            List<Integer> keys = rooms.get(room);
            visited[room] = true;
            for (Integer key : keys) {
                if (!visited[key]) {
                    queue.offer(key);
                }
            }
        }

        for (boolean b : visited) {

            if (!b) {
                return false;
            }
        }
        return true;

    }
}
