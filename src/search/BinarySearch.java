package search;

/**
 * 二分查找：
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 9, 13, 24, 33, 34, 39, 57};
        System.out.println(binarySearch(arr, 10, 40));
        System.out.println(binarySearch(arr, 10, 24));
        System.out.println(binarySearch2(arr, 10, 40));
        System.out.println(binarySearch2(arr, 10, 24));
    }

    public static int binarySearch(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        //等于的时候还是要判断
        while (low <= high) {
            // 不直接相加除以 2 是因为当 low 和 high 很大的时候可以防止溢出；位运算提高效率
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] arr, int n, int target) {
        return binarySearchPart(arr, 0, n - 1, target);
    }

    private static int binarySearchPart(int[] arr, int low, int high, int target) {
        //等于的时候还是要判断
        if (low > high) return -1;
        // 不直接相加除以 2 是因为当 low 和 high 很大的时候可以防止溢出；位运算提高效率
        int mid = low + ((high - low) >> 1);
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearchPart(arr, low, mid - 1, target);
        } else {
            return binarySearchPart(arr, mid + 1, high, target);
        }
    }


}
