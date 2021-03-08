package Contest1;

import java.util.Scanner;

public class No1_22 {
    public void No1_22() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            String str = sc.nextLine();
            String[] split = str.split(" ");
            int[] nums = new int[split.length];
            for (int i = 0; i < split.length; i++) nums[i] = Integer.parseInt(split[i]);
            str = sc.nextLine();
            split = str.split(" ");
            int[] nums2 = new int[split.length];
            for (int i = 0; i < split.length; i++) nums2[i] = Integer.parseInt(split[i]);

            for (int i = 0; i < nums2.length; i++) {
                int increament = nums2[i];
                for (int j = increament; j < nums.length; j++) {
                    if (nums[j - increament] > nums[j]) {
                        int temp = nums[j];
                        int t = j - increament;
                        while (t >= 0 && nums[t] > temp) {
                            nums[t + increament] = nums[t];
                            t -= increament;
                        }
                        nums[t + increament] = temp;
                    }
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (i == 0) System.out.print(nums[i]);
                else System.out.print(" " + nums[i]);
            }
            System.out.println();
        }
    }
}
