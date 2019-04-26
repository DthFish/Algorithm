package offer;

/**
 * 剑指 offer 4：在矩阵(每行每列递增)中查找数
 */
public class Question4 {

    public static void main(String[] args) {

        int[][] arr =
                {
                        {1, 2, 8, 9},
                        {2, 4, 9, 12},
                        {4, 7, 10, 13},
                        {6, 8, 11, 15}
                };
        System.out.println(find(arr, 4, 4, 7));
        System.out.println(find(null, 4, 4, 7));
        System.out.println(find(arr, 0, 0, 3));


    }

    /**
     * 从右上或者左下开始检查都可以，因为这样可以一次性剔除一行或者一列
     */
    private static boolean find(int[][] arr, int rows, int columns, int num) {
        boolean find = false;
        if (arr != null && rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;

            while (row < rows && column >= 0) {
                if (arr[row][column] == num) {
                    find = true;
                    break;
                } else if (arr[row][column] > num) {
                    column--;
                } else {
                    row++;
                }
            }
        }

        return find;
    }
}
