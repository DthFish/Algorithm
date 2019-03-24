package recursive;

/**
 * 背包问题：
 */
public class Bag {


    public static void main(String[] args) {

        int[] weightArr = {11, 22, 33, 44, 55, 66};
        int bagWeight = 100;
        System.out.println(find(weightArr, bagWeight));

    }

    public static int find(int[] weightArr, int bagWeight) {
        maxWeight = 0;//初始化
        find(0, 0, weightArr, weightArr.length, bagWeight);
        return maxWeight;
    }

    public static int maxWeight = 0;

    public static void find(int checkIndex, int inWeight, int[] weightArr, int arrLength, int bagWeight) {
        //如果考察的index 超过数组的长度，或者已经放进背包的重量等于背包的承重量则结束
        if (checkIndex == arrLength || inWeight == bagWeight) {
            if (inWeight > maxWeight) {//我们只找最优解
                maxWeight = inWeight;
            }
            return;
        }
        //checkIndex 对应的物品我们不放进去，直接考察下一个
        find(checkIndex + 1, inWeight, weightArr, arrLength, bagWeight);

        if (inWeight + weightArr[checkIndex] <= bagWeight) {
            //checkIndex 对应的物品我们放进去，考察下一个
            find(checkIndex + 1, inWeight + weightArr[checkIndex], weightArr, arrLength, bagWeight);
        }

    }
}
