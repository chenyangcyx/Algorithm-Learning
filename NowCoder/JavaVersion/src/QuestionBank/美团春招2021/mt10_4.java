package QuestionBank.美团春招2021;

import java.io.*;
import java.util.Arrays;

public class mt10_4 {
    static int n;
    static int[] weight;
    static int[][][] mem;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
        String[] sp = reader.readLine().split(" ");
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(sp[i]);
        }
        mem = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(mem[i][j], -1);
            }
        }
        writer.write(String.valueOf(dp(0, n - 1, -1)));
        writer.flush();
    }

    static int dp(int left, int right, int root) {
        if (right < left) {
            return 0;
        }
        if (root >= 0 && mem[left][right][root] != -1) {
            return mem[left][right][root];
        }
        int cost = Integer.MAX_VALUE;
        int leftCost = 0, rightCost = 0;
        for (int i = left; i <= right; i++) {
            leftCost = dp(left, i - 1, i);
            rightCost = dp(i + 1, right, i);
            cost = Math.min(cost, leftCost + rightCost + weight[i] * (root != -1 ? weight[root] : 0));
        }
        if (root >= 0) {
            mem[left][right][root] = cost;
        }
        return cost;
    }
}
