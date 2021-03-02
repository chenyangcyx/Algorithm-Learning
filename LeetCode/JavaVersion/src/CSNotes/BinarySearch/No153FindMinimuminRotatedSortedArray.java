package CSNotes.BinarySearch;

public class No153FindMinimuminRotatedSortedArray {
    // 自己写的代码
    public int findMin1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= nums[r]) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }

    // CS-Note参考代码
    public int findMin2(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
