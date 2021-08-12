package QuestionBank.No1_100;

import java.util.*;

public class No47PermutationsII {
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        used = new boolean[nums.length];
        dfs(nums, nums.length, 0, result);
//        for (List<Integer> _list : result) {
//            System.out.println(Arrays.toString(_list.toArray()));
//        }
        return result;
    }

    private void dfs(int[] nums, int length, int depth, List<List<Integer>> result) {
        if (depth == length) {
            result.add(new ArrayList<>(path));
            return;
        }
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (vis.getOrDefault(nums[i], false)) {
//                System.out.println(nums[i]+"已经被用，跳过！");
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path.addLast(nums[i]);
                vis.put(nums[i], true);
                dfs(nums, length, depth + 1, result);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}

// LeetCode 题解
class Solution1 {
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}