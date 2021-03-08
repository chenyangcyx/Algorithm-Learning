package Contest1;

import java.util.Arrays;
import java.util.Scanner;

public class No1_14 {
    // 写法1
    public void No1_14() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            sc.nextLine();
            String _str = sc.nextLine();
            String[] split = _str.split(" ");
            int[] nums = new int[split.length];
            for (int i = 0; i < split.length; i++) nums[i] = Integer.parseInt(split[i]);
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) System.out.print(nums[i]);
                else System.out.print(" " + nums[i]);
            }
            System.out.println();
        }
    }

    // 写法2
    public void No1_14_2() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            sc.nextLine();
            String _str = sc.nextLine();
            String[] split = _str.split(" ");
            int[] nums = new int[split.length];
            for (int i = 0; i < split.length; i++) nums[i] = Integer.parseInt(split[i]);
            // 开始排序
            for (int i = N; i < nums.length; i++) {
                // 找到插入的位置
                int pos = i - 1;
                while (pos >= 0 && nums[pos] >= nums[i]) pos--;
                pos++;
                int tmp = nums[i];
                // 将pos-i位置的数都向后移1个位置
                for (int j = i; j >= pos + 1; j--) nums[j] = nums[j - 1];
                nums[pos] = tmp;
            }
            // 结果输出
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) System.out.print(nums[i]);
                else System.out.print(" " + nums[i]);
            }
            System.out.println();
        }
    }
}
