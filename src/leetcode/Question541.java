package leetcode;

/**
 * 541. 反转字符串 II
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 */
public class Question541 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {

            if (i + k <= chars.length) {
                reverse(chars, i, i + k - 1);
            } else {
                reverse(chars, i, chars.length - 1);
            }
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int s, int e) {
        while (s < e) {
            char temp = chars[e];
            chars[e] = chars[s];
            chars[s] = temp;
            s++;
            e--;
        }
    }


}
