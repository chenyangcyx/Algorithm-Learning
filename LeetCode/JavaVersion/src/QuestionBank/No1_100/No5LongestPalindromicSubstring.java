package QuestionBank.No1_100;

import java.util.ArrayList;
import java.util.List;

public class No5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        char[] array = s.toCharArray();
        int max_length_s = Integer.MIN_VALUE;
        int max_length_e = Integer.MIN_VALUE;
        int max_length = Integer.MIN_VALUE;
        for (int i = 0; i <= s.length() - 1; i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (ifHuiwen(array, i, j)) {
                    if (j - i + 1 > max_length) {
                        max_length = j - i + 1;
                        max_length_s = i;
                        max_length_e = j;
                    }
                }
            }
        }
        return s.substring(max_length_s, max_length_e + 1);
    }

    private boolean ifHuiwen(char[] array, int start, int end) {
        while (start < end) {
            if (array[start] != array[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    // LeetCode 参考代码1
    // 动态规划
    public String longestPalindrome_2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i + k < n; ++i) {
                int j = i + k;
                if (k == 0) {
                    dp[i][j] = true;
                } else if (k == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && k + 1 > ans.length()) {
                    ans = s.substring(i, i + k + 1);
                }
            }
        }
        return ans;
    }

    // LeetCode 参考代码2
    // 中心扩展法
    public String longestPalindrome_3(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    // LeetCode 参考代码3
    // Manacher 算法
    public String longestPalindrome_4(String s) {
        int start = 0, end = -1;
        StringBuffer t = new StringBuffer("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        s = t.toString();

        List<Integer> arm_len = new ArrayList<Integer>();
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); ++i) {
            int cur_arm_len;
            if (right >= i) {
                int i_sym = j * 2 - i;
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }
}
