package CSNotes.Backtracking;

import java.util.*;

public class No93RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        dfs(s, 0, 0, s.length(), result, new StringBuilder());
        return result;
    }

    private void dfs(String s, int depth, int start, int end, ArrayList<String> result, StringBuilder sb) {
        if (depth == 4) {
            result.add(sb.toString());
            return;
        }
        for (int i = 1; i <= 3; i++) {
            int left_num = end - start - i;
            if (start + i <= end && rightIP(s, start, start + i) && (left_num >= (3 - depth)) && (left_num <= (3 - depth) * 3)) {
                if (depth != 0) sb.append('.');
                sb.append(s, start, start + i);
//                System.out.println("深度" + depth + "，string：" + sb.toString());
                dfs(s, depth + 1, start + i, end, result, sb);
                if (depth != 0) sb.delete(sb.length() - i - 1, sb.length());
                else sb.delete(sb.length() - i, sb.length());
            }
        }
    }

    private boolean rightIP(String s, int start, int end) {
        if (end - start == 1) return true;
        else return Integer.parseInt(s.substring(start, end)) <= 255 && s.charAt(start) != '0';
    }

    // CS-Note 参考代码
    public List<String> restoreIpAddresses2(String s) {
        List<String> addresses = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        doRestore(0, tempAddress, addresses, s);
        return addresses;
    }

    private void doRestore(int k, StringBuilder tempAddress, List<String> addresses, String s) {
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                addresses.add(tempAddress.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                if (tempAddress.length() != 0) {
                    part = "." + part;
                }
                tempAddress.append(part);
                doRestore(k + 1, tempAddress, addresses, s.substring(i + 1));
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
            }
        }
    }
}
