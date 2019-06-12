package leetcode;

/**
 * leetcode 892. 三维形体的表面积
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * <p>
 * 请你返回最终形体的表面积
 */
public class Question892 {

    public int surfaceArea(int[][] grid) {

        int size = grid.length;

        // 一个位置上要是值 v 大于1，那么一定有上下两个面 +2，
        // 左侧的面取左侧相邻的值 vl Math.max(v - vl,0)
        // 右侧的面取左侧相邻的值 vr Math.max(v - vr,0)
        // 同理上侧和下侧
        int result = 0;
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                if (grid[i][j] > 0) {
                    result += 2;

                    if (i - 1 >= 0) {
                        result += Math.max(grid[i][j] - grid[i - 1][j], 0);
                    } else {
                        result += grid[i][j];
                    }
                    if (i + 1 < size) {
                        result += Math.max(grid[i][j] - grid[i + 1][j], 0);
                    } else {
                        result += grid[i][j];
                    }
                    if (j - 1 >= 0) {
                        result += Math.max(grid[i][j] - grid[i][j - 1], 0);
                    } else {
                        result += grid[i][j];
                    }
                    if (j + 1 < size) {
                        result += Math.max(grid[i][j] - grid[i][j + 1], 0);
                    } else {
                        result += grid[i][j];
                    }
                }

            }
        }
        return result;
    }
}
