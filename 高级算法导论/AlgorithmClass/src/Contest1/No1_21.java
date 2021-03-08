package Contest1;

import java.util.Scanner;

public class No1_21 {
    int count = 0;

    public void No1_21() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            count=0;
            int N = sc.nextInt();
            if(N==0){
                System.out.println(0);
                continue;
            }
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
            mergeSort(nums,0, nums.length-1);
            System.out.println(count);
        }
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, mid + 1, right);
        }
    }

    private void merge(int[] nums, int L1, int R1, int L2, int R2) {
        int i = L1, j = L2;
        int[] temp = new int[nums.length];
        int index = 0;
        while (i <= R1 && j <= R2) {
            if (nums[i] <= nums[j]) temp[index++] = nums[i++];
            else {
                count += R1 - i + 1;
                temp[index++] = nums[j++];
            }
        }
        while (i <= R1) temp[index++] = nums[i++];
        while (j <= R2) temp[index++] = nums[j++];
        for (i = 0; i < index; i++) nums[L1 + i] = temp[i];
    }
}
