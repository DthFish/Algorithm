package leetcode;

import java.util.Arrays;

/**
 * 165. 比较版本号
 */
public class Question165 {


    public static void main(String[] args) {
        System.out.println(compareVersion("0.1","1.0"));
    }
    public static int compareVersion(String version1, String version2) {
        String[] v1Arr = null;
        String[] v2Arr = null;
        if (version1 != null) {
            v1Arr = version1.split("\\.");
        }

        if (version2 != null) {
            v2Arr = version2.split("\\.");
        }

        if (v1Arr == null && v2Arr == null) {
            return 0;
        } else if (v1Arr == null) {
            return -1;
        } else if (v2Arr == null) {
            return 1;
        }
        if (v1Arr.length != v2Arr.length) {
            if (v1Arr.length > v2Arr.length) {
                String[] temp = new String[v1Arr.length];
                Arrays.fill(temp, "0");
                System.arraycopy(v2Arr, 0, temp, 0, v2Arr.length);
                v2Arr = temp;
            } else {
                String[] temp = new String[v2Arr.length];
                Arrays.fill(temp, "0");
                System.arraycopy(v1Arr, 0, temp, 0, v1Arr.length);
                v1Arr = temp;
            }
        }

        for (int i = 0; i < v1Arr.length; i++) {

            int a = parseInt(v1Arr[i]);
            int b = parseInt(v2Arr[i]);
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }
        return 0;
    }

    public static int parseInt(String s) {
        int result = 0;
        try {
            result = Integer.parseInt(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
