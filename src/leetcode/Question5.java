package leetcode;

/**
 * leetcode 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 中心拓展法：长度为 n 的字符串，有 2n -1 个中心，n 个 1 字符的， n - 1 个 2 字符的
 */
public class Question5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abab"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extendCenter(s, i, i);
            int len2 = extendCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int extendCenter(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }
}
