package CSNotes.Backtracking;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No37SudokuSolver {
    ArrayList<Pair<Integer, Integer>> blank_list = new ArrayList<>();
    int blank_num = 0;
    boolean if_end = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    blank_list.add(new Pair<>(i, j));
                    blank_num++;
                }
            }
        }
        dfs(board, 0, 0);
//        for(Pair<Integer,Integer> p:blank_list){
//            HashSet<Character> result=canFillNum(board,p);
//            System.out.println(p.getKey()+","+p.getValue()+"："+result.toString());
//        }
//        for(int i=0;i<9;i++) {
//            for (int j = 0; j < 9; j++) System.out.print(board[i][j]+" ");
//            System.out.println();
//        }
    }

    private void dfs(char[][] board, int fill_count, int fill_index) {
        if (fill_count == blank_num) {
            if_end = true;
            return;
        }
        Pair<Integer, Integer> point = blank_list.get(fill_index);
        HashSet<Character> canfill = canFillNum(board, blank_list.get(fill_index));
        for (char in : canfill) {
            board[point.getKey()][point.getValue()] = in;
//                System.out.println("将"+point.getKey()+","+point.getValue()+" 填充成："+in);
            dfs(board, fill_count + 1, fill_index + 1);
            if (if_end) return;
            board[point.getKey()][point.getValue()] = '.';
        }
    }

    private HashSet<Character> canFillNum(char[][] board, Pair<Integer, Integer> point) {
        int x = point.getKey(), y = point.getValue();
        HashSet<Character> result = new HashSet<>();
        for (int i = 1; i <= 9; i++) result.add((char) ('0' + i));
        int x_s = x / 3 * 3, y_s = y / 3 * 3;
        int x_e = x_s + 3, y_e = y_s + 3;
        // 同一行内的值去除
        for (int j = 0; j < y_s; j++) {
            if (board[x][j] != '.') result.remove(board[x][j]);
        }
        for (int j = y_e; j < 9; j++) {
            if (board[x][j] != '.') result.remove(board[x][j]);
        }
        // 同一列内的值去除
        for (int i = 0; i < x_s; i++) {
            if (board[i][y] != '.') result.remove(board[i][y]);
        }
        for (int i = x_e; i < 9; i++) {
            if (board[i][y] != '.') result.remove(board[i][y]);
        }
        // 方格内的值去除
        for (int i = x_s; i < x_e; i++) {
            for (int j = y_s; j < y_e; j++) {
                if (board[i][j] != '.') result.remove(board[i][j]);
            }
        }
        return result;
    }

