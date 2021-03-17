package QuestionBank;

public class No115DistinctSubsequences {
    int des_count = 0;
    int result_count = 0;

    public int numDistinct(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || t.length() > s.length()) return 0;
        des_count = t.length();
        dfs(s, t, 0, new StringBuilder());
        System.out.println(result_count);
        return result_count;
    }

    private void dfs(String s, String t, int start, StringBuilder sb) {
        if (sb.length() == des_count && sb.toString().equals(t)) {
            result_count++;
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(sb.length())) continue;
            sb.append(s.charAt(i));
            System.out.println(sb.toString());
            dfs(s, t, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // LeetCode 参考代码
    public int numDistinct2(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int[] f = new int[tlen + 1];
        f[0] = 1;
        for (int i = 1; i <= slen; i++)
            for (int j = tlen; j >= 1; j--)
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    f[j] += f[j - 1];
        return f[tlen];
    }

    // LeetCode 参考代码2
    public int numDistinct3(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
