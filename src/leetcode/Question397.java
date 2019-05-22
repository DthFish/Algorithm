package leetcode;

/**
 * 397. 整数替换
 */
public class Question397 {
    public static void main(String[] args) {
        System.out.println(integerReplacement(8));
        System.out.println(integerReplacement(7));
        System.out.println(integerReplacement(65535));
        System.out.println(integerReplacement(1234));
        System.out.println(integerReplacement(2147483647));

        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(11));
        System.out.println(Integer.toBinaryString(23));
    }

    public static int integerReplacement(int n) {
        // 注意边界判断，用位运算提高效率
        if (Integer.MAX_VALUE == n) {
            return 32;
        }
        int result = 0;
        while (n != 1) {
            // 如果为奇数则要两次操作，否则只要一次操作
            if ((n & 1) == 1) {
                result += 2;
                //下面来判断 +1 还是 -1 效率高
                int temp = n >> 1;
                //当除以2之后结果为不为 1 而且是奇数则用 +1，否则用 -1
                //举🌰来说明为什么是这样：
                //23 二进制为 10111，如果用 +1 直接成为 11000，然后右移 3次成为 11，用4次操作处理了三个1
                //23 二进制为 10111，如果用 -1 成为 10110，然后右移 1次成为 1011，继续 -1 右移成为 101，4次操作才处理两个1
                //可以发现在连续是1的情况下使用 +1 的方式更高效！但是只有 3 二进制为 11 的情况除外，可以自己试下
                if (temp != 1 && (temp & 1) == 1) {
                    n++;
                } else {
                    n--;
                }

            } else {
                result++;
            }
            n = n >> 1;
        }
        return result;

    }
}
