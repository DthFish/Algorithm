package leetcode;

/**
 * leetcode 69:计算并返回 x 的平方根，其中 x 是非负整数
 */
public class Question69 {

    public static void main(String[] args) {
//        System.out.println(mySqrt(4));
//        System.out.println(mySqrt(8));
//        System.out.println(mySqrt(15));
        System.out.println(mySqrt(2147395599));
        System.out.println(Math.sqrt(Integer.MAX_VALUE));

    }

    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int start = 1;
        int end = Math.min(x >> 1, 46340);

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt > mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;

    }
}
