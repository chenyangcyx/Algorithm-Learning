package QuestionBank;

import java.util.LinkedList;
import java.util.Scanner;

public class 公约数 {
    int result = 0;
    boolean[] used;

    public void 公约数() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), K = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        used = new boolean[n];
        dfs(new LinkedList<>(), nums, 0, K, A, B);
        System.out.println(result);
    }

    private void dfs(LinkedList<Integer> path, int[] nums, int index, int K, int A, int B) {
        if (path.size() == K) {
            if (gcdResult(path, A) >= B) result++;
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.addLast(nums[i]);
                dfs(path, nums, i + 1, K, A, B);
                used[i] = false;
                path.pollLast();
            }
        }
    }

    private int gcdResult(LinkedList<Integer> path, int A) {
        int t = 1;
        for (int num : path) {
            t = gcd(num * t, A);
        }
        return t;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
