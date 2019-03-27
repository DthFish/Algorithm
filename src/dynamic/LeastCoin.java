package dynamic;

public class LeastCoin {

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        System.out.println(leastCoin(coins, 3, 9));

    }

    public static int leastCoin(int[] coins, int num, int limit) {
        if (limit == 0) return 0;
        int[][] states = new int[limit + 1][limit + 1];

        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        for (int i = 0; i < num; i++) {
            if (coins[i] > limit) {
                continue;
            }
            states[1][coins[i]] = 1;
        }

        for (int i = 2; i <= limit; i++) {
            for (int j = 1; j <= limit; j++) {

                if (states[i - 1][j] != -1) {
                    states[i][j] = states[i - 1][j];
                } else {
                    for (int k = 0; k < num; k++) {
                        if (j - coins[k] >= 0) {
                            int count = states[i][j - coins[k]] + 1;
                            if (states[i][j] <= 0 || states[i][j] >= count) {
                                states[i][j] = count;
                            }
                        }
                    }
                }
            }
        }

        int count = -1;

        for (int i = 1; i <= limit; i++) {
            if (states[i][limit] > 0) {
                return states[i][limit];
            }
        }

        return count;
    }
}
