package Contest5;

import java.util.Arrays;
import java.util.Scanner;

public class No5_1 {
    // 定义方向变量
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[][] nums = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }
            int[][] min_length = new int[N][N];
            for (int[] nn : min_length) Arrays.fill(nn, Integer.MAX_VALUE);
            dfs(0, 0, N, nums, min_length, nums[0][0]);
            System.out.println(min_length[N - 1][N - 1]);
        }
    }

    static void dfs(int x, int y, int N, int[][] nums, int[][] min_length, int cur) {
        for (int[] di : dir) {
            int xx = x + di[0];
            int yy = y + di[1];
            if (xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
            if (nums[xx][yy] + cur < min_length[xx][yy]) {
                min_length[xx][yy] = nums[xx][yy] + cur;
//                System.out.println("将"+xx+" "+yy+"改成："+min_length[xx][yy]);
                dfs(xx, yy, N, nums, min_length, min_length[xx][yy]);
            }
        }
    }
}
