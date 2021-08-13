package CSNotes.BFS;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class No1091ShortestPathinBinaryMatrix {
    int[] dir_x = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    int[] dir_y = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        boolean[][] inque = new boolean[grid.length][grid[0].length];
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        inque[0][0] = true;
        int ans = Integer.MAX_VALUE;
        // 开始进行BFS操作
        while (!queue.isEmpty()) {
            Point p = queue.pollFirst();
            if (p.getX() == grid.length - 1 && p.getY() == grid[0].length - 1)
                ans = Integer.min(ans, p.getPath_length());
            for (int i = 0; i < 8; i++) {
                int next_vis_x = p.getX() + dir_x[i];
                int next_vis_y = p.getY() + dir_y[i];
                if (canVisit(grid, next_vis_x, next_vis_y) && !inque[next_vis_x][next_vis_y]) {
                    queue.addLast(new Point(next_vis_x, next_vis_y, p.getPath_length() + 1));
                    inque[next_vis_x][next_vis_y] = true;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private boolean canVisit(int[][] grid, int vis_x, int vis_y) {
        if (vis_x < 0 || vis_x >= grid.length) return false;
        if (vis_y < 0 || vis_y >= grid[0].length) return false;
        return grid[vis_x][vis_y] != 1;
    }

    // CS-Note 参考代码
    public int shortestPathBinaryMatrix2(int[][] grids) {
        if (grids == null || grids.length == 0 || grids[0].length == 0) {
            return -1;
        }
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey(), cc = cur.getValue();
                if (grids[cr][cc] == 1) {
                    continue;
                }
                if (cr == m - 1 && cc == n - 1) {
                    return pathLength;
                }
                grids[cr][cc] = 1; // 标记
                for (int[] d : direction) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }

    class Point {
        private int x, y, path_length;

        public Point(int x, int y, int path_length) {
            this.x = x;
            this.y = y;
            this.path_length = path_length;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getPath_length() {
            return path_length;
        }

        public void setPath_length(int path_length) {
            this.path_length = path_length;
        }
    }
}
