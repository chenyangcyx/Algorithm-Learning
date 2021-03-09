package Contest1;

import java.util.Scanner;

public class No1_5 {
    public void No1_5() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            int[] nums = new int[N];
            int max = Integer.MIN_VALUE, sum = 0;
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
                max = Integer.max(max, nums[i]);
                sum += nums[i];
            }
            int left = max, right = sum;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (getBucketCount(nums, mid) > K) left = mid + 1;
                else right = mid;
            }
            System.out.println(left);
        }
    }

    private int getBucketCount(int[] nums, int size) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > size) {
                count++;
                sum = num;
            }
        }
        return count;
    }
}
