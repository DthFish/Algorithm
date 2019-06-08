package leetcode;

/**
 * leetcode 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 */
public class Question6 {
    public static void main(String[] args) {
        System.out.println("LCIRETOESIIGEDHN".equals(convert("LEETCODEISHIRING",3)));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int index = 0;
        boolean plus = true;
        for (int i = 0; i < s.length(); i++) {
            sbs[index].append(s.charAt(i));
            if (plus) {
                if (index < numRows - 1) {
                    index++;
                } else {
                    index--;
                    plus = false;
                }
            } else {
                if (0 < index) {
                    index--;
                } else {
                    index++;
                    plus = true;
                }
            }

        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : sbs) {
            result.append(sb.toString());
        }
        return result.toString();
    }
}
