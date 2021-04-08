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
