package CSNotes.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        dfs(s, 0, s.length(), result, new LinkedList<>());
//        dfs(s, result, new LinkedList<>());
        return result;
    }

    private void dfs(String s, int start, int end, List<List<String>> result, LinkedList<String> path) {
        if (start >= end) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 1; i <= end - start; i++) {
            if (isHuiwen(s, start, start + i)) {
                path.addLast(s.substring(start, start + i));
//                System.out.println("添加："+s.substring(start,start+i));
                dfs(s, start + i, end, result, path);
                path.pollLast();
            }
        }
    }

    private void dfs(String s, List<List<String>> result, LinkedList<String> path) {
        if (s.length() == 0) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (isHuiwen(s, 0, i + 1)) {
                path.addLast(sub);
//                System.out.println("添加："+sub);
                dfs(s.substring(i + 1), result, path);
                path.pollLast();
            }
        }
    }

    private boolean isHuiwen(String s, int start, int end) {
        int i = start, j = end - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    // CS-Note 参考代码
    public List<List<String>> partition2(String s) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> tempPartition = new ArrayList<>();
        doPartition(s, partitions, tempPartition);
        return partitions;
    }

    private void doPartition(String s, List<List<String>> partitions, List<String> tempPartition) {
        if (s.length() == 0) {
            partitions.add(new ArrayList<>(tempPartition));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                tempPartition.add(s.substring(0, i + 1));
                doPartition(s.substring(i + 1), partitions, tempPartition);
                tempPartition.remove(tempPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