//    // LeetCode 参考代码1
//    private boolean[][] line = new boolean[9][9];
//    private boolean[][] column = new boolean[9][9];
//    private boolean[][][] block = new boolean[3][3][9];
//    private boolean valid = false;
//    private List<int[]> spaces = new ArrayList<int[]>();
//
//    public void solveSudoku_1(char[][] board) {
//        for (int i = 0; i < 9; ++i) {
//            for (int j = 0; j < 9; ++j) {
//                if (board[i][j] == '.') {
//                    spaces.add(new int[]{i, j});
//                } else {
//                    int digit = board[i][j] - '0' - 1;
//                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
//                }
//            }
//        }
//
//        dfs(board, 0);
//    }
//
//    public void dfs(char[][] board, int pos) {
//        if (pos == spaces.size()) {
//            valid = true;
//            return;
//        }
//
//        int[] space = spaces.get(pos);
//        int i = space[0], j = space[1];
//        for (int digit = 0; digit < 9 && !valid; ++digit) {
//            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
//                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
//                board[i][j] = (char) (digit + '0' + 1);
//                dfs(board, pos + 1);
//                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
//            }
//        }
//    }
//
//    // LeetCode 参考代码2
//    private int[] line = new int[9];
//    private int[] column = new int[9];
//    private int[][] block = new int[3][3];
//    private boolean valid = false;
//    private List<int[]> spaces = new ArrayList<int[]>();
//
//    public void solveSudoku(char[][] board) {
//        for (int i = 0; i < 9; ++i) {
//            for (int j = 0; j < 9; ++j) {
//                if (board[i][j] == '.') {
//                    spaces.add(new int[]{i, j});
//                } else {
//                    int digit = board[i][j] - '0' - 1;
//                    flip(i, j, digit);
//                }
//            }
//        }
//
//        dfs(board, 0);
//    }
//
//    public void dfs(char[][] board, int pos) {
//        if (pos == spaces.size()) {
//            valid = true;
//            return;
//        }
//
//        int[] space = spaces.get(pos);
//        int i = space[0], j = space[1];
//        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
//        for (; mask != 0 && !valid; mask &= (mask - 1)) {
//            int digitMask = mask & (-mask);
//            int digit = Integer.bitCount(digitMask - 1);
//            flip(i, j, digit);
//            board[i][j] = (char) (digit + '0' + 1);
//            dfs(board, pos + 1);
//            flip(i, j, digit);
//        }
//    }
//
//    public void flip(int i, int j, int digit) {
//        line[i] ^= (1 << digit);
//        column[j] ^= (1 << digit);
//        block[i / 3][j / 3] ^= (1 << digit);
//    }
//
//    // LeetCode 参考代码3
//    private int[] line = new int[9];
//    private int[] column = new int[9];
//    private int[][] block = new int[3][3];
//    private boolean valid = false;
//    private List<int[]> spaces = new ArrayList<int[]>();
//
//    public void solveSudoku(char[][] board) {
//        for (int i = 0; i < 9; ++i) {
//            for (int j = 0; j < 9; ++j) {
//                if (board[i][j] != '.') {
//                    int digit = board[i][j] - '0' - 1;
//                    flip(i, j, digit);
//                }
//            }
//        }
//
//        while (true) {
//            boolean modified = false;
//            for (int i = 0; i < 9; ++i) {
//                for (int j = 0; j < 9; ++j) {
//                    if (board[i][j] == '.') {
//                        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
//                        if ((mask & (mask - 1)) == 0) {
//                            int digit = Integer.bitCount(mask - 1);
//                            flip(i, j, digit);
//                            board[i][j] = (char) (digit + '0' + 1);
//                            modified = true;
//                        }
//                    }
//                }
//            }
//            if (!modified) {
//                break;
//            }
//        }
//
//        for (int i = 0; i < 9; ++i) {
//            for (int j = 0; j < 9; ++j) {
//                if (board[i][j] == '.') {
//                    spaces.add(new int[]{i, j});
//                }
//            }
//        }
//
//        dfs(board, 0);
//    }
//
//    public void dfs(char[][] board, int pos) {
//        if (pos == spaces.size()) {
//            valid = true;
//            return;
//        }
//
//        int[] space = spaces.get(pos);
//        int i = space[0], j = space[1];
//        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
//        for (; mask != 0 && !valid; mask &= (mask - 1)) {
//            int digitMask = mask & (-mask);
//            int digit = Integer.bitCount(digitMask - 1);
//            flip(i, j, digit);
//            board[i][j] = (char) (digit + '0' + 1);
//            dfs(board, pos + 1);
//            flip(i, j, digit);
//        }
//    }
//
//    public void flip(int i, int j, int digit) {
//        line[i] ^= (1 << digit);
//        column[j] ^= (1 << digit);
//        block[i / 3][j / 3] ^= (1 << digit);
//    }
//
//    // CS-Note 参考代码
//    private boolean[][] rowsUsed = new boolean[9][10];
//    private boolean[][] colsUsed = new boolean[9][10];
//    private boolean[][] cubesUsed = new boolean[9][10];
//    private char[][] board;
//
//    public void solveSudoku(char[][] board) {
//        this.board = board;
//        for (int i = 0; i < 9; i++)
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] == '.') {
//                    continue;
//                }
//                int num = board[i][j] - '0';
//                rowsUsed[i][num] = true;
//                colsUsed[j][num] = true;
//                cubesUsed[cubeNum(i, j)][num] = true;
//            }
//        backtracking(0, 0);
//    }
//
//    private boolean backtracking(int row, int col) {
//        while (row < 9 && board[row][col] != '.') {
//            row = col == 8 ? row + 1 : row;
//            col = col == 8 ? 0 : col + 1;
//        }
//        if (row == 9) {
//            return true;
//        }
//        for (int num = 1; num <= 9; num++) {
//            if (rowsUsed[row][num] || colsUsed[col][num] || cubesUsed[cubeNum(row, col)][num]) {
//                continue;
//            }
//            rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[cubeNum(row, col)][num] = true;
//            board[row][col] = (char) (num + '0');
//            if (backtracking(row, col)) {
//                return true;
//            }
//            board[row][col] = '.';
//            rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[cubeNum(row, col)][num] = false;
//        }
//        return false;
//    }
//
//    private int cubeNum(int i, int j) {
//        int r = i / 3;
//        int c = j / 3;
//        return r * 3 + c;
//    }
}
