package leetcode;

/**
 * 268. 缺失数字
 */
public class Question268 {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        System.out.println(missingNumber(arr));
        System.out.println(missingNumber2(arr));
    }

    public static int missingNumber(int[] nums) {

        int[] count = new int[nums.length + 1];

        for (int num : nums) {
            count[num]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int missingNumber2(int[] nums) {

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i] ^ (i + 1);
        }
        return res;
    }


}
