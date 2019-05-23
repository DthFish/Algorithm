package leetcode;

/**
 * 771. 宝石与石头
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 */
public class Question771 {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("z", "ZZ"));
    }

    /**
     * 貌似直接用循环加 indexOf 更快
     */
    public static int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0) {
            return 0;
        }
        if (S == null || S.length() == 0) {
            return 0;
        }
        char[] jChar = J.toCharArray();
        char[] sChar = S.toCharArray();
        int[] counter = new int['z' - 'A' + 1];

        for (int i = 0; i < sChar.length; i++) {
            counter[sChar[i] - 'A']++;
        }
        int sum = 0;
        for (int i = 0; i < jChar.length; i++) {
            sum += counter[jChar[i] - 'A'];
        }

        return sum;
    }
}
