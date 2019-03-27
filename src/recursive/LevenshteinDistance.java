package recursive;

/**
 * 求两个字符传的莱文斯坦距离：回溯算法
 */
public class LevenshteinDistance {

    public static void main(String[] args) {
        LevenshteinDistance distance = new LevenshteinDistance();
        distance.distance(0, 0, 0);
        System.out.println(distance.minDist);

    }

    private char[] str1 = "mitcmu".toCharArray();
    private char[] str2 = "mtacnu".toCharArray();
    private int n = str1.length;
    private int m = str2.length;
    private int minDist = Integer.MAX_VALUE;

    public void distance(int i, int j, int dist) {
        if (i == n || j == m) {
            if (i < n) dist += n - i;
            if (j < m) dist += m - j;
            if (dist < minDist) {
                minDist = dist;
            }
            return;
        }

        if (str1[i] == str2[j]) {
            distance(i + 1, j + 1, dist);
        } else {
            distance(i + 1, j, dist + 1);
            distance(i, j + 1, dist + 1);
            distance(i + 1, j + 1, dist + 1);
        }

    }
}
