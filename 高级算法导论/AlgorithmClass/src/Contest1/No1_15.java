package Contest1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No1_15 {
    public void No1_15() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            int[] new_nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
                new_nums[i] = nums[i];
            }
            // 重新排列数组
            Arrays.sort(new_nums);
            // 记录每一个元素出现的位置
            Map<Integer, Integer> num_pos = new HashMap<>();
            boolean[] vis = new boolean[N];
            for (int i = 0; i < new_nums.length; i++) {
                vis[i] = false;
                num_pos.put(new_nums[i], i);
            }
            // 遍历原数组的每一个值
            int loop = 0;
            for (int i = 0; i < nums.length; i++) {
                if (!vis[i]) {
                    int j = i;
                    while (!vis[j]) {
                        vis[j] = true;
                        j = num_pos.get(nums[j]);
                    }
                    loop++;
                }
            }
            System.out.println(N - loop);
        }
    }
}
