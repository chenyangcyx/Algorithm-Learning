package CSNotes.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No417PacificAtlanticWaterFlow {
    int[][] dire = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int row_num = 0;
    int column_num = 0;
    boolean[][] vis;
    boolean[][] to_pacific, to_atlantic;
    // CS-Note 参考代码
    private int m, n;
    private int[][] matrix;
    private final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        row_num = matrix.length;
        column_num = matrix[0].length;
        vis = new boolean[row_num][column_num];
        to_pacific = new boolean[row_num][column_num];
        to_atlantic = new boolean[row_num][column_num];
        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < column_num; j++) {
                dfs(matrix, i, j, i, j, matrix[i][j]);
                if (to_pacific[i][j] && to_atlantic[i][j]) result.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        return result;
    }

    private void dfs(int[][] matrix, int ori_x, int ori_y, int x, int y, int pre_value) {
        if (x < 0 || y < 0) {
            to_pacific[ori_x][ori_y] = true;
            return;
        }
        if (x >= row_num || y >= column_num) {
            to_atlantic[ori_x][ori_y] = true;
            return;
        }
        if (vis[x][y] || matrix[x][y] > pre_value) return;
        vis[x][y] = true;
        for (int[] di : dire) {
            int next_x = x + di[0];
            int next_y = y + di[1];
            dfs(matrix, ori_x, ori_y, next_x, next_y, matrix[x][y]);
        }
        vis[x][y] = false;
    }

    public List<List<Integer>> pacificAtlantic2(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }

        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, canReachP);
            dfs(i, n - 1, canReachA);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, canReachP);
            dfs(m - 1, i, canReachA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    ret.add(Arrays.asList(i, j));
                }
            }
        }

        return ret;
    }

    private void dfs(int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] d : direction) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n
                    || matrix[r][c] > matrix[nextR][nextC]) {

                continue;
            }
            dfs(nextR, nextC, canReach);
        }
    }
}
