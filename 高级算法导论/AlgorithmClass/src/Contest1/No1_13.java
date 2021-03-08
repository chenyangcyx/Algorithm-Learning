package Contest1;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class No1_13 {
    public void No1_13() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            // 输入数据
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] nums = new int[N];
            for (int _n = 0; _n < N; _n++) nums[_n] = sc.nextInt();
            // 将nums排序
            Arrays.sort(nums);
            // 用来存储结果的Set
            Set<String> result = new LinkedHashSet<>();
            // 双重循环
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    // 问题在此处被简化为找两个数和为K-nums[a]-nums[b]
                    int target = K - nums[i] - nums[j];
                    int left = j + 1, right = nums.length - 1;
                    while (left < right) {
                        int two_sum = nums[left] + nums[right];
                        if (two_sum == target)
                            result.add(nums[i] + " " + nums[j] + " " + nums[left] + " " + nums[right] + " $");
                        if (two_sum <= target) left++;
                        else right--;
                    }
                }
            }
            for (String str : result) {
                System.out.print(str);
            }
            System.out.println();
        }
    }
}
