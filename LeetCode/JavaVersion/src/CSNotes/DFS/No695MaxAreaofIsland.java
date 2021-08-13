package CSNotes.DFS;

public class No695MaxAreaofIsland {
    int[] dir_x = new int[]{-1, 1, 0, 0};
    int[] dir_y = new int[]{0, 0, -1, 1};
    boolean[][] vis;
    //CS-Note参考代码
    private int m, n;
    private final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int row_num = grid.length;
        int column_num = grid[0].length;
        vis = new boolean[row_num][column_num];
        int maxsize = 0;
        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < column_num; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
//                    System.out.println("主循环，访问: "+i+","+j);
                    maxsize = Integer.max(maxsize, dfs(grid, row_num, column_num, i, j, 0));
                }
            }
        }
        return maxsize;
    }

    private int dfs(int[][] grid, int row_num, int column_num, int x, int y, int size) {
//        System.out.println("dfs访问："+x+","+y);
        vis[x][y] = true;
        int maxsize = size + 1;
        for (int i = 0; i < 4; i++) {
            int next_x = x + dir_x[i];
            int next_y = y + dir_y[i];
            if (canVis(grid, row_num, column_num, next_x, next_y)) {
                maxsize = Integer.max(maxsize, dfs(grid, row_num, column_num, next_x, next_y, maxsize));
            }
        }
        return maxsize;
    }

    private boolean canVis(int[][] grid, int row_num, int column_num, int x, int y) {
        if (x < 0 || x >= row_num || y < 0 || y >= column_num || vis[x][y]) return false;
        return grid[x][y] == 1;
    }

    public int maxAreaOfIsland2(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int area = 1;
        for (int[] d : direction) {
            area += dfs(grid, r + d[0], c + d[1]);
        }
        return area;
    }
}
