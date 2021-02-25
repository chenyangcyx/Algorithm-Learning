package CSNotes.Sort;

import java.util.Arrays;

public class No75SortColors {
    // 使用java自带的排序
    public void sortColors1(int[] nums) {
        Arrays.sort(nums);
    }

    // 使用三向切分快速排序
    public void sortColors2(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, --two, one);
            } else {
                ++one;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
