package QuestionBank;

import java.util.*;

public class No93RestoreIPAddresses {
    ArrayList<String> result = new ArrayList<>();
    int str_len = -1;

    public List<String> restoreIpAddresses(String s) {
        str_len = s.length();
        if (str_len < 4 || str_len > 12) return result;
        dfs(s, 0, 0, new StringBuilder());
        return result;
    }

    private void dfs(String s, int depth, int start, StringBuilder sb) {
        if (depth == 4) {
            result.add(sb.toString());
            return;
        }
        for (int i = 1; i <= 3; i++) {
            int rest_length = s.length() - start - i;
            if (rest_length < (3 - depth) || rest_length > 3 * (3 - depth)) continue;
            if (start + i <= s.length() && rightIPAddress(s, start, start + i)) {
                if (depth != 0) sb.append('.');
                sb.append(s, start, start + i);
                dfs(s, depth + 1, start + i, sb);
                if (depth != 0) sb.delete(sb.length() - i - 1, sb.length());
                else sb.delete(sb.length() - i, sb.length());
            }
        }
    }

    private boolean rightIPAddress(String s, int start, int end) {
        // 不能有前导0
        if (end - start > 1 && s.charAt(start) == '0') return false;
        // 查看数值是否在合理区间
        int num = Integer.parseInt(s.substring(start, end));
        return num >= 0 && num <= 255;
    }
}


// LeetCode 参考代码
/*
class Solution {
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
*/