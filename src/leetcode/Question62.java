package leetcode;


/**
 * LeetCode 62: 不同路径
 */
public class Question62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
    }
    // 动态规划，主要是递推公式
    public static int uniquePaths(int m, int n) {
        int[][] status = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    status[i][j] = 1;
                } else {
                    status[i][j] = status[i - 1][j] + status[i][j - 1];
                }

            }
        }
        return status[m - 1][n - 1];
    }

}
