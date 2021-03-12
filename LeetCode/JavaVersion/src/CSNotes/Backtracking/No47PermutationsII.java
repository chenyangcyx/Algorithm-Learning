package CSNotes.Backtracking;

import java.util.*;

public class No47PermutationsII {
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        used = new boolean[nums.length];
        dfs(nums, nums.length, 0, result, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int length, int depth, List<List<Integer>> result, ArrayList<Integer> path) {
        if (length == depth) {
            result.add(new ArrayList<>(path));
            return;
        }
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (!used[i] && !vis.getOrDefault(nums[i], false)) {
                path.add(nums[i]);
                used[i] = true;
                vis.put(nums[i], true);
                dfs(nums, length, depth + 1, result, path);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    // CS-Note 参考代码
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        Arrays.sort(nums);  // 排序
        boolean[] hasVisited = new boolean[nums.length];
        backtracking(permuteList, permutes, hasVisited, nums);
        return permutes;
    }

    private void backtracking(List<Integer> permuteList, List<List<Integer>> permutes, boolean[] visited, final int[] nums) {
        if (permuteList.size() == nums.length) {
            permutes.add(new ArrayList<>(permuteList));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;  // 防止重复
            }
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            permuteList.add(nums[i]);
            backtracking(permuteList, permutes, visited, nums);
            permuteList.remove(permuteList.size() - 1);
            visited[i] = false;
        }
    }
}
