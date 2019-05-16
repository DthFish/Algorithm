package recursive;

/**
 * 八皇后问题：
 */
public class EightQueue {


    public static void main(String[] args) {
        eightQueue(0);
    }

    // index 表示行号，val 表示列号
    private static int[] result = new int[8];

    public static void eightQueue(int row) {
        if (row == 8) {
            printQueues(result);
            return;
        }

        for (int column = 0; column < 8; column++) {// 每一行都有 8 中放法
            if (isOk(row, column)) {// 有些放法不满足要求
                result[row] = column;// 第 row 行的棋子放到了 column 列
                eightQueue(row + 1);// 这里不能使用自增，因为 row 后续还要使用
            }
        }


    }

    private static boolean isOk(int row, int column) {
        int left = column - 1;
        int right = column + 1;
        for (int i = row - 1; i >= 0; i--) {// 逐行往上考察每一行
            if (result[i] == column) return false;

            if (left >= 0 && result[i] == left) return false;

            if (right < 8 && result[i] == right) return false;

            left--;
            right++;

        }

        return true;
    }

    private static void printQueues(int[] result) {
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
