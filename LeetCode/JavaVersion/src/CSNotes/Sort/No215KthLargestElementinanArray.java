package CSNotes.Sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class No215KthLargestElementinanArray {
    // 通过程序自带的sort函数实现
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 通过PriorityQueue容器实现
    // 通过程序自带的sort函数实现
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }

    // 通过快速排序的变形实现
    public int findKthLargest3(int[] nums, int k) {
        int pos = nums.length - k;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int t = Partitation(nums, i, j);
            if (t == pos) break;
            else if (t < pos) i = t + 1;
            else j = t - 1;
        }
        return nums[pos];
    }

    private int Partitation(int[] nums, int left, int right) {
        int random_pos = new Random().nextInt(right - left) + left;
        int t = nums[random_pos];
        nums[random_pos] = nums[left];
        nums[left] = t;
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > temp)
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }
}
