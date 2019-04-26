package leetcode;

/**
 * leetcode 344: 反转字符串
 */
public class Question344 {

    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int n = s.length / 2;
        for (int i = 0; i < n; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
