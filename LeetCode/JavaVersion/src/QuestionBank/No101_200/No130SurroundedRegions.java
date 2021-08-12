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
}
