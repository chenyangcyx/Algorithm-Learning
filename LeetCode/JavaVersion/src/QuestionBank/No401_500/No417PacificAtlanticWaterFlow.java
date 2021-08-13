package QuestionBank.No401_500;

import javafx.util.Pair;

import java.util.*;

public class No417PacificAtlanticWaterFlow {
    // 自己写的，DFS
    int m, n;
    int[][] dire = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        No417PacificAtlanticWaterFlow no417PacificAtlanticWaterFlow = new No417PacificAtlanticWaterFlow();

        int[][] heights1 = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};

//        List<List<Integer>> result1 = no417PacificAtlanticWaterFlow.pacificAtlantic1(heights1);
//        for (List<Integer> list : result1) {
//            System.out.println(list.get(0) + ", " + list.get(1));
//        }

        List<List<Integer>> result2 = no417PacificAtlanticWaterFlow.pacificAtlantic2(heights1);
        for (List<Integer> list : result2) {
            System.out.println(list.get(0) + ", " + list.get(1));
        }
    }

    // 自己写的，BFS
    public List<List<Integer>> pacificAtlantic1(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return new LinkedList<>();
        }
        int m = heights.length, n = heights[0].length;
        HashSet<String> taipingyang_success = new HashSet<>();
        boolean[][] taipingyang_vis = new boolean[m][n];
        int[][] dire = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!(i == 0 || j == 0)) {
                    continue;
                }
                if (!taipingyang_vis[i][j]) {
                    taipingyang_vis[i][j] = true;
                    taipingyang_success.add(i + "," + j);
                    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                    queue.offer(new Pair<>(i, j));
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> now_node = queue.poll();
                        for (int[] di : dire) {
                            int xx = now_node.getKey() + di[0];
                            int yy = now_node.getValue() + di[1];
                            if (xx < 0 || yy < 0 || xx >= m || yy >= n || taipingyang_vis[xx][yy]
                                    || heights[xx][yy] < heights[now_node.getKey()][now_node.getValue()]) {
                                continue;
                            }
                            taipingyang_success.add(xx + "," + yy);
                            taipingyang_vis[xx][yy] = true;
                            queue.offer(new Pair<>(xx, yy));
                        }
                    }
                }
            }
        }

        boolean[][] daxiyang_vis = new boolean[m][n];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!(i == m - 1 || j == n - 1)) {
                    continue;
                }
                if (!daxiyang_vis[i][j]) {
                    daxiyang_vis[i][j] = true;
                    if (taipingyang_success.contains(i + "," + j)) {
                        result.add(Arrays.asList(i, j));
                    }
                    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                    queue.offer(new Pair<>(i, j));
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> now_node = queue.poll();
                        for (int[] di : dire) {
                            int xx = now_node.getKey() + di[0];
                            int yy = now_node.getValue() + di[1];
                            if (xx < 0 || yy < 0 || xx >= m || yy >= n || daxiyang_vis[xx][yy]
                                    || heights[xx][yy] < heights[now_node.getKey()][now_node.getValue()]) {
                                continue;
                            }
                            if (taipingyang_success.contains(xx + "," + yy)) {
                                result.add(Arrays.asList(xx, yy));
                            }
                            daxiyang_vis[xx][yy] = true;
                            queue.offer(new Pair<>(xx, yy));
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> pacificAtlantic2(int[][] heights) {
        List<List<Integer>> result = new LinkedList<>();
        if (heights == null || heights.length == 0) {
            return result;
        }
        m = heights.length;
        n = heights[0].length;
        boolean[][] vis_taipingyang = new boolean[m][n];
        boolean[][] vis_daxiyang = new boolean[m][n];
        HashSet<Pair<Integer, Integer>> taipingyang_success = new HashSet<>();
        HashSet<Pair<Integer, Integer>> daxiyang_success = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0) && !vis_taipingyang[i][j]) {
                    dfs(heights, i, j, vis_taipingyang, taipingyang_success);
                }
                if ((i == m - 1 || j == n - 1) && !vis_daxiyang[i][j]) {
                    dfs(heights, i, j, vis_daxiyang, daxiyang_success);
                }
            }
        }
        HashSet<String> temp = new HashSet<>();
        for (Pair<Integer, Integer> pair : taipingyang_success) {
            temp.add(pair.getKey() + "," + pair.getValue());
        }
        for (Pair<Integer, Integer> pair : daxiyang_success) {
            if (temp.contains(pair.getKey() + "," + pair.getValue())) {
                result.add(Arrays.asList(pair.getKey(), pair.getValue()));
            }
        }

        return result;
    }

    void dfs(int[][] heights, int x, int y, boolean[][] vis, HashSet<Pair<Integer, Integer>> success) {
        success.add(new Pair<>(x, y));
        for (int[] di : dire) {
            int xx = x + di[0];
            int yy = y + di[1];
            if (xx < 0 || yy < 0 || xx >= m || yy >= n || vis[xx][yy] || heights[xx][yy] < heights[x][y]) {
                continue;
            }
            vis[xx][yy] = true;
            dfs(heights, xx, yy, vis, success);
        }
    }

    // LeetCode 参考
    class Solution1 {
        // 用来返回的返回值
        private final List<List<Integer>> ans = new ArrayList<>();
        // 方向转换的数组
        private final int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        // 大西洋和太平洋共享的访问数组
        private boolean[][] visited = null;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int n = heights.length, m = heights[0].length;
            visited = new boolean[n][m];
            // temp 是用来记录当前深度优先搜索访问过的点
            boolean[][] temp = new boolean[n][m];
            // 首先从太平洋出发，看看都能遇到哪些点
            for (int x = 0; x < n; ++x) {
                for (int y = 0; y < m; ++y) {
                    // x == 0 || y == 0 表示要从太平洋出发需要满足的条件，flag == false 意味着是从太平洋出发的
                    if ((x == 0 || y == 0) && !temp[x][y]) dfs(heights, x, y, temp, n, m, false);
                }
            }
            // 同上，temp 是用来标记当前深度优先搜索访问到的点
            temp = new boolean[n][m];
            // 然后再从大西洋出发，看看能遇到哪些点，如果遇到的点 在 visited 中之前已经被标记为 true， 那么说明双方都可到达
            for (int x = 0; x < n; ++x) {
                for (int y = 0; y < m; ++y) {
                    // x == n - 1 || y == m - 1 表示从大西洋出发
                    if ((x == n - 1 || y == m - 1) && !temp[x][y]) dfs(heights, x, y, temp, n, m, true);
                }
            }
            return ans;
        }

        /**
         * @param x    深度优先搜索的起始点坐标 x
         * @param y    起始点坐标 y
         * @param temp 用来标记当前深度优先搜索已经访问过哪些点了
         * @param flag 为 true 时意味着是大西洋来的，为 false 意味着是太平洋来的
         */
        private void dfs(int[][] heights, int x, int y, boolean[][] temp, int n, int m, boolean flag) {
            // 如果是大西洋来的，而且 太平洋已经访问过 {x, y} 了，就放到返回值中
            if (flag && visited[x][y]) {
                List<Integer> buf = new ArrayList<>();
                buf.add(x);
                buf.add(y);
                ans.add(buf);
                // 顺便把该点置为 false，防止重复记录
                visited[x][y] = false;
            }
            // 如果是从太平洋来的，需要将 {x, y} 标记为已来过
            if (!flag) visited[x][y] = true;
            // 然后切换四个方向，逐个检查
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                // 检查新的坐标是否合法，以及当前深度优先搜索是否来过，最后还要满足 逆向 条件
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !temp[nx][ny] && heights[nx][ny] >= heights[x][y]) {
                    temp[nx][ny] = true;    // 然后在当前深度优先搜索中标记为已来过
                    dfs(heights, nx, ny, temp, n, m, flag); // 继续深度优先搜索
                }
            }
        }
    }

    // CS-Note代码
