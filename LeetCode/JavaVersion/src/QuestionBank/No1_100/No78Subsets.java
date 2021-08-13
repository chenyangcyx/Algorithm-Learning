package QuestionBank.No1_100;

import java.util.*;

public class No78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
//        dfs(result, nums, 0, new LinkedList<>());
        dfs2(result, nums, 0, new LinkedList<>());
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, int index, LinkedList<Integer> path) {
        if (index == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }
        path.addLast(nums[index]);
        dfs(result, nums, index + 1, path);
        path.pollLast();
        dfs(result, nums, index + 1, path);
    }

    private void dfs2(List<List<Integer>> result, int[] nums, int index, LinkedList<Integer> path) {
        result.add(new LinkedList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfs2(result, nums, i + 1, path);
            path.pollLast();
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int flag = 0; flag <= Math.pow(2, nums.length) - 1; flag++) {
            LinkedList<Integer> temp = new LinkedList<>();
            for (int pos = 0; pos < nums.length; pos++) {
                if (((flag >> pos) & 1) == 1) {
                    temp.addLast(nums[pos]);
                }
            }
            result.add(new LinkedList<>(temp));
        }
        return result;
    }

    public static void main(String[] args) {
        No78Subsets no78Subsets = new No78Subsets();

        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{0};

        List<List<Integer>> result1 = no78Subsets.subsets(nums1);
        System.out.println(result1);

        List<List<Integer>> result2 = no78Subsets.subsets(nums2);
        System.out.println(result2);

        System.out.println(no78Subsets.subsets2(nums1));
        System.out.println(no78Subsets.subsets2(nums2));
    }

    // LeetCode 题解1：迭代法
    class Solution1 {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            for (int mask = 0; mask < (1 << n); ++mask) {
                t.clear();
                for (int i = 0; i < n; ++i) {
                    if ((mask & (1 << i)) != 0) {
                        t.add(nums[i]);
                    }
                }
                ans.add(new ArrayList<Integer>(t));
            }
            return ans;
        }
    }

    // LeetCode 题解2：递归
    class Solution2 {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(0, nums);
            return ans;
        }

        public void dfs(int cur, int[] nums) {
            if (cur == nums.length) {
                ans.add(new ArrayList<Integer>(t));
                return;
            }
            t.add(nums[cur]);
            dfs(cur + 1, nums);
            t.remove(t.size() - 1);
            dfs(cur + 1, nums);
        }
    }
}
