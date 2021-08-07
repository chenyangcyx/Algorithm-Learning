package QuestionBank.No601_700;

import java.util.LinkedList;
import java.util.Queue;

public class No695MaxAreaofIsland {
    int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        m = grid.length;
        n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    result = Math.max(result, dfs1(grid, vis, i, j, 0));
                }
            }
        }
        return result;
    }

    int[][] dire = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    int dfs1(int[][] grid, boolean[][] vis, int x, int y, int size) {
        vis[x][y] = true;
        int maxsize = size + 1;
        for (int[] di : dire) {
            int xx = x + di[0];
            int yy = y + di[1];
            if (!(xx < 0 || xx >= m || yy < 0 || yy >= n || vis[xx][yy] || grid[xx][yy] == 0)) {
                maxsize = Math.max(maxsize, dfs1(grid, vis, xx, yy, maxsize));
            }
        }
        return maxsize;
    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int[][] grid2 = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        int[][] grid3 = new int[][]{{1}, {1}};

        No695MaxAreaofIsland no695MaxAreaofIsland = new No695MaxAreaofIsland();

        System.out.println(no695MaxAreaofIsland.maxAreaOfIsland(grid1));
        System.out.println(no695MaxAreaofIsland.maxAreaOfIsland(grid2));
        System.out.println(no695MaxAreaofIsland.maxAreaOfIsland(grid3));
    }

    // LeetCode官方解法1：DFS
    public int maxAreaOfIsland2(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                ans = Math.max(ans, dfs2(grid, i, j));
            }
        }
        return ans;
    }

    public int dfs2(int[][] grid, int cur_i, int cur_j) {
        if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
            return 0;
        }
        grid[cur_i][cur_j] = 0;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int ans = 1;
        for (int index = 0; index != 4; ++index) {
            int next_i = cur_i + di[index], next_j = cur_j + dj[index];
            ans += dfs2(grid, next_i, next_j);
        }
        return ans;
    }

    // LeetCode官方解法2：BFS
    public int maxAreaOfIsland3(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                int cur = 0;
                Queue<Integer> queuei = new LinkedList<Integer>();
                Queue<Integer> queuej = new LinkedList<Integer>();
                queuei.offer(i);
                queuej.offer(j);
                while (!queuei.isEmpty()) {
                    int cur_i = queuei.poll(), cur_j = queuej.poll();
                    if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
                        continue;
                    }
                    ++cur;
                    grid[cur_i][cur_j] = 0;
                    int[] di = {0, 0, 1, -1};
                    int[] dj = {1, -1, 0, 0};
                    for (int index = 0; index != 4; ++index) {
                        int next_i = cur_i + di[index], next_j = cur_j + dj[index];
                        queuei.offer(next_i);
                        queuej.offer(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }
}
