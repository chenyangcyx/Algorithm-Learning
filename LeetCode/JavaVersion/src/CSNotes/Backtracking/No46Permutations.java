package CSNotes.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class No46Permutations {
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
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
        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, length, depth + 1, result, path);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    // CS-Note 参考代码
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        backtracking(permuteList, permutes, hasVisited, nums);
        return permutes;
    }

    private void backtracking(List<Integer> permuteList, List<List<Integer>> permutes, boolean[] visited, final int[] nums) {
        if (permuteList.size() == nums.length) {
            permutes.add(new ArrayList<>(permuteList)); // 重新构造一个 List
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
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
