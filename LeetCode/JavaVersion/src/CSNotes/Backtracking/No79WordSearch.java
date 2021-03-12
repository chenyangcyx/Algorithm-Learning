package CSNotes.Backtracking;

public class No79WordSearch {
    int[][] dire = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int row_num = 0, column_num = 0;
    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        row_num = board.length;
        column_num = board[0].length;
        used = new boolean[row_num][column_num];
        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < column_num; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, word.length(), 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int length, int count, int x, int y) {
//        System.out.println("访问："+x+", "+y+"  字母："+board[x][y]+" 当前count："+count);
        if (count + 1 == length) return true;
        used[x][y] = true;
        boolean success = false;
        for (int[] di : dire) {
            int next_x = x + di[0];
            int next_y = y + di[1];
            if (next_x < 0 || next_x >= row_num || next_y < 0 || next_y >= column_num) continue;
            if (count + 1 < length && board[next_x][next_y] == word.charAt(count + 1) && !used[next_x][next_y]) {
                success = success || dfs(board, word, length, count + 1, next_x, next_y);
                if (success) break;
            }
        }
        used[x][y] = false;
        return success;
    }

    // CS-Note 参考代码
    private final static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m;
    private int n;

    public boolean exist2(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        m = board.length;
        n = board[0].length;
        boolean[][] hasVisited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (backtracking(0, r, c, hasVisited, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtracking(int curLen, int r, int c, boolean[][] visited, final char[][] board, final String word) {
        if (curLen == word.length()) {
            return true;
        }
        if (r < 0 || r >= m || c < 0 || c >= n
                || board[r][c] != word.charAt(curLen) || visited[r][c]) {

            return false;
        }

        visited[r][c] = true;

        for (int[] d : direction) {
            if (backtracking(curLen + 1, r + d[0], c + d[1], visited, board, word)) {
                return true;
            }
        }

        visited[r][c] = false;

        return false;
    }
}
