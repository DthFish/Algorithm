package leetcode;

/**
 * leetcode 151. 翻转字符串里的单词
 */
public class Question151 {
    public static void main(String[] args) {
//        System.out.println(reverseWords(""));
//        System.out.println(reverseWords(" "));
//        System.out.println(reverseWords(null));
//        System.out.println(reverseWords("1  2 3"));
        System.out.println(reverseWords("  hello world!  "));
    }

    public static String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        String[] split = s.trim().split("[ ]+");
        if (split.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
