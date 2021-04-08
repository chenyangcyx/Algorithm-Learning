package Contest5;

import java.util.LinkedList;
import java.util.Scanner;

public class No5_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt(), total = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
            System.out.println(getMinDepth(total, nums, N));
        }
    }

    private static int getMinDepth(int total, int[] nums, int N) {
        int depth = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(total);
        while (!queue.isEmpty()) {
            depth++;
            int queue_size = queue.size();
            for (int i = 0; i < queue_size; i++) {
                int node = queue.pollFirst();
                for (int j = N - 1; j >= 0; j--) {
                    int diff = node - nums[j];
                    if (diff == 0) return depth;
                    else if (diff > 0) queue.addLast(diff);
                }
            }
        }
        return -1;
    }
}


/*
// https://raw.githubusercontent.com/njuselw/AdvancedAlgorithm/master/src/FifthExercise/Problem0503.java
import java.util.Arrays;
import java.util.Scanner;

public class Problem0503 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int amount = scanner.nextInt();
            int[] coins = new int[n];
            for (int j = 0; j < n; j++) {
                coins[j] = scanner.nextInt();
            }
            System.out.println(getMinCoinCnt(coins, amount));
        }
    }

    //这不是无限量的背包问题吗
    //dp[i]表示拿i钱所需的最小钞票数
    public static int getMinCoinCnt(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) { //显然如果这个钞票的面额超过所需钱数，就无法拿来凑
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] >= amount + 1 ? -1 : dp[amount];
    }
}
 */