package leetcode;

/**
 * 423. 从英文中重建数字
 */
public class Question423 {
    // 根据数字英文的特征，先统计一部分，然后排除已经统计了的再在剩下的数字里找特征
    public String originalDigits(String s) {
        int[] count = new int[26 + 'a'];

        char[] chars = s.toCharArray();
        for (char aChar : chars) {

            count[aChar]++;
        }

        int[] out = new int[10];
        // letter "z" is present only in "zero"
        out[0] = count['z'];
        // letter "w" is present only in "two"
        out[2] = count['w'];
        // letter "u" is present only in "four"
        out[4] = count['u'];
        // letter "x" is present only in "six"
        out[6] = count['x'];
        // letter "g" is present only in "eight"
        out[8] = count['g'];
        // letter "h" is present only in "three" and "eight"
        out[3] = count['h'] - out[8];
        // letter "f" is present only in "five" and "four"
        out[5] = count['f'] - out[4];
        // letter "s" is present only in "seven" and "six"
        out[7] = count['s'] - out[6];
        // letter "i" is present in "nine", "five", "six", and "eight"
        out[9] = count['i'] - out[5] - out[6] - out[8];
        // letter "n" is present in "one", "nine", and "seven"
        out[1] = count['n'] - out[7] - 2 * out[9];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < out[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();

    }
}
