package Contest2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class No2_4 {
    int min_value = Integer.MAX_VALUE;
    ArrayList<LinkedList<Integer>> result = new ArrayList<>();

    public void No2_4() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            sc.nextLine();
            String[] split = sc.nextLine().split(",");
            int[][] weight = new int[N + 1][N + 1];
            for (int i = 1; i <= N * N; i++) {
                String[] _split = split[i - 1].split(" ");
                int x = Integer.parseInt(_split[0]);
                int y = Integer.parseInt(_split[1]);
                int w = Integer.parseInt(_split[2]);
                weight[x][y] = w;
            }
            boolean[] used = new boolean[N + 1];
            dfs(weight, used, N, new LinkedList<>());
            result.sort((o1, o2) -> {
                for (int j = 0; j < o1.size(); j++) {
                    if (o1.get(j) > o2.get(j)) {
                        return -1;
                    } else if (o1.get(j) < o2.get(j)) {
                        return 1;
                    }
                }
                return 0;
            });
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                LinkedList<Integer> list = result.get(i);
                if (i != 0) sb.append(",");
                for (int j = 0; j < list.size(); j++) {
                    if (j == 0) sb.append(list.get(j));
                    else sb.append(" ").append(list.get(i));
                }
            }
            System.out.println(sb.toString());
        }
    }

    private void dfs(int[][] weight, boolean[] used, int N, LinkedList<Integer> path) {
        if (path.size() >= N) {
            int sum = 0;
            for (int i = 1; i <= N; i++) sum += weight[i][path.get(i - 1)];
            if (sum < min_value) {
                min_value = sum;
                result.clear();
                result.add(new LinkedList<>(path));
            } else if (sum == min_value) {
                result.add(new LinkedList<>(path));
            }
            return;
        }
        for (int i = N; i >= 1; i--) {
            if (!used[i]) {
                path.addLast(i);
                used[i] = true;
                dfs(weight, used, N, path);
                used[i] = false;
                path.pollLast();
            }
        }
    }
}