//    private int m, n;
//    private int[][] matrix;
//    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//
//    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
//        List<List<Integer>> ret = new ArrayList<>();
//        if (matrix == null || matrix.length == 0) {
//            return ret;
//        }
//
//        m = matrix.length;
//        n = matrix[0].length;
//        this.matrix = matrix;
//        boolean[][] canReachP = new boolean[m][n];
//        boolean[][] canReachA = new boolean[m][n];
//
//        for (int i = 0; i < m; i++) {
//            dfs(i, 0, canReachP);
//            dfs(i, n - 1, canReachA);
//        }
//        for (int i = 0; i < n; i++) {
//            dfs(0, i, canReachP);
//            dfs(m - 1, i, canReachA);
//        }
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (canReachP[i][j] && canReachA[i][j]) {
//                    ret.add(Arrays.asList(i, j));
//                }
//            }
//        }
//
//        return ret;
//    }
//
//    private void dfs(int r, int c, boolean[][] canReach) {
//        if (canReach[r][c]) {
//            return;
//        }
//        canReach[r][c] = true;
//        for (int[] d : direction) {
//            int nextR = d[0] + r;
//            int nextC = d[1] + c;
//            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n
//                    || matrix[r][c] > matrix[nextR][nextC]) {
//
//                continue;
//            }
//            dfs(nextR, nextC, canReach);
//        }
//    }
}
