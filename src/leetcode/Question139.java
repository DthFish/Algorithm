package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leetcode 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 */
public class Question139 {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        System.out.println(wordBreak(s, wordDict));
        System.out.println(wordBreak(s + "d", wordDict));

    }

    /**
     * 动态规划。。。。。
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }

        boolean[] status = new boolean[s.length() + 1];
        status[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {

            for (int j = 0; j < wordDict.size(); j++) {
                String sub = wordDict.get(j);

                if (sub.length() <= i && status[i - sub.length()] && s.substring(i - sub.length(), i).equals(sub)) {
                    status[i] = true;
                    break;
                }
            }

        }

        return status[s.length()];
    }
}
