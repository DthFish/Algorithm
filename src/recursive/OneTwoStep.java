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
    }

    public static int step(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return step(n - 1) + step(n - 2);
    }
}
