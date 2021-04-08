package QuestionBank.No1_100;

public class No31NextPermutation {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length == 1) return;
        int index = length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) index--;
        if (index >= 0) {
            int j = length - 1;
            while (j >= index && nums[j] <= nums[index]) j--;
            nums[index] = nums[index] ^ nums[j];
            nums[j] = nums[index] ^ nums[j];
            nums[index] = nums[index] ^ nums[j];
        }
        int left = index + 1, right = length - 1;
        while (left < right) {
            nums[left] = nums[left] ^ nums[right];
            nums[right] = nums[left] ^ nums[right];
            nums[left] = nums[left] ^ nums[right];
            left++;
            right--;
        }
    }
}


// LeetCode 参考代码
/*
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
*/