package leetcode;

/**
 * 526. 优美的排列
 */
public class Question526 {

    private int count;

    public int countArrangement(int N) {

        if (N == 0 || N == 1) {
            return N;
        }
        count = 0;
        boolean[] visited = new boolean[N + 1];
        dfs(1, N, visited);
        return count;

    }

    private void dfs(int i, int N, boolean[] visited) {
        if (i == N + 1) {
            count++;
            return;
        }

        for (int j = 1; j <= N; j++) {
            if (visited[j]) {
                continue;
            }
            if (i % j == 0 || j % i == 0) {
                visited[j] = true;
                dfs(i + 1, N, visited);
                visited[j] = false;
            }

        }
    }
}
