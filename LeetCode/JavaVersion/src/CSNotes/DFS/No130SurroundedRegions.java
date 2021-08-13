package CSNotes.DFS;

import java.util.LinkedList;
import java.util.Queue;

public class No130SurroundedRegions {
    // 自己写的
    // 有问题
//    int[][] dire = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//    boolean[][] vis;
//
//    public void solve(char[][] board) {
//        int row_num = board.length;
//        int column_num = board[0].length;
//        vis = new boolean[row_num][column_num];
//        for (int i = 1; i < row_num - 1; i++) {
//            for (int j = 1; j < column_num - 1; j++) {
//                if (board[i][j] == 'O' && !vis[i][j]) dfs(board, row_num, column_num, i, j);
//            }
//        }
//    }
//
//    private boolean dfs(char[][] board, int row_num, int column_num, int x, int y) {
//        if (x < 0 || x >= row_num || y < 0 || y >= column_num || board[x][y] == 'X') return true;
//        if ((x == 0 || x == row_num - 1 || y == 0 || y == column_num - 1) && (board[x][y] == 'O')) {
//            vis[x][y] = true;
//            return false;
//        }
//        board[x][y] = 'X';
//        vis[x][y] = true;
//        boolean if_cancel = true;
//        for (int[] di : dire) {
//            if(!vis[x][y]) if_cancel = if_cancel && dfs(board, row_num, column_num, x + di[0], y + di[1]);
//        }
//        if (!if_cancel) board[x][y] = 'O';
//        return if_cancel;
//    }

    int[][] dire = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // LeetCode参考代码，DFS
    int n, m;
    // LeetCode参考代码，BFS
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solve(char[][] board) {
        int row_num = board.length;
        int column_num = board[0].length;
        for (int i = 0; i < row_num; i++) {
            dfs(board, row_num, column_num, i, 0);
            dfs(board, row_num, column_num, i, column_num - 1);
        }
        for (int j = 0; j < column_num; j++) {
            dfs(board, row_num, column_num, 0, j);
            dfs(board, row_num, column_num, row_num - 1, j);
        }
        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < column_num; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int row_num, int column_num, int x, int y) {
        if (x < 0 || x >= row_num || y < 0 || y >= column_num || board[x][y] != 'O') return;
        board[x][y] = 'A';
        for (int[] di : dire) {
            dfs(board, row_num, column_num, x + di[0], y + di[1]);
        }
    }

    public void solve2(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

    public void solve3(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
            }
            if (board[i][m - 1] == 'O') {
                queue.offer(new int[]{i, m - 1});
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
            }
            if (board[n - 1][i] == 'O') {
                queue.offer(new int[]{n - 1, i});
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            board[x][y] = 'A';
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx < 0 || my < 0 || mx >= n || my >= m || board[mx][my] != 'O') {
                    continue;
                }
                queue.offer(new int[]{mx, my});
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
