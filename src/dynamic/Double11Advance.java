package dynamic;

/**
 * 双11购物：已知有 满200减50 的优惠，有一系列的商品求：大于等于 200 并且最接近 200 的组合
 */
public class Double11Advance {

    public static void double11Advance(int[] priceArr, int count, int value) {
        boolean[][] states = new boolean[count][3 * value + 1];//超过 value 的 3 倍就没有价值了
        states[0][0] = true;
        states[0][priceArr[0]] = true;
        for (int i = 1; i < count; i++) {

            for (int j = 0; j <= 3 * value; j++) {//不买第 i 个产品
                if (states[i - 1][j]) {
                    states[i][j] = true;
                }
            }

            for (int j = 0; j <= 3 * value - priceArr[i]; j++) {//购买第 i 个产品
                if (states[i - 1][j]) {
                    states[i][j + priceArr[i]] = true;
                }
            }

        }

        int j;
        for (j = value; j < 3 * value + 1; j++) {
            if (states[count - 1][j]) break;//输出结果大于等于 value 的最小值
        }

        if (j == 3 * value + 1) return;// 没有可行解

        for (int i = count - 1; i > 0; i--) {

            if (j - priceArr[i] >= 0 && states[i - 1][j - priceArr[i]]) { // 购买了第 i 个物品，所以减去这个物品的 price，进行下一个判断
                System.out.println("buy item:" + i + ",price:" + priceArr[i]);
                j = j - priceArr[i];
            }
        }
        if (j != 0) {
            System.out.println("buy item:" + 0 + ",price:" + priceArr[0]);
        }
    }

    public static void main(String[] args) {
        int[] priceArr = {32, 12, 45, 78, 123, 200, 333};
        double11Advance(priceArr, priceArr.length, 320);
    }


}
