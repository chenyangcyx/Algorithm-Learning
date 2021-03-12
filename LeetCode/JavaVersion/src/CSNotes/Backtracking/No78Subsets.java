package CSNotes.Backtracking;

import java.util.*;

public class No78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(nums, 0, result, new LinkedList<>());
        return result;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> result, LinkedList<Integer> path) {
        result.add(new LinkedList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfs(nums, i + 1, result, path);
            path.pollLast();
        }
    }

    // CS-Note 参考代码
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        for (int size = 0; size <= nums.length; size++) {
            backtracking(0, tempSubset, subsets, size, nums); // 不同的子集大小
        }
        return subsets;
    }

    private void backtracking(int start, List<Integer> tempSubset, List<List<Integer>> subsets,
                              final int size, final int[] nums) {

        if (tempSubset.size() == size) {
            subsets.add(new ArrayList<>(tempSubset));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tempSubset.add(nums[i]);
            backtracking(i + 1, tempSubset, subsets, size, nums);
            tempSubset.remove(tempSubset.size() - 1);
        }
    }
}
