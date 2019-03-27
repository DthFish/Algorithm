package dynamic;

/**
 * 求两个字符传的莱文斯坦距离：动态规划
 */
public class LevenshteinDistance {
    public static void main(String[] args) {
        char[] str1 = "mitcmu".toCharArray();
        char[] str2 = "mtacnu".toCharArray();
        System.out.println(disance(str1, str1.length, str2, str2.length));
    }

    public static int disance(char[] str1, int n, char[] str2, int m) {
        int[][] states = new int[n][m];
        for (int i = 0; i < m; i++) {
            if (str1[0] == str2[i]) {
                states[0][i] = i;
            } else if (i == 0) {
                states[0][i] = 1;
            } else {
                states[0][i] = states[0][i - 1] + 1;

            }
        }

        for (int i = 0; i < n; i++) {
            if (str2[0] == str1[i]) {
                states[i][0] = i;
            } else if (i == 0) {
                states[i][0] = 1;
            } else {
                states[i][0] = states[i - 1][0] + 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (str1[i] == str2[j]) {
                    states[i][j] = min(states[i - 1][j] + 1, states[i][j - 1] + 1, states[i - 1][j - 1]);
                } else {
                    states[i][j] = min(states[i - 1][j] + 1, states[i][j - 1] + 1, states[i - 1][j - 1] + 1);
                }
            }
        }

        return states[n - 1][m - 1];
    }


    private static int min(int x, int y, int z) {
        int min = Integer.MAX_VALUE;
        if (x < min) min = x;
        if (y < min) min = y;
        if (z < min) min = z;
        return min;
    }
}
