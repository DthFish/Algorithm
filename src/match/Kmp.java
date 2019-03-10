package match;

/**
 * kmp 算法：让长串的每一个字符在模式串上匹配，直到累计匹配完模式串，每次匹配失败的时候，
 * 从好前缀的后缀中查找可以和模式串的前缀匹配的位置，继续匹配
 */
public class Kmp {
    public static void main(String[] args) {
        String total = "dfsadbcbcabcabcsdfbacbcbc";
        String patten = "abcabc";
        System.out.println(kmp(total.toCharArray(), total.length(), patten.toCharArray(), patten.length()));
    }

    public static int kmp(char[] a, int m, char[] b, int n) {
        int[] next = getNext(b, n);
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j > 0 && b[j] != a[i]) {
                j = next[j - 1] + 1;
            }
            if (b[j] == a[i]) {
                j++;
            }
            if (j == n) {
                return i - n + 1;
            }
        }

        return -1;
    }

    /**
     * 可以理解为回退函数，每当下一个字符不匹配时，回退到前面可匹配的位置继续
     */
    private static int[] getNext(char[] b, int n) {
        int[] next = new int[n];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < n; i++) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                k++;
            }

            next[i] = k;
        }

        return next;
    }
}
