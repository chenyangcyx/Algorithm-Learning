package CSNotes.DFS;

public class No200NumberofIslands {
    int[][] dire = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int row_num = grid.length;
        int column_num = grid[0].length;
        int count = 0;
        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < column_num; j++) {
                if (grid[i][j] == '1') count += dfs(grid, row_num, column_num, i, j);
            }
        }
        return count;
    }

    private int dfs(char[][] grid, int row_num, int column_num, int x, int y) {
        if (x < 0 || x >= row_num || y < 0 || y >= column_num || grid[x][y] == '0') return 0;
        grid[x][y] = '0';
        for (int[] di : dire) {
            dfs(grid, row_num, column_num, x + di[0], y + di[1]);
        }
        return 1;
    }

    // CS-Note 参考代码
    private int m, n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int islandsNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0') {
                    dfs(grid, i, j);
                    islandsNum++;
                }
            }
        }
        return islandsNum;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] d : direction) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}
