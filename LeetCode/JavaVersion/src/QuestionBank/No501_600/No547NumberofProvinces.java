package QuestionBank.No501_600;

import java.util.LinkedList;
import java.util.Queue;

public class No547NumberofProvinces {
    int N = 0;

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        N = isConnected.length;
        boolean[] vis = new boolean[N];
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                result++;
                myDfs(isConnected, vis, i);
            }
        }
        return result;
    }

    void myDfs(int[][] isConnected, boolean[] vis, int node_num) {
        vis[node_num] = true;
        for (int i = 0; i < N; i++) {
            if (!vis[i] && isConnected[node_num][i] == 1) {
                myDfs(isConnected, vis, i);
            }
        }
    }

    int myBfs(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        N = isConnected.length;
        int result = 0;
        boolean[] vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                result++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int now_node = queue.poll();
                    for (int j = 0; j < N; j++) {
                        if (!vis[j] && isConnected[now_node][j] == 1) {
                            vis[j] = true;
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        return result;
    }

    // 自己写的并查集
    int[] parent;
    int bingchaji_N = 0;

    int bingchaji(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        bingchaji_N = isConnected.length;
        parent = new int[bingchaji_N];
        for (int i = 0; i < bingchaji_N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < bingchaji_N; i++) {
            for (int j = 0; j < bingchaji_N; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < bingchaji_N; i++) {
            if (parent[i] == i) {
                result++;
            }
        }
        return result;
    }

    void union(int index1, int index2) {
        parent[findParent(index1)] = findParent(index2);
    }

    int findParent(int index) {
        if (parent[index] != index) {
            parent[index] = findParent(parent[index]);
        }
        return parent[index];
    }

    // LeetCode题解1：DFS
    class Solution1 {
        public int findCircleNum(int[][] isConnected) {
            int provinces = isConnected.length;
            boolean[] visited = new boolean[provinces];
            int circles = 0;
            for (int i = 0; i < provinces; i++) {
                if (!visited[i]) {
                    dfs(isConnected, visited, provinces, i);
                    circles++;
                }
            }
            return circles;
        }

        public void dfs(int[][] isConnected, boolean[] visited, int provinces, int i) {
            for (int j = 0; j < provinces; j++) {
                if (isConnected[i][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    dfs(isConnected, visited, provinces, j);
                }
            }
        }
    }

    // LeetCode题解2：BFS
    class Solution2 {
        public int findCircleNum(int[][] isConnected) {
            int provinces = isConnected.length;
            boolean[] visited = new boolean[provinces];
            int circles = 0;
            Queue<Integer> queue = new LinkedList<Integer>();
            for (int i = 0; i < provinces; i++) {
                if (!visited[i]) {
                    queue.offer(i);
                    while (!queue.isEmpty()) {
                        int j = queue.poll();
                        visited[j] = true;
                        for (int k = 0; k < provinces; k++) {
                            if (isConnected[j][k] == 1 && !visited[k]) {
                                queue.offer(k);
                            }
                        }
                    }
                    circles++;
                }
            }
            return circles;
        }
    }

    // LeetCode题解3：并查集
    class Solution3 {
        public int findCircleNum(int[][] isConnected) {
            int provinces = isConnected.length;
            int[] parent = new int[provinces];
            for (int i = 0; i < provinces; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < provinces; i++) {
                for (int j = i + 1; j < provinces; j++) {
                    if (isConnected[i][j] == 1) {
                        union(parent, i, j);
                    }
                }
            }
            int circles = 0;
            for (int i = 0; i < provinces; i++) {
                if (parent[i] == i) {
                    circles++;
                }
            }
            return circles;
        }

        public void union(int[] parent, int index1, int index2) {
            parent[find(parent, index1)] = find(parent, index2);
        }

        public int find(int[] parent, int index) {
            if (parent[index] != index) {
                parent[index] = find(parent, parent[index]);
            }
            return parent[index];
        }
    }
}
