package leetcode;

/**
 * 67. 二进制求和
 */
public class Question67 {

    public static void main(String[] args) {
        System.out.println(addBinary("110010", "10111"));
    }

    public static String addBinary(String a, String b) {

        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        StringBuilder aSb = new StringBuilder();
        aSb.append(a).reverse();
        char[] aChars = aSb.toString().toCharArray();
        StringBuilder bSb = new StringBuilder();
        bSb.append(b).reverse();
        char[] bChars = bSb.toString().toCharArray();

        StringBuilder result = new StringBuilder();

        int shortLen = 0;
        boolean aIsShort = false;
        if (aChars.length > bChars.length) {
            shortLen = bChars.length;

        } else {
            aIsShort = true;
            shortLen = aChars.length;
        }
        int i = 0;
        int shouldPlus = 0;
        while (i < shortLen) {
            if (aChars[i] == bChars[i]) {
                if (shouldPlus > 0 && aChars[i] == '1') {
                    result.append('1');

                } else if (shouldPlus > 0 && aChars[i] == '0') {
                    shouldPlus = 0;
                    result.append('1');

                } else if (aChars[i] == '1') {
                    shouldPlus = 1;
                    result.append('0');
                } else {
                    result.append('0');
                }

            } else {
                if (shouldPlus > 0) {
                    shouldPlus = 1;
                    result.append('0');
                } else {
                    result.append('1');
                }
            }
            i++;
        }

        char[] remainArr = aIsShort ? bChars : aChars;

        while (i < remainArr.length) {
            if (shouldPlus > 0 && remainArr[i] == '1') {
                result.append('0');
            } else if (shouldPlus > 0 && remainArr[i] == '0') {
                result.append('1');
                shouldPlus = 0;
            } else {
                result.append(remainArr[i]);
            }
            i++;
        }
        if (shouldPlus > 0) {
            result.append('1');
        }

        return result.reverse().toString();

    }
}
