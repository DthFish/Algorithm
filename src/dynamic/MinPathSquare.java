package dynamic;

/**
 * 最小路径：动态规划，从左上到右下的最短距离,注意状态转移方程：min_dist(i, j) = w[i][j] + min(min_dist(i, j-1), min_dist(i-1, j))
 * 1 3 5 9
 * 2 1 3 4
 * 5 2 6 7
 * 6 8 4 3
 */
public class MinPathSquare {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 9},
                {2, 1, 3, 4},
                {5, 2, 6, 7},
                {6, 8, 4, 3}
        };

        System.out.println(minPath(arr, 4));
    }

    public static int minPath(int[][] arr, int length) {
        int[][] states = new int[length][length];
        states[0][0] = arr[0][0];
        for (int i = 1; i < length; i++) {
            states[0][i] = arr[0][i - 1] + arr[0][i];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (j == 0) {
                    states[i][j] = states[i - 1][j] + arr[i][j];
                } else {
                    int left = states[i][j - 1];
                    int top = states[i - 1][j];
                    states[i][j] = Math.min(left, top) + arr[i][j];
                }

            }
        }

        return states[length - 1][length - 1];
    }
}
