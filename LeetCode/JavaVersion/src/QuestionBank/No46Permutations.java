package QuestionBank;

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
}
