package dynamic;

/**
 * 动态规划求背包问题
 */
public class Bag {

    private int maxWeight = Integer.MIN_VALUE;
    private int[] weightArr = {2, 2, 4, 6, 3};
    private int count = 5;
    private int bagWeight = 9;
    private boolean[][] memArray = new boolean[count][bagWeight + 1];

    /**
     * 回溯算法 + 剪枝
     */
    private void find(int index, int currentWeight) {
        if (index == count || currentWeight == bagWeight) {
            if (currentWeight > maxWeight) {
                maxWeight = currentWeight;
            }
            return;
        }
        if (memArray[index][currentWeight]) {
            return;
        }
        memArray[index][currentWeight] = true;
        find(index + 1, currentWeight);
        if (currentWeight + weightArr[index] <= bagWeight) {
            find(index + 1, currentWeight + weightArr[index]);
        }
    }

    /**
     * 动态规划
     *
     * @param weightArr 各个物品重量
     * @param count     物品数量
     * @param bagWeight 背包承重
     * @return 最多可以装多重
     */
    private static int find(int[] weightArr, int count, int bagWeight) {
        boolean[][] memArray = new boolean[count][bagWeight + 1];//各种状态保存数组
        memArray[0][0] = true;//第一个不放入
        memArray[0][weightArr[0]] = true;//第一个放入
        for (int i = 1; i < count; i++) {// 动态规划状态转移

            for (int j = 0; j <= bagWeight; j++) {
                if (memArray[i - 1][j]) {
                    memArray[i][j] = true;
                }
            }

            for (int j = 0; j <= bagWeight - weightArr[i]; j++) {
                if (memArray[i - 1][j]) {
                    memArray[i][j + weightArr[i]] = true;
                }
            }
        }

        for (int i = bagWeight; i >= 0; i--) {//最终结果只要看 count - 1 行，倒叙遍历的第一个为 true 的角标就可以了
            if (memArray[count - 1][i]) {
                return i;
            }
        }

        return 0;
    }

    public static int find2(int[] weightArr, int count, int bagWeight) {
        boolean[] states = new boolean[bagWeight + 1]; // 特别注意数组长度是背包承重量 + 1
        states[0] = true;
        states[weightArr[0]] = true;
        for (int i = 1; i < count; i++) {
            for (int j = bagWeight - weightArr[i]; j >= 0; j--) {
                if (states[j]) {
                    states[j + weightArr[i]] = true;
                }
            }
        }

        for (int i = bagWeight; i >= 0; --i) { // 输出结果
            if (states[i]) return i;
        }
        return 0;
    }


    public static void main(String[] args) {
        Bag bag = new Bag();
        bag.find(0, 0);
        System.out.println(bag.maxWeight);


        System.out.println(Bag.find(bag.weightArr, bag.count, bag.bagWeight));
        System.out.println(Bag.find2(bag.weightArr, bag.count, bag.bagWeight));
    }
}
