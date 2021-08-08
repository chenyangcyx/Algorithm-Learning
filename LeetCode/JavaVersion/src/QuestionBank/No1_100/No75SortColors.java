package QuestionBank.No1_100;

import java.util.Arrays;

public class No75SortColors {
    public void sortColors1(int[] nums) {
        int po = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swapNum(nums, i, po++);
            }
        }
        for (int i = po; i < nums.length; i++) {
            if (nums[i] == 1) {
                swapNum(nums, i, po++);
            }
        }
    }

    public void sortColors2(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swapNum(nums, i, p1++);
            } else if (nums[i] == 0) {
                swapNum(nums, i, p0);
                if (p0 < p1) {
                    swapNum(nums, i, p1);
                }
                p0++;
                p1++;
            }
        }
    }

    public void sortColors3(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                swapNum(nums, i, p2--);
            }
            if (nums[i] == 0) {
                swapNum(nums, i, p0++);
            }
        }
    }

    private void swapNum(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 0, 2, 1, 1, 0};
        int[] nums2 = new int[]{2, 0, 1};
        int[] nums3 = new int[]{0};
        int[] nums4 = new int[]{1};

        No75SortColors no75SortColors = new No75SortColors();

//        no75SortColors.sortColors1(nums1);
//        no75SortColors.sortColors1(nums2);
//        no75SortColors.sortColors1(nums3);
//        no75SortColors.sortColors1(nums4);

//        no75SortColors.sortColors2(nums1);
//        no75SortColors.sortColors2(nums2);
//        no75SortColors.sortColors2(nums3);
//        no75SortColors.sortColors2(nums4);

        no75SortColors.sortColors3(nums1);
        no75SortColors.sortColors3(nums2);
        no75SortColors.sortColors3(nums3);
        no75SortColors.sortColors3(nums4);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(nums4));
    }
}
