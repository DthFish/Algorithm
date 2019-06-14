package leetcode;

/**
 * leetcode 504. 七进制数
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 */
public class Question504 {

    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(-7));
        System.out.println(convertToBase7(0));
    }


    public static String convertToBase7(int num) {
        int temp = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (temp > 0) {
            int i = temp % 7;
            sb.append(i);
            temp /= 7;
        }
        if (sb.length() == 0) {
            sb.append(0);
        }
        if (num < 0) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
