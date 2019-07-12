package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1048. 最长字符串链
 */
public class Question1048 {

    public static void main(String[] args) {
        String[] arr = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        System.out.println(longestStrChain(arr));
    }

    public static int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int[] status = new int[words.length];
        for (int i = 0; i < words.length - 1; i++) {

            for (int j = i + 1; j < words.length; j++) {

                if (isPre(words[i], words[j])) {
                    status[j] = Math.max(status[j], status[i] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (res < status[i]) {
                res = status[i];
            }
        }
        return res + 1;

    }

    private static boolean isPre(String word, String word2) {
        if (word.length() + 1 != word2.length()) {
            return false;
        }
        char[] chars = word.toCharArray();
        char[] chars2 = word2.toCharArray();
        int i = 0;
        int j = 0;
        while (i < chars.length && j < chars2.length) {
            if (chars[i] == chars2[j]) {
                i++;
            }
            j++;
        }
        return i == chars.length;
    }
}
