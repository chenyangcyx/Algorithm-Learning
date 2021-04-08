package QuestionBank.No101_200;

public class No153FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.min(nums[0], nums[1]);
        int left = 0, right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid]<nums[right]) right=mid;
            else left=mid+1;
        }
        return nums[left];
    }
}


// LeetCode 参考代码
/*
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }
}
*/