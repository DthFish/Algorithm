package leetcode;

/**
 * 168. Excel表列名称
 */
public class Question168 {

    public String convertToTitle(int n) {
        String result = null;
        while (n > 0) {
            char word = (char) ('A' + (n - 1) % 26);
            result = word + result;
            n = (n - 1) / 26;
        }
        return result;

    }
}
