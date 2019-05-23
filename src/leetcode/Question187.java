package leetcode;

import java.util.*;

/**
 * 187. 重复的DNA序列
 */
public class Question187 {

    public static void main(String[] args) {
        System.out.println(Math.pow(4, 9));
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    /**
     * 所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
     * <p>
     * 编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。
     * A - 0;
     * C - 1;
     * G - 2;
     * T - 3
     * 四进制
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10) {
            return new ArrayList<>();
        }
        Set<String> filter = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (!filter.add(sub)) {
                result.add(sub);
            }

        }
        return new ArrayList<>(result);
    }


}
