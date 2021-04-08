package Contest5;

import java.util.HashMap;
import java.util.Scanner;

public class No5_2 {
    static int max_count = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N1 = sc.nextInt(), N2 = sc.nextInt();
            int max_N = Math.max(N1, N2);
            int[][] road = new int[2][max_N];
            HashMap<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
            for (int i = 0; i < N1; i++) {
                road[0][i] = sc.nextInt();
                map1.put(road[0][i], i);
            }
            for (int i = 0; i < N2; i++) {
                road[1][i] = sc.nextInt();
                map2.put(road[1][i], i);
            }
            dfs(0, 0, N1, N2, road, map1, map2, road[0][0]);
            dfs(1, 0, N1, N2, road, map1, map2, road[1][0]);
            System.out.println(max_count);
        }
    }

    private static void dfs(int x, int y, int N1, int N2, int[][] road, HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2, int count) {
//        System.out.println("当前坐标："+x+", "+y+"，值："+count);
        if ((x == 0 && y >= N1) || (x == 1 && y >= N2)) return;
        if ((x == 0 && y == N1 - 1) || (x == 1 && y == N2 - 1)) {
            max_count = Math.max(max_count, count);
            return;
        }
        // 正常情况，一直走下去
        dfs(x, y + 1, N1, N2, road, map1, map2, count + road[x][y + 1]);
        if (x == 0 && map2.containsKey(road[x][y])) {
            dfs(1, map2.get(road[x][y]) + 1, N1, N2, road, map1, map2, count + road[1][map2.get(road[x][y]) + 1]);
        }
        if (x == 1 && map1.containsKey(road[x][y])) {
            dfs(0, map1.get(road[x][y]) + 1, N1, N2, road, map1, map2, count + road[0][map1.get(road[x][y]) + 1]);
        }
    }
}


/*
// https://github.com/njuselw/AdvancedAlgorithm/blob/master/src/FifthExercise/Problem0502.java
import java.util.Scanner;

public class Problem0502 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            int[] b = new int[m];
            for (int j = 0; j < m; j++) {
                b[j] = scanner.nextInt();
            }
            System.out.println(getMaxBallCnt(a, b));
        }
    }

    //a: 1 4 5 6 8 -> 1,4 5,6 8
    //b: 2 3 4 6 9 -> 2,3,4 6 9
    //相同值将数组分成不同的段，每次选择最大的部分即可
    public static int getMaxBallCnt(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int i = 0, j = 0;
        int res = 0;
        int sum1 = 0, sum2 = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                sum1 += a[i];
                i++;
            } else if (a[i] > b[j]) {
                sum2 += b[j];
                j++;
            } else {
                res += Math.max(sum1, sum2) + a[i];
                i++;
                j++;
                sum1 = sum2 = 0;
            }
        }
        while (i < n) {
            sum1 += a[i];
            i++;
        }
        while (j < m) {
            sum2 += b[j];
            j++;
        }
        res += Math.max(sum1, sum2);
        return res;
    }
}
 */