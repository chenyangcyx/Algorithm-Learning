package QuestionBank.No1_100;

public class No33SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int N = nums.length;
        if (N == 0) return -1;
        if (N == 1) return nums[0] == target ? 0 : -1;
        int i = 0, j = N - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) return mid;
            // 如果左半部分是有序数组
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) j = mid - 1;
                else i = mid + 1;
            }
            // 如果右半部分是有序数组
            else {
                if (nums[mid] < target && target <= nums[N - 1]) i = mid + 1;
                else j = mid - 1;
            }
        }
        return -1;
    }

    // LeetCode 参考代码
    public int search2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
