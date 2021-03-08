package Contest1;
import java.util.*;

public class No1_10 {
    public void No1_10() {
        Scanner sc = new Scanner(System.in);
        // 输入用例组数
        int T = sc.nextInt();
        // 对每一组进行处理
        for (int i = 0; i < T; i++) {
            // 输入N的值
            int N = sc.nextInt();
            int[] num = new int[N];
            // 输入数组的值
            for (int j = 0; j < N; j++) num[j] = sc.nextInt();
            int M = sc.nextInt();

            // 开始处理
            // 如果书本总数小于学生数，则无法分配
            if (N < M) System.out.println(-1);
            else {
                // 查找数组的最大值，及数组的总和
                int num_max = Integer.MIN_VALUE;
                int num_sum = 0;
                for (int _n : num) {
                    num_max = Integer.max(num_max, _n);
                    num_sum += _n;
                }
                // 以数组的最大值作为二分查找的left，总和作为right进行查找
                int left = num_max, right = num_sum;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    // 可以分的桶数>M，说明桶容量太小
                    if (getBucketNum(num, mid) > M) left = mid + 1;
                    else right = mid;
                }
                System.out.println(left);
            }
        }
    }

    // 统计在bucket_size情况下，能够分的桶数量
    private int getBucketNum(int[] nums, int bucket_size) {
        int num_sum = 0;
        int bucket_num = 1;
        for (int num : nums) {
            num_sum += num;
            if (num_sum > bucket_size) {
                bucket_num++;
                // 放不下了，放入一个新的桶
                num_sum = num;
            }
        }
        return bucket_num;
    }
}
