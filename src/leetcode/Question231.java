package leetcode;

/**
 * leetcode 231. 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class Question231 {

    // 傻方法
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int temp = 0;
        while (n != 0) {
            temp += n & 1;
            n = n >> 1;
        }
        return temp == 1;
    }
    // 666
    public static boolean isPowerOfTwo2(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
