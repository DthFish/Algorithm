package leetcode;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0
 */
public class Question7 {
    public static void main(String[] args) {
        System.out.println(reverse(100));
        System.out.println(reverse(-100));
        System.out.println(reverse(2234));
        System.out.println(reverse(Integer.MAX_VALUE));
    }


    public static int reverse(int x) {
        long res = 0;
        int fix = x < 0 ? -1 : 1;
        x *=fix;
        while (x != 0) {
            int num = x % 10;
            x = x / 10;

            res = res * 10 + num;
        }
        res *= fix;
        if(res < Integer.MIN_VALUE || res > Integer.MAX_VALUE){
            return 0;
        }

        return (int) res;
    }
}
