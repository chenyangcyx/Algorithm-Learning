package QuestionBank.No101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No131PalindromePartitioning {
    public static void main(String[] args) {
        No131PalindromePartitioning no131PalindromePartitioning = new No131PalindromePartitioning();

        String s1 = "aab";
        String s2 = "a";

        System.out.println(no131PalindromePartitioning.partition(s1));
        System.out.println(no131PalindromePartitioning.partition(s2));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        dfs(result, s, 0, new LinkedList<>());
        return result;
    }

    void dfs(List<List<String>> result, String s, int index, LinkedList<String> path) {
        if (index == s.length()) {
            result.add(new LinkedList<>(path));
        }
        for (int i = index + 1; i <= s.length(); i++) {
            if (isHuiwen(s.substring(index, i))) {
                path.addLast(s.substring(index, i));
                dfs(result, s, i, path);
                path.pollLast();
            }
        }
    }

    private boolean isHuiwen(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // LeetCode 题解1：回溯 + 动态规划预处理
    class Solution1 {
        boolean[][] f;
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> ans = new ArrayList<String>();
        int n;

        public List<List<String>> partition(String s) {
            n = s.length();
            f = new boolean[n][n];
            for (int i = 0; i < n; ++i) {
                Arrays.fill(f[i], true);
            }

            for (int i = n - 1; i >= 0; --i) {
                for (int j = i + 1; j < n; ++j) {
                    f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
                }
            }

            dfs(s, 0);
            return ret;
        }

        public void dfs(String s, int i) {
            if (i == n) {
                ret.add(new ArrayList<String>(ans));
                return;
            }
            for (int j = i; j < n; ++j) {
                if (f[i][j]) {
                    ans.add(s.substring(i, j + 1));
                    dfs(s, j + 1);
                    ans.remove(ans.size() - 1);
                }
            }
        }
    }

    // LeetCode 题解2：回溯 + 记忆化搜索
    class Solution2 {
        int[][] f;
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> ans = new ArrayList<String>();
        int n;

        public List<List<String>> partition(String s) {
            n = s.length();
            f = new int[n][n];

            dfs(s, 0);
            return ret;
        }

        public void dfs(String s, int i) {
            if (i == n) {
                ret.add(new ArrayList<String>(ans));
                return;
            }
            for (int j = i; j < n; ++j) {
                if (isPalindrome(s, i, j) == 1) {
                    ans.add(s.substring(i, j + 1));
                    dfs(s, j + 1);
                    ans.remove(ans.size() - 1);
                }
            }
        }

        // 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
        public int isPalindrome(String s, int i, int j) {
            if (f[i][j] != 0) {
                return f[i][j];
            }
            if (i >= j) {
                f[i][j] = 1;
            } else if (s.charAt(i) == s.charAt(j)) {
                f[i][j] = isPalindrome(s, i + 1, j - 1);
            } else {
                f[i][j] = -1;
            }
            return f[i][j];
        }
    }
}
