package leetcode;

/**
 * 696. 计数二进制子串
 */
public class Question696 {

    public int countBinarySubstrings(String s) {
        int pre = 0;
        int cur = 1;
        int result = 0;
        final char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            //判断当前的字符是否和前一个相同
            if (chars[i] == chars[i - 1]) {
                //如果相同统计数量加一
                cur++;
            } else {
                //如果不同，把数量赋值给 pre，cur 变为统计当前字符的数量
                pre = cur;
                cur = 1;
            }
            //例如已经有了3个1，111 那么之后只要是0（三个以内）的话就符合条件
            if (pre >= cur) {
                result++;
            }
        }
        return result;
    }
}
