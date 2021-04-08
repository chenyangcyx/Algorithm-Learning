package Contest5;

import java.util.LinkedList;
import java.util.Scanner;

public class No5_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt(), total = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
            System.out.println(getMinDepth(total, nums, N));
        }
    }

    private static int getMinDepth(int total, int[] nums, int N) {
        int depth = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(total);
        while (!queue.isEmpty()) {
            depth++;
            int queue_size = queue.size();
            for (int i = 0; i < queue_size; i++) {
                int node = queue.pollFirst();
                for (int j = N - 1; j >= 0; j--) {
                    int diff = node - nums[j];
                    if (diff == 0) return depth;
                    else if (diff > 0) queue.addLast(diff);
                }
            }
        }
        return -1;
    }
}
