package QuestionBank.No1_100;

import java.util.HashMap;

public class No1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) return new int[]{map.get(diff), i};
            map.put(nums[i], i);
        }
        return new int[2];
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}
