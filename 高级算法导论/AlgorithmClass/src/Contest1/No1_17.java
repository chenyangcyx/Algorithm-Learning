package Contest1;

import java.util.Scanner;

public class No1_17 {
    public void No1_17() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < N - 1 - i; j++) {
                    if (nums[j] > nums[j + 1]) {
                        nums[j] = nums[j] ^ nums[j + 1];
                        nums[j + 1] = nums[j] ^ nums[j + 1];
                        nums[j] = nums[j] ^ nums[j + 1];
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                if (i == 0) System.out.print(nums[i]);
                else System.out.print(" " + nums[i]);
            }
            System.out.println();
        }
    }
}
