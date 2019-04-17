package recursive;

/**
 * 上台阶一次上 1 台阶或者 2 台阶，求有几种方法
 * 递归思想
 */
public class OneTwoStep {

    public static void main(String[] args) {
        System.out.println(step(1));
        System.out.println(step(2));
        System.out.println(step(3));
        System.out.println(step(4));
        System.out.println(climbStairs(44));
    }

    public static int step(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return step(n - 1) + step(n - 2);
    }

    /**
     * 动态规划思想，效率比{@link #step(int)}更快
     */
    public static int climbStairs(int n) {
        int[] d = new int[n + 1];
        d[0] = d[1] = 1;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        return d[n];
    }
}
