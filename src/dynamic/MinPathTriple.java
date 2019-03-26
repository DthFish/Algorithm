package dynamic;

/**
 * 求三角形定点到底边的最短路径：动态规划
 *      5
 *     7 8
 *    2 3 4
 *   4 9 6 1
 *  2 7 9 4 5
 */
public class MinPathTriple {

    public static void main(String[] args) {
        int[][] triple = {{5}, {7, 8}, {2, 3, 4}, {4, 9, 6, 1}, {2, 7, 9, 4, 5}};
        System.out.println(minPath(triple, 5));

    }


    public static int minPath(int[][] arr, int length) {
        int[][] states = new int[length][length];
        states[0][0] = arr[0][0];
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (j == 0) {
                    states[i][j] = states[i - 1][j] + arr[i][j];
                } else if (j == arr[i].length - 1) {
                    states[i][j] = states[i - 1][j - 1] + arr[i][j];
                } else {

                    int leftTop = states[i - 1][j - 1];
                    int rightTop = states[i - 1][j];
                    states[i][j] = Math.min(leftTop, rightTop) + arr[i][j];

                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (states[length - 1][i] < min) {
                min = states[length - 1][i];
            }
        }

        return min;
    }
}
