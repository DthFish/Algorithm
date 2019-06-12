package leetcode;

/**
 * leetcode 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
public class Question567 {

    public static void main(String[] args) {

        System.out.println(checkInclusion("ab", "eidaooo"));
        System.out.println(checkInclusion("ab", "eidaoba"));
        System.out.println(checkInclusion2("ab", "eidaooo"));
        System.out.println(checkInclusion2("ab", "eidaoba"));

    }

    /**
     * 滑动窗口，对于 charCount1 来说里面各个字符的数量是不变的，所以只要不断调整 charCount2 里面的字符的数量，然后对比
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        int[] charCount1 = new int[26];
        int[] charCount2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            charCount1[s1.charAt(i) - 'a']++;
            charCount2[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (isSimilar(charCount1, charCount2)) {
                return true;
            }
            charCount2[s2.charAt(i - s1.length()) - 'a']--;
            charCount2[s2.charAt(i) - 'a']++;
        }
        return isSimilar(charCount1, charCount2);
    }

    private static boolean isSimilar(int[] arr, int[] arr2) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 更快速的滑动窗口，减少了遍历
     */
    public static boolean checkInclusion2(String s1, String s2) {
        int[] count = new int[26];
        char[] pattern = s1.toCharArray();
        char[] chars = s2.toCharArray();

        for (int i = 0; i < pattern.length; i++) {
            count[pattern[i] - 'a']++;
        }

        int start = 0;
        int end = 0;
        while (end < chars.length) {
            if (count[chars[end] - 'a'] != 0) {
                count[chars[end] - 'a']--;
                end++;
                if (end - start == pattern.length) {
                    return true;
                }
            } else if (start == end) {
                start++;
                end++;
            } else {
                count[chars[start] - 'a']++;
                start++;
            }
        }
        return false;
    }
}
