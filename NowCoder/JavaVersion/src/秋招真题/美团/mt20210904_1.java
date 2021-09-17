package 秋招真题.美团;

import java.io.*;

public class mt20210904_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        if (n == 1) {
            writer.write(String.valueOf(2));
        } else if (n == 2) {
            writer.write(String.valueOf(4));
        } else {
            int[] dp = new int[n + 1];
            dp[1] = 2;
            dp[2] = 4;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % 998244353;
            }
            writer.write(String.valueOf(dp[n]));
            writer.newLine();
        }
        writer.flush();
    }
}
