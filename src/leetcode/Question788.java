package leetcode;


/**
 * LeetCode 788: 旋转数字,各个数字旋转之后还是一个数，且和原来不相等
 */
public class Question788 {

    public static void main(String[] args) {
        System.out.println(rotatedDigits(2));
        System.out.println(rotatedDigits(10));
        System.out.println(rotatedDigits(1111));
    }

    /**
     * 0 - 9: 0,1,8 必须和其他好数配合，2，5，6，9 是好数，其余一出现就不是好数
     */
    private static final int[] sMap = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    /**
     * 1 - N 之间好数的个数
     */
    public static int rotatedDigits(int N) {
        int count = 0;
        if (N < 10) {
            for (int i = 1; i <= N; i++) {
                if (sMap[i] > 0) {
                    count++;
                }
            }
            return count;
        }

        for (int i = 1; i <= N; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 0 和任何数或运算都是那个数，-1 和任何数或运算都是 -1
     */
    private static boolean isGood(int i) {
        int flag = 0;
        while (i > 0) {
            int mod = i % 10;
            flag |= sMap[mod];
            i /= 10;
        }
        return flag > 0;
    }
}
