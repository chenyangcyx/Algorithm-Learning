package CSNotes.Backtracking;

import java.util.*;

public class No40CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, result, new LinkedList<>());
        return result;
    }

    private void dfs(int[] nums, int target, int sum, int index, List<List<Integer>> result, LinkedList<Integer> path) {
//        System.out.println("现在的path："+path.toString()+"，现在的index："+index);
        if (sum == target) {
            result.add(new LinkedList<>(path));
            return;
        }
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (int i = index; i < nums.length; i++) {
            if (sum + nums[i] > target || vis.getOrDefault(nums[i], false)) continue;
            sum += nums[i];
            path.addLast(nums[i]);
            vis.put(nums[i], true);
            dfs(nums, target, sum, i + 1, result, path);
            path.pollLast();
            sum -= nums[i];
        }
    }

    // CS-Note 参考代码
    public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(new ArrayList<>(), combinations, new boolean[candidates.length], 0, target, candidates);
        return combinations;
    }

    private void backtracking(List<Integer> tempCombination, List<List<Integer>> combinations,
                              boolean[] hasVisited, int start, int target, final int[] candidates) {

        if (target == 0) {
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            if (candidates[i] <= target) {
                tempCombination.add(candidates[i]);
                hasVisited[i] = true;
                backtracking(tempCombination, combinations, hasVisited, i + 1, target - candidates[i], candidates);
                hasVisited[i] = false;
                tempCombination.remove(tempCombination.size() - 1);
            }
        }
    }
}
