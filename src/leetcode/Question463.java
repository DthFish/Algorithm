package leetcode;

/**
 * 463. 岛屿的周长
 */
public class Question463 {

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(islandPerimeter(arr));
    }

    public static int islandPerimeter(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count += grid[i][j] * 4;
                    if (i - 1 >= 0) {
                        count -= grid[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        count -= grid[i][j - 1];
                    }
                    if (i + 1 < grid.length) {
                        count -= grid[i + 1][j];
                    }
                    if (j + 1 < grid[i].length) {
                        count -= grid[i][j + 1];
                    }
                }
            }
        }

        return count;

    }
}
