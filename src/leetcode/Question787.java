package leetcode;

public class Question787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int limit = 99999999;
        int[][] status = new int[n][K + 1];
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = limit;
            }
        }
        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        for (int i = 0; i < n; i++) {
            status[i][0] = graph[src][i];
        }
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (status[j][i] == 0) status[j][i] = status[k][i - 1] + graph[k][j];
                    else status[j][i] = Math.min(status[j][i], status[k][i - 1] + graph[k][j]);
                }
            }

        }

        int min = limit;
        for (int i = 0; i <= K; i++) {
            min = Math.min(status[dst][i], min);
        }
        return min == limit ? -1 : min;
    }
}
