package leetcode;

/**
 * leetcode 38. 报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */
public class Question38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
    }
    // 递归
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String temp = countAndSay(n - 1);

        int counter = 1;
        char cur = temp.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < temp.length(); i++) {
            if (cur == temp.charAt(i)) {
                counter++;
                continue;
            }
            sb.append(counter).append(cur);
            cur = temp.charAt(i);
            counter = 1;
        }
        sb.append(counter).append(cur);

        return sb.toString();

    }
}
