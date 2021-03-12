package CSNotes.Backtracking;

import java.util.*;

public class No90SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        dfs(nums, 0, result, new LinkedList<>());
        return result;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> result, LinkedList<Integer> path) {
        result.add(new LinkedList<>(path));
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (int i = index; i < nums.length; i++) {
            if (!vis.getOrDefault(nums[i], false)) {
                path.addLast(nums[i]);
                vis.put(nums[i], true);
                dfs(nums, i + 1, result, path);
                path.pollLast();
            }
        }
    }

    // CS-Note 参考代码
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        for (int size = 0; size <= nums.length; size++) {
            backtracking(0, tempSubset, subsets, hasVisited, size, nums); // 不同的子集大小
        }
        return subsets;
    }

    private void backtracking(int start, List<Integer> tempSubset, List<List<Integer>> subsets, boolean[] hasVisited,
                              final int size, final int[] nums) {

        if (tempSubset.size() == size) {
            subsets.add(new ArrayList<>(tempSubset));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            tempSubset.add(nums[i]);
            hasVisited[i] = true;
            backtracking(i + 1, tempSubset, subsets, hasVisited, size, nums);
            hasVisited[i] = false;
            tempSubset.remove(tempSubset.size() - 1);
        }
    }
}
