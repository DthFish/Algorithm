package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 3:无重复字符的最长子串
 * 利用滑动窗口，可以在复杂度为 n 的情况下求出解
 */
public class Question3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aba"));
        System.out.println(lengthOfLongestSubstring("ababc"));
        System.out.println(lengthOfLongestSubstring("abba"));

    }


    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = s.length();
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < length; j++) {

            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);
            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}
