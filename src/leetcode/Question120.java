package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 */
public class Question120 {

    public static void main(String[] args) {
        int[][] arr = {{2}, {3, 4}, {6, 5, 4}, {4, 1, 8, 3}};
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> temp = new ArrayList<>();
            triangle.add(temp);

            for (int j = 0; j < arr[i].length; j++) {
                temp.add(arr[i][j]);
            }
        }

        System.out.println(minimumTotal(triangle));

    }

    /**
     * 动态规划问题,其实还能优化，从最后一行往上计算那么 status[0][0]就是结果
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] status = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        status[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                Integer cur = triangle.get(i).get(j);
                if (j == 0) {
                    status[i][j] = status[i - 1][j] + cur;
                } else if (j == triangle.get(i).size() - 1) {
                    status[i][j] = status[i - 1][j - 1] + cur;
                } else {
                    status[i][j] = Math.min(status[i - 1][j - 1], status[i - 1][j]) + cur;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < status[status.length - 1].length; i++) {
            if (min > status[status.length - 1][i]) {
                min = status[status.length - 1][i];
            }
        }


        return min;
    }
}
