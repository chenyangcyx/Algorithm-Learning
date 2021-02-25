package CSNotes.Sort;

import java.util.Random;

public class QuickSort {
    // 该函数的作用是对区间[left, right]进行划分，取nums[left]作为主元
    // 使得左边的所有数字小于等于nums[left]，右边的都大于
    private int Partition(int[] nums, int left, int right) {
//        int temp = nums[left];
        // 为了使得不会出现最坏的时间情况，将left的元素与[left, right]内的一个元素进行调换
        int random_pos = new Random().nextInt(right - left) + left;
        int t = nums[left];
        nums[left] = nums[random_pos];
        nums[random_pos] = t;
        int temp = nums[left];
        // 开始调换顺序
        while (left < right) {
            while (left < right && nums[right] > temp) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) left++;
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            // 将[left, right]区间按nums[left]一分为二
            int pos = Partition(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }
}
