package CSNotes.Backtracking;

import java.util.*;

public class No51NQueens {
    int[] pos;
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        pos = new int[n];
        result = new LinkedList<>();
        dfs(n, 0, new LinkedList<>());
        return result;
    }

    private void dfs(int n, int index, LinkedList<String> path) {
        if (index == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 每一个格子去试
        for (int i = 0; i < n; i++) {
            pos[index] = i;
            // 判断当前格子是否可行
            if (if_ok(index)) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == i) sb.append("Q");
                    else sb.append(".");
                }
                path.addLast(sb.toString());
                dfs(n, index + 1, path);
                path.pollLast();
            } else {
                pos[index] = -1;
            }
        }
    }

    private boolean if_ok(int index) {
        for (int i = 0; i < index; i++) {
            for (int j = i + 1; j <= index; j++) {
                if (pos[i] == pos[j] || Math.abs(pos[i] - pos[j]) == Math.abs(i - j)) return false;
            }
        }
        return true;
    }

    // CS-Note 参考代码
    private List<List<String>> solutions;
    private char[][] nQueens;
    private boolean[] colUsed;
    private boolean[] diagonals45Used;
    private boolean[] diagonals135Used;
    private int n;

    public List<List<String>> solveNQueens2(int n) {
        solutions = new ArrayList<>();
        nQueens = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }
        colUsed = new boolean[n];
        diagonals45Used = new boolean[2 * n - 1];
        diagonals135Used = new boolean[2 * n - 1];
        this.n = n;
        backtracking(0);
        return solutions;
    }

    private void backtracking(int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : nQueens) {
                list.add(new String(chars));
            }
            solutions.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            int diagonals45Idx = row + col;
            int diagonals135Idx = n - 1 - (row - col);
            if (colUsed[col] || diagonals45Used[diagonals45Idx] || diagonals135Used[diagonals135Idx]) {
                continue;
            }
            nQueens[row][col] = 'Q';
            colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = true;
            backtracking(row + 1);
            colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = false;
            nQueens[row][col] = '.';
        }
    }
}
