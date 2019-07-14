package leetcode;

/**
 * 914. 卡牌分组
 */
public class Question914 {

    public boolean hasGroupsSizeX(int[] deck) {
        int max = 0;
        for (int i : deck) {
            max = Math.max(max, i);
        }
        int[] count = new int[max + 1];

        for (int i : deck) {
            count[i]++;
        }
        int min = 10000;
        for (int i = 0; i < max + 1; i++) {
            if (count[i] == 0) {
                continue;
            }
            min = Math.min(min, count[i]);
        }
        if (min < 2) {
            return false;
        }
        int p = min;
        for (int i = 0; i < max + 1; i++) {
            if (count[i] == 0) {
                continue;
            }
            p = help(p, count[i]);

        }
        return p >= 2;

    }

    private int help(int a, int b) {
        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        return b == 0 ? a : help(b, a % b);
    }
}
