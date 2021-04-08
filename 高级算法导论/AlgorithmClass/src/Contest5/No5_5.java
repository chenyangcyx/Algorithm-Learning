package Contest5;

import java.util.Arrays;
import java.util.Scanner;

public class No5_5 {
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[][] nums = new int[N][2];
            for (int i = 0; i < N; i++) {
                nums[i][0] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                nums[i][1] = sc.nextInt();
            }
            Arrays.sort(nums, (o1, o2) -> {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                else return o1[0] - o2[0];
            });
            for(int []nn:nums){
                System.out.println(nn[0]+" "+nn[1]);
            }
            int max_count = 1, count = 1, right = nums[0][1];
            for (int i = 1; i < N; i++) {
                if (nums[i][0] <= right) {
                    count++;
                    right = Math.min(right, nums[i][1]);
                    max_count = Math.max(max_count, count);
                } else {
                    count = 1;
                    right = nums[i][1];
                }
            }
            System.out.println(max_count);
        }
    }
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[][] nums = new int[N * 2][2];
            for (int i = 0; i < N * 2; i++) {
                nums[i][0] = sc.nextInt();
                nums[i][1] = (i < N ? 1 : -1);
            }
            Arrays.sort(nums, (o1, o2) -> {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                else return o1[0] - o2[0];
            });
            int max_count = -1, sum = 0;
            for (int[] nn : nums) {
                sum += nn[1];
                max_count = Math.max(max_count, sum);
            }
            System.out.println(max_count);
        }
    }
}


/*
// https://raw.githubusercontent.com/njuselw/AdvancedAlgorithm/master/src/FifthExercise/Problem0505.java
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem0505 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] arrive = new int[n];
            for (int j = 0; j < n; j++) {
                arrive[j] = scanner.nextInt();
            }
            int[] leave = new int[n];
            for (int j = 0; j < n; j++) {
                leave[j] = scanner.nextInt();
            }
            System.out.println(getMinPlatformNum(arrive, leave));
        }
    }

    public static int getMinPlatformNum(int[] arrive, int[] leave) {
        int n = arrive.length;
        //将车的到达记为1，离开记为-1
        //那么将数组排序后，整个过程中停留的车辆最多数量就是最小所需站台数
        int[][] a = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = arrive[i];
            a[i][1] = 1;
        }
        for (int i = 0; i < n; i++) {
            a[i + n][0] = leave[i];
            a[i + n][1] = -1;
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });
        int res = 0;
        int cur = 0;
        for (int i = 0; i < 2 * n; i++) {
            cur += a[i][1];
            res = Math.max(cur, res);
        }
        return res;
    }
}
*/