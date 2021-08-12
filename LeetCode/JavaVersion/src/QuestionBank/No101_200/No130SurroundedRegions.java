package QuestionBank.No101_200;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No130SurroundedRegions {
    // 自己写的BFS
    public void solve1(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        boolean[][] flag = new boolean[m][n];
        int[][] dire = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                    queue.offer(new Pair<>(i, j));
                    flag[i][j] = true;
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> now_node = queue.poll();
                        for (int[] di : dire) {
                            int xx = now_node.getKey() + di[0];
                            int yy = now_node.getValue() + di[1];
                            if (xx < 0 || yy < 0 || xx >= m || yy >= n || board[xx][yy] != 'O' || flag[xx][yy]) {
                                continue;
                            }
                            flag[xx][yy] = true;
                            queue.offer(new Pair<>(xx, yy));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !flag[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    // 自己写的DFS
    int m, n;

    public void solve2(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j, flag);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !flag[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int[][] dire = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    void dfs(char[][] board, int x, int y, boolean[][] flag) {
        flag[x][y] = true;
        for (int[] di : dire) {
            int xx = x + di[0];
            int yy = y + di[1];
            if (xx < 0 || yy < 0 || xx >= m - 1 || yy >= n - 1 || board[xx][yy] != 'O' || flag[xx][yy]) {
                continue;
            }
            dfs(board, xx, yy, flag);
        }
    }

    public static void main(String[] args) {
        No130SurroundedRegions no130SurroundedRegions = new No130SurroundedRegions();

        char[][] board1 = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] board2 = new char[][]{{'X'}};

//        no130SurroundedRegions.solve1(board1);
//        no130SurroundedRegions.solve1(board2);

        no130SurroundedRegions.solve2(board1);
        no130SurroundedRegions.solve2(board2);

        for (char[] line : board1) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println();

        for (char[] line : board2) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println();
    }

    // LeetCode题解1：DFS
    class Solution1 {
        int n, m;

        public void solve(char[][] board) {
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
    }

    // LeetCode题解2：BFS
    class Solution2 {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        public void solve(char[][] board) {
            int n = board.length;
            if (n == 0) {
                return;
            }
            int m = board[0].length;
            Queue<int[]> queue = new LinkedList<int[]>();
            for (int i = 0; i < n; i++) {
                if (board[i][0] == 'O') {
                    queue.offer(new int[]{i, 0});
                    board[i][0] = 'A';
                }
                if (board[i][m - 1] == 'O') {
                    queue.offer(new int[]{i, m - 1});
                    board[i][m - 1] = 'A';
                }
            }
            for (int i = 1; i < m - 1; i++) {
                if (board[0][i] == 'O') {
                    queue.offer(new int[]{0, i});
                    board[0][i] = 'A';
                }
                if (board[n - 1][i] == 'O') {
                    queue.offer(new int[]{n - 1, i});
                    board[n - 1][i] = 'A';
                }
            }
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int i = 0; i < 4; i++) {
                    int mx = x + dx[i], my = y + dy[i];
                    if (mx < 0 || my < 0 || mx >= n || my >= m || board[mx][my] != 'O') {
                        continue;
                    }
                    queue.offer(new int[]{mx, my});
                    board[mx][my] = 'A';
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
}
