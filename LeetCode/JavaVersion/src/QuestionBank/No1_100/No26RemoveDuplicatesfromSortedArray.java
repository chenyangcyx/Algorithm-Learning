package QuestionBank.No1_100;

public class No26RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 1) return length;
        int slow = 0, fast = 1;
        while (fast < length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }
}
