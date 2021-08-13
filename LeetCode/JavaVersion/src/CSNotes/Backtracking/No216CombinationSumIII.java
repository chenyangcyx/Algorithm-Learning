package CSNotes.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No216CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        if (k == 0 || n == 0) return result;
        dfs(k, n, 0, 0, 1, result, new LinkedList<>());
        return result;
    }

    private void dfs(int k, int n, int count, int sum, int index, List<List<Integer>> result, LinkedList<Integer> path) {
        if (count > k) return;
        if (count == k && sum == n) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i <= 9; i++) {
            if (sum + i > n) continue;
            sum += i;
            path.addLast(i);
            dfs(k, n, count + 1, sum, i + 1, result, path);
            sum -= i;
            path.pollLast();
        }
    }

    // CS-Note 参考代码
    public List<List<Integer>> combinationSum3_2(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(k, n, 1, path, combinations);
        return combinations;
    }

    private void backtracking(int k, int n, int start,
                              List<Integer> tempCombination, List<List<Integer>> combinations) {

        if (k == 0 && n == 0) {
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        if (k == 0 || n == 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            tempCombination.add(i);
            backtracking(k - 1, n - i, i + 1, tempCombination, combinations);
            tempCombination.remove(tempCombination.size() - 1);
        }
    }
}
