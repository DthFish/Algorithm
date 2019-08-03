package leetcode;

/**
 * 457. 环形数组循环
 */
public class Question457 {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -1, -2, -2};
        int[] arr2 = {2, -1, 1, 2, 2};
        int[] arr3 = {3, 1, 2};
        int[] arr4 = {-1, -2, -3, -4, -5};

        System.out.println(circularArrayLoop(arr4));
    }

    /**
     * 漏洞百出修复过来的哎
     */
    public static boolean circularArrayLoop(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return false;
        }
        boolean[] flags = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flags[i] = true;
        }

        int from = 0;

        for (int i = 0; i < nums.length; i++) {
            boolean[] reach = new boolean[nums.length];
            reach[i] = true;
            int find = 0;
            from = i;
            int to = (from + nums[from]) % nums.length;
            if (to < 0) {
                to += nums.length;
            }

            while (from != to && flags[from] && flags[to] && nums[from] * nums[to] > 0) {
                from = to;
                if (reach[to]) {
                    find = -find;
                    break;
                } else {
                    reach[to] = true;
                    find--;
                    to = (from + nums[from]) % nums.length;
                    if (to < 0) {
                        to += nums.length;
                    }

                }
            }

            if (find > 0) {
                return true;
            } else {

                flags[i] = false;
            }
        }

        return false;
    }

    // 判断循环还是用快慢指针比较好
    public boolean circularArrayLoop2(int[] nums) {
        if (nums.length == 1) return false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            int fast = i, slow = i;
            // 异或大于等于0，意味着两个数不是一正一负数
            while ((nums[i] ^ nums[fast]) >= 0 && (nums[i] ^ nums[getNext(fast, nums)]) >= 0) {
                slow = getNext(slow, nums);
                fast = getNext(getNext(fast, nums), nums);
                // 快指针走两步，慢指针走一步，如果能够形成环形则它们一定在一个时间会重合
                if (slow == fast) {
                    // 判断是否是一个数在循环，因为这个不满足题意
                    if (slow == getNext(slow, nums)) break;
                    return true;
                }
            }
            // 这里把没有环的位置都清空，判断其他的起始点的时候就不会重复走已经走过的点
            int idx = i;
            int val = nums[i];
            while ((nums[idx] ^ val) >= 0 && nums[idx] != 0) {
                int next = getNext(idx, nums);
                nums[idx] = 0;
                idx = next;
            }
        }
        return false;
    }

    public int getNext(int i, int[] nums) {
        return i + nums[i] >= 0 ? (i + nums[i]) % nums.length : nums.length + (i + nums[i]) % nums.length;
    }
}
