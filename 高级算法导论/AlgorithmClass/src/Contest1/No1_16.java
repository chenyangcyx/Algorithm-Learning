package Contest1;

import java.util.Scanner;

public class No1_16 {
    public void No1_16() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
            for (int i = 1; i < N; i++) {
                int temp = nums[i];
                // 与前面的元素逐个比较
                int j = i;
                while (j >= 1 && temp < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                    j--;
                }
                nums[j] = temp;
            }
            for (int i = 0; i < N; i++) {
                if (i == 0) System.out.print(nums[i]);
                else System.out.print(" " + nums[i]);
            }
            System.out.println();
        }
    }
}
