package Contest1;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class No1_7 {
    public void No1_7() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
            int increament = 1;
            for (int i = 0; i < N; ) {
                printArray(nums, i, Integer.min(i + increament, N));
                i += increament;
                increament *= 2;
            }
        }
    }

    private static void printArray(int[] nums, int start, int end) {
        Arrays.sort(nums, start, end);
        LinkedHashSet<Integer> set=new LinkedHashSet<>();
        for(int i=start;i<end;i++) set.add(nums[i]);
        Object[] newnum=set.toArray();
        for (int i = 0; i < newnum.length; i++) {
            if (i == 0) System.out.print((int)newnum[i]);
            else System.out.print(" " + (int)newnum[i]);
        }
        System.out.println();
    }
}
