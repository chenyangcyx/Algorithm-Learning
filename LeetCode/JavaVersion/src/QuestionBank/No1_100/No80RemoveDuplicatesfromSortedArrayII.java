package QuestionBank.No1_100;

public class No80RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) return length;
        int slow = 0, fast = 2;
        while (fast < length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 2] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 2;
    }

    // LeetCode 题解
    // 双指针
    /*
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
    */
}
