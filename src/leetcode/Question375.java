package leetcode;

/**
 * leetcode 375. 猜数字大小 II
 * 我们正在玩一个猜数游戏，游戏规则如下：
 * <p>
 * 我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
 * <p>
 * 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
 * <p>
 * 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
 */
public class Question375 {

    public static void main(String[] args) {
        System.out.println(getMoneyAmount(10));
    }


    public static int getMoneyAmount(int n) {
        // status[i][j] 表示从 i 到 j 之间最多需要多少现金
        int[][] status = new int[n + 1][n + 1];
        for (int i = 2; i <= n; i++) {

            for (int j = i - 1; j > 0; j--) {

                if (j == i - 1) {
                    //例如[1,2]最多当然只要 1 现金，
                    status[j][i] = j;
                } else {
                    int tempMin = Integer.MAX_VALUE;
                    for (int k = j + 1; k < i; k++) {
                        int tempMax = k + Math.max(status[j][k - 1], status[k + 1][i]);
                        tempMin = Math.min(tempMax, tempMin);
                    }
                    status[j][i] = tempMin;
                }
            }

        }
        return status[1][n];
    }
}
