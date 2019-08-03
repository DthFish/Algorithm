package leetcode;

/**
 * 376. 摆动序列
 */
public class Question376 {

    public static void main(String[] args) {
        int[] arr = {0,0};
        int[] arr2 = {1,2,3,4,5,6,7,8,9};
        System.out.println(wiggleMaxLength(arr));
//        System.out.println(wiggleMaxLength(arr2));
    }

    public static int wiggleMaxLength(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] diff = new int[nums.length - 1];
        int diffLen = 0;

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i] - nums[i - 1];
            if (temp == 0) {
                continue;
            } else {
                diff[diffLen++] = temp;
            }
        }

        // 到这里
        int count = 0;

        for (int i = 1; i < diffLen; i++) {
            if ((diff[i] * diff[i - 1]) > 0) {
                count++;
            }
        }
        return diffLen - count + 1;
    }
}
