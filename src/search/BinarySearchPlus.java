package search;

/**
 * 二分查找升级版：针对相等
 * 1. 查找第一个等于给定值的元素
 * 2. 查找最后一个等于给定值的元素
 * 3. 查找第一个大于等于给定值的元素
 * 4. 查找最后一个小于等于给定值的元素
 */
public class BinarySearchPlus {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        System.out.println(searchFirstEquals(arr, arr.length, 8));
        System.out.println(searchLastEquals(arr, arr.length, 8));
        System.out.println(searchFirstNotSmaller(arr, arr.length, 8));
        System.out.println(searchLastNotBigger(arr, arr.length, 8));

        System.out.println("--------------------");
        System.out.println(searchFirstEquals(arr, arr.length, 7));
        System.out.println(searchLastEquals(arr, arr.length, 7));
        System.out.println(searchFirstNotSmaller(arr, arr.length, 7));
        System.out.println(searchLastNotBigger(arr, arr.length, 7));
    }

    public static int searchFirstEquals(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                // 找到相等的元素之后判断前一个是否还满足需求，不满足则返回，否则继续
                if (mid == 0 || arr[mid - 1] != target) return mid;
                else high = mid - 1;
            }
        }
        return -1;

    }

    public static int searchLastEquals(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == n - 1 || arr[mid + 1] != target) return mid;
                else low = mid + 1;
            }
        }
        return -1;

    }

    public static int searchFirstNotSmaller(int[] arr, int n, int target) {
        // 注意 target 可能不存在，但是满足要找的数存在
        // 所有大于等于的处理逻辑一致
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] < target) return mid;
                else high = mid - 1;
            }
        }

        return -1;

    }

    public static int searchLastNotBigger(int[] arr, int n, int target) {
        // 注意 target 可能不存在，但是满足要找的数存在
        // 所有小于等于的处理逻辑一致

        int low = 0;
        int high = n - 1;
        while (low <= high) {

            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= target) {
                if (mid == n - 1 || arr[mid + 1] > target) return mid;
                else low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;

    }
}
