package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 916. 单词子集
 */
public class Question916 {


    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        int[] countB = new int[26];
        for (int i = 0; i < B.length; i++) {
            int[] count = getCount(B[i]);
            for (int j = 0; j < count.length; j++) {
                countB[j] = Math.max(count[j], countB[j]);
            }
        }

        for (int i = 0; i < A.length; i++) {
            int[] count = getCount(A[i]);
            boolean shouldAdd = true;
            for (int j = 0; j < count.length; j++) {
                if (count[j] < countB[j]) {
                    shouldAdd = false;
                    break;
                }
            }
            if (shouldAdd) {
                result.add(A[i]);
            }
        }

        return result;
    }

    public int[] getCount(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        return counts;
    }
}
