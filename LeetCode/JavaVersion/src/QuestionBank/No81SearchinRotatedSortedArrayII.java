package QuestionBank;

public class No81SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) return false;
        if (length == 1) return nums[0] == target;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target || nums[left] == target || nums[right] == target) return true;
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}


// LeetCode 参考代码
/*
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
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
        return false;
    }
}
*/


// 网友代码
/*
class Solution {
    public boolean search(int[] nums, int target) {
        int i = 0, j = nums.length - 1, m = (i+j)/2;
        while(i<=j){
            if(nums[m] == target || nums[i] == target || nums[j] == target){return true;}
            else if(nums[m] > target && nums[i] < target) {j = m-1;}//左侧有序区间，启动二分查找
            else if(nums[m] < target && nums[j] > target) {i = m+1;}//右侧有序区间，启动二分查找
            else {i++;j--;}//仍在中间无序部分，左边界加1，右边界减一
            m = (i+j)/2;
        }
        return false;
    }
}
*/