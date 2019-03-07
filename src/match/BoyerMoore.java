package match;

/**
 * BoyerMoore 算法:1. 坏字符规则,求滑动距离;
 * 2. 好后缀规则,求滑动距离;查看模式串是否存在其他和好后缀匹配的地方,如果没有则再次查看模式串的前缀是否有和好后缀的后缀匹配的地方
 * 3. 两者取最大;
 */
public class BoyerMoore {
    public static final int SIZE = 256;

    public static void main(String[] args) {
        String total = "dfsadbcbcabcabcsdfbacbcbc";
        String patten = "abcabc";
        System.out.println(bm(total.toCharArray(), total.length(), patten.toCharArray(), patten.length()));
    }

    /**
     * @param a 主串
     * @param m 主串长度
     * @param b 模式串
     * @param n 模式串长度
     * @return
     */
    public static int bm(char[] a, int m, char[] b, int n) {
        // bad character
        int[] bc = generateBC(b, n);
        int[] suffix = new int[n];
        boolean[] prefix = new boolean[n];
        // good
        generateGS(b, n, suffix, prefix);
        int i = 0;
        while (i <= m - n) {
            int j;
            for (j = n - 1; j >= 0; j--) {

                if (a[i + j] != b[j]) break;// 坏字符在a 的 i+j
            }
            if (j < 0) {
                return i;
            }
            // 坏字符规则移动距离：j 是坏字符对应模式串的角标，a[i+j] 为坏字符，bc 是事先处理好的坏字符在模式串里的角标
            int x = j - bc[a[i + j]];

            int y = 0;
            if (j < n - 1) {
                y = moveByGS(j, n, suffix, prefix);
            }

            i = i + Math.max(x, y);

        }
        return -1;

    }

    /**
     *
     * @param j 表示坏字符对应的模式串中的字符下标
     */
    private static int moveByGS(int j, int n, int[] suffix, boolean[] prefix) {
        int k = n - 1 - j;
        // 找到和好后缀匹配的下标
        if (suffix[k] != -1) return j - suffix[k] + 1;

        // 找不到好后缀进一步判断前缀
        for (int i = j + 2; i <= n; i++) {
            if (prefix[n - i]) {
                return i;
            }
        }
        return n;
    }

    private static int[] generateBC(char[] b, int n) {
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            arr[b[i]] = i;
        }

        return arr;
    }

    private static void generateGS(char[] b, int n, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < n; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }

        for (int i = 0; i < n - 1; i++) {

            int j = i;
            int k = 0;
            while (j >= 0 && b[j] == b[n - 1 - k]) {
                j--;
                k++;
                suffix[k] = j + 1;
            }
            if (j == -1) prefix[k] = true;
        }

    }


}
