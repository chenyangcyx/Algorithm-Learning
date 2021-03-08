package Contest1;

import java.util.Scanner;

public class No1_18 {
    public void No1_18() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
                max = Integer.max(max, nums[i]);
                min = Integer.min(min, nums[i]);
            }
            // 初始化计数数组count
            int[] count = new int[max - min + 1];
            // 对计数数组的各元素赋值
            for (int num : nums) count[num - min]++;
            // 计数数组变形
            for (int i = 1; i < count.length; i++) count[i] += count[i - 1];
            // 创建结果数组
            int[] result = new int[N];
            // 遍历A中的元素，并找到对应的位置填充
            for (int i = 0; i < N; i++) {
                result[count[nums[i] - min] - 1] = nums[i];
                count[nums[i] - min]--;
            }
            // 输出结果
            for (int i = 0; i < N; i++) {
                if (i == 0) System.out.print(result[i]);
                else System.out.print(" " + result[i]);
            }
            System.out.println();
        }
    }
}
