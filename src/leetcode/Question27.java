package leetcode;

/**
 * 27. 移除元素
 */
public class Question27 {

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(arr, 2));

    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int currentIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                nums[i] = nums[currentIndex];
                nums[currentIndex] = val;
                currentIndex--;
            }

        }
        return currentIndex + 1;

    }
}
