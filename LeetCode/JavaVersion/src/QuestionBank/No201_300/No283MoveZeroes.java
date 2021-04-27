package QuestionBank.No201_300;

public class No283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int true_pos = 0, p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[p] != 0) nums[true_pos++] = nums[p];
            p++;
        }
        for (int i = true_pos; i < nums.length; i++) nums[i] = 0;
    }
}


// LeetCode 题解
/*
public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
 */

