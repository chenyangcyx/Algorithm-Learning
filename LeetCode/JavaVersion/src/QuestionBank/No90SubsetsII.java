package QuestionBank;

import java.util.*;

public class No90SubsetsII {
    List<List<Integer>> result = new ArrayList<>();
    int length = -1;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        length = nums.length;
        Arrays.sort(nums);
        dfs(nums, 0, new LinkedList<>());
        return result;
    }

    private void dfs(int[] nums, int start, LinkedList<Integer> path) {
        result.add(new ArrayList<>(path));
        HashSet<Integer> used = new HashSet<>();
        for (int i = start; i < length; i++) {
            if (used.add(nums[i])) {
                path.addLast(nums[i]);
                dfs(nums, i + 1, path);
                path.pollLast();
            }
        }
    }
}


// LeetCode 参考代码1
/*
class Solution {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            boolean flag = true;
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    t.add(nums[i]);
                }
            }
            if (flag) {
                ans.add(new ArrayList<Integer>(t));
            }
        }
        return ans;
    }
}
*/


// LeetCode 参考代码2
/*
class Solution {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    public void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        dfs(false, cur + 1, nums);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        t.add(nums[cur]);
        dfs(true, cur + 1, nums);
        t.remove(t.size() - 1);
    }
}
*/