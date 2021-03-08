package Contest1;

import java.util.Scanner;

public class No1_20 {
    public void No1_20() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
        mergeSort2(nums, 0, nums.length - 1);
        for (int i = 0; i < N; i++) {
            if (i == 0) System.out.print(nums[i]);
            else System.out.print(" " + nums[i]);
        }
        System.out.println();
    }

    private void mergeSort1(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort1(nums, left, mid);
            mergeSort1(nums, mid + 1, right);
            merge(nums, left, mid, mid + 1, right);
        }
    }

    public void mergeSort2(int[] nums, int left, int right) {
        for (int step = 2; step / 2 <= nums.length; step *= 2) {
            for (int i = 0; i <= nums.length; i += step) {
                int mid = i + step / 2 -1;
                if (mid + 1 <= nums.length) merge(nums, i, mid, mid + 1, Integer.min(i + step - 1, nums.length - 1));
            }
        }
    }

    private void merge(int[] nums, int L1, int R1, int L2, int R2) {
        int i = L1, j = L2;
        int[] temp = new int[nums.length];
        int index = 0;
        while (i <= R1 && j <= R2) {
            if (nums[i] <= nums[j]) temp[index++] = nums[i++];
            else temp[index++] = nums[j++];
        }
        while (i <= R1) temp[index++] = nums[i++];
        while (j <= R2) temp[index++] = nums[j++];
        for (i = 0; i < index; i++) nums[L1 + i] = temp[i];
    }
}
