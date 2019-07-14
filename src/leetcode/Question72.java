package leetcode;

/**
 * 72. 编辑距离
 */
public class Question72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // 一个为空，则编辑距离为另一个的长度
        if (n * m == 0) {
            return n + m;
        }
        // status 的横坐标表示的一个字符的长度，纵坐标表示另一个字符串的长度
        // status 的值表示两个长度字符串的编辑距离
        int[][] status = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            status[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            status[0][j] = j;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                int left = status[i - 1][j] + 1;
                int top = status[i][j - 1] + 1;
                int leftTop = status[i - 1][j - 1];
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    // 如果不相等则 leftTop 需要加1
                    leftTop += 1;
                }

                status[i][j] = Math.min(left, Math.min(top, leftTop));
            }

        }
        return status[n][m];

    }
}
