package CSNotes.Backtracking;

import java.util.*;

public class No39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, target, 0, result, new LinkedList<>());
        return result;
    }

    private void dfs(int[] nums, int sum, int target, int index, List<List<Integer>> result, LinkedList<Integer> path) {
        if (sum == target) {
            result.add(new LinkedList<>(path));
            return;
        } else if (sum > target) return;

        for (int i = index; i < nums.length; i++) {
            sum += nums[i];
            path.addLast(nums[i]);
            dfs(nums, sum, target, i, result, path);
            sum -= nums[i];
            path.pollLast();
        }
    }

    // CS-Note 参考代码
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(new ArrayList<>(), combinations, 0, target, candidates);
        return combinations;
    }

    private void backtracking(List<Integer> tempCombination, List<List<Integer>> combinations,
                              int start, int target, final int[] candidates) {

        if (target == 0) {
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                tempCombination.add(candidates[i]);
                backtracking(tempCombination, combinations, i, target - candidates[i], candidates);
                tempCombination.remove(tempCombination.size() - 1);
            }
        }
    }
}
