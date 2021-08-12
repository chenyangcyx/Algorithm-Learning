package QuestionBank.No1_100;

import java.util.*;

public class No77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, n, k, 1, 0, new LinkedList<>());
        return result;
    }

    void dfs(List<List<Integer>> result, int n, int k, int index, int depth, LinkedList<Integer> path) {
        if (depth == k) {
            result.add(new LinkedList<>(path));
        }
        for (int i = index; i <= n; i++) {
            path.addLast(i);
            dfs(result, n, k, i + 1, depth + 1, path);
            path.pollLast();
        }


        // LeetCode 题解
        class Solution1 {
            List<Integer> temp = new ArrayList<Integer>();
            List<List<Integer>> ans = new ArrayList<List<Integer>>();

            public List<List<Integer>> combine(int n, int k) {
                dfs(1, n, k);
                return ans;
            }

            public void dfs(int cur, int n, int k) {
                // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
                if (temp.size() + (n - cur + 1) < k) {
                    return;
                }
                // 记录合法的答案
                if (temp.size() == k) {
                    ans.add(new ArrayList<Integer>(temp));
                    return;
                }
                // 考虑选择当前位置
                temp.add(cur);
                dfs(cur + 1, n, k);
                temp.remove(temp.size() - 1);
                // 考虑不选择当前位置
                dfs(cur + 1, n, k);
            }
        }
    }
}