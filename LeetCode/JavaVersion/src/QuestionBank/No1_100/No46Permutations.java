package QuestionBank.No1_100;

import java.util.*;

public class No46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0) return result;
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[length];
        dfs(nums, length, 0, path, used, result);
        return result;
    }

    private void dfs(int[] nums, int length, int depth, LinkedList<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (depth == length) {
            // 注意不能直接传入引用，否则会变为空
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
//                System.out.println("排列前：" + path.toString());
                dfs(nums, length, depth + 1, path, used, result);
                path.pollLast();
                used[i] = false;
//                System.out.println("排列后：" + path.toString());
            }
        }
    }

    // LeetCode 参考代码
    class Solution1 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();

            List<Integer> output = new ArrayList<Integer>();
            for (int num : nums) {
                output.add(num);
            }

            int n = nums.length;
            backtrack(n, output, res, 0);
            return res;
        }

        public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
            // 所有数都填完了
            if (first == n) {
                res.add(new ArrayList<Integer>(output));
            }
            for (int i = first; i < n; i++) {
                // 动态维护数组
                Collections.swap(output, first, i);
                // 继续递归填下一个数
                backtrack(n, output, res, first + 1);
                // 撤销操作
                Collections.swap(output, first, i);
            }
        }
    }
}
