package Contest2;

import java.util.HashMap;
import java.util.Scanner;

public class No2_3 {
    int max_depth = Integer.MIN_VALUE;

    public void No2_3() {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            String[] str1 = sc.nextLine().split(" ");
            int node_num = Integer.parseInt(str1[0]);
            int start_node = str1[1].charAt(0) - 'a';
            HashMap<Character, Integer> char_num = new HashMap<>();
            String[] str2 = sc.nextLine().split(" ");
            for (int i = 0; i < str2.length; i++) {
                char_num.put(str2[i].charAt(0), i);
            }
            int[][] graph = new int[node_num][node_num];
            for (int i = 0; i < node_num; i++) {
                String[] line = sc.nextLine().split(" ");
                for (int j = 1; j < line.length; j++) {
                    if (line[j].charAt(0) == '1') graph[i][j - 1] = graph[j - 1][i] = 1;
                }
            }
            boolean[] vis = new boolean[node_num];
            vis[start_node] = true;
            dfs(graph, vis, 1, start_node);
            System.out.println(max_depth);
        }
    }

    private void dfs(int[][] graph, boolean[] vis, int depth, int start_node) {
        max_depth = Integer.max(max_depth, depth);
        for (int i = 0; i < graph[0].length; i++) {
            if (!vis[i] && graph[start_node][i] == 1) {
                vis[i] = true;
                dfs(graph, vis, depth + 1, i);
                vis[i] = false;
            }
        }
    }
}
