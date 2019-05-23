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
        char[] charArray = s.toCharArray();
        int[] values = new int[charArray.length - 9];

        for (int i = 0; i <= 9; i++) {
            values[0] = values[0] * 4 + getValue(charArray[i]);
        }

        for (int i = 1; i < charArray.length - 9; i++) {
            values[i] = (values[i - 1] - getValue(charArray[i - 1]) * 262144) * 4 + getValue(charArray[i + 9]);
        }

        HashMap<Integer, Integer> set = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (set.containsKey(values[i])) {
                Integer count = set.get(values[i]);
                if (count == 1) {
                    result.add(s.substring(i, i + 10));
                }
                set.put(values[i], 2);

            } else {
                set.put(values[i], 1);
            }
        }

        return result;
    }

    public static int getValue(char c) {
        int result = 0;
        switch (c) {
            case 'A':
                break;
            case 'C':
                result = 1;
                break;
            case 'G':
                result = 2;
                break;
            case 'T':
                result = 3;
                break;
        }
        return result;
    }
}
