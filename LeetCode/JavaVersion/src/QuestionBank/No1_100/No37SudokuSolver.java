package QuestionBank.No1_100;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No37SudokuSolver {
    HashSet<Integer>[] row_set = new HashSet[9],
            column_set = new HashSet[9],
            zone_set = new HashSet[9];
    ArrayList<Pair<Integer, Integer>> tofill;

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        for (int i = 0; i < 9; i++) {
            row_set[i] = new HashSet<>();
            column_set[i] = new HashSet<>();
            zone_set[i] = new HashSet<>();
        }
        tofill = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    row_set[i].add(Integer.parseInt(String.valueOf(board[i][j])));
                    column_set[j].add(Integer.parseInt(String.valueOf(board[i][j])));
                    zone_set[calZoneNo(i, j)].add(Integer.parseInt(String.valueOf(board[i][j])));
                } else {
                    tofill.add(new Pair<>(i, j));
                }
            }
        }
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int index) {
        if (index == tofill.size()) {
            return true;
        }
        int row = tofill.get(index).getKey();
        int col = tofill.get(index).getValue();
        int zone = calZoneNo(row, col);
        for (int j = 1; j <= 9; j++) {
            if (row_set[row].contains(j) ||
                    column_set[col].contains(j) ||
                    zone_set[zone].contains(j)) {
                continue;
            }
            board[row][col] = (char) ('0' + j);
            row_set[row].add(j);
            column_set[col].add(j);
            zone_set[zone].add(j);
            boolean result = dfs(board, index + 1);
            if (result) {
                return true;
            }
            row_set[row].remove(j);
            column_set[col].remove(j);
            zone_set[zone].remove(j);
        }
        return false;
    }

    private int calZoneNo(int i, int j) {
        if (i <= 2 && j <= 2) {
            return 0;
        } else if (i <= 2 && j <= 5) {
            return 1;
        } else if (i <= 2 && j <= 8) {
            return 2;
        } else if (i <= 5 && j <= 2) {
            return 3;
        } else if (i <= 5 && j <= 5) {
            return 4;
        } else if (i <= 5 && j <= 8) {
            return 5;
        } else if (i <= 8 && j <= 2) {
            return 6;
        } else if (i <= 8 && j <= 5) {
            return 7;
        } else {
            return 8;
        }
    }

    public static void main(String[] args) {
        No37SudokuSolver no37SudokuSolver = new No37SudokuSolver();

        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        no37SudokuSolver.solveSudoku(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // LeetCode 题解1：递归
    class Solution1 {
        private boolean[][] line = new boolean[9][9];
        private boolean[][] column = new boolean[9][9];
        private boolean[][][] block = new boolean[3][3][9];
        private boolean valid = false;
        private List<int[]> spaces = new ArrayList<int[]>();

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        spaces.add(new int[]{i, j});
                    } else {
                        int digit = board[i][j] - '0' - 1;
                        line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                    }
                }
            }

            dfs(board, 0);
        }

        public void dfs(char[][] board, int pos) {
            if (pos == spaces.size()) {
                valid = true;
                return;
            }

            int[] space = spaces.get(pos);
            int i = space[0], j = space[1];
            for (int digit = 0; digit < 9 && !valid; ++digit) {
                if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                    board[i][j] = (char) (digit + '0' + 1);
                    dfs(board, pos + 1);
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
                }
            }
        }
    }

    // LeetCode 题解2：位运算优化
    class Solution2 {
        private int[] line = new int[9];
        private int[] column = new int[9];
        private int[][] block = new int[3][3];
        private boolean valid = false;
        private List<int[]> spaces = new ArrayList<int[]>();

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        spaces.add(new int[]{i, j});
                    } else {
                        int digit = board[i][j] - '0' - 1;
                        flip(i, j, digit);
                    }
                }
            }

            dfs(board, 0);
        }

        public void dfs(char[][] board, int pos) {
            if (pos == spaces.size()) {
                valid = true;
                return;
            }

            int[] space = spaces.get(pos);
            int i = space[0], j = space[1];
            int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
            for (; mask != 0 && !valid; mask &= (mask - 1)) {
                int digitMask = mask & (-mask);
                int digit = Integer.bitCount(digitMask - 1);
                flip(i, j, digit);
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                flip(i, j, digit);
            }
        }

        public void flip(int i, int j, int digit) {
            line[i] ^= (1 << digit);
            column[j] ^= (1 << digit);
            block[i / 3][j / 3] ^= (1 << digit);
        }
    }

    // LeetCode 题解3：枚举优化
    class Solution3 {
        private int[] line = new int[9];
        private int[] column = new int[9];
        private int[][] block = new int[3][3];
        private boolean valid = false;
        private List<int[]> spaces = new ArrayList<int[]>();

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] != '.') {
                        int digit = board[i][j] - '0' - 1;
                        flip(i, j, digit);
                    }
                }
            }

            while (true) {
                boolean modified = false;
                for (int i = 0; i < 9; ++i) {
                    for (int j = 0; j < 9; ++j) {
                        if (board[i][j] == '.') {
                            int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
                            if ((mask & (mask - 1)) == 0) {
                                int digit = Integer.bitCount(mask - 1);
                                flip(i, j, digit);
                                board[i][j] = (char) (digit + '0' + 1);
                                modified = true;
                            }
                        }
                    }
                }
                if (!modified) {
                    break;
                }
            }

            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        spaces.add(new int[]{i, j});
                    }
                }
            }

            dfs(board, 0);
        }

        public void dfs(char[][] board, int pos) {
            if (pos == spaces.size()) {
                valid = true;
                return;
            }

            int[] space = spaces.get(pos);
            int i = space[0], j = space[1];
            int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
            for (; mask != 0 && !valid; mask &= (mask - 1)) {
                int digitMask = mask & (-mask);
                int digit = Integer.bitCount(digitMask - 1);
                flip(i, j, digit);
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                flip(i, j, digit);
            }
        }

        public void flip(int i, int j, int digit) {
            line[i] ^= (1 << digit);
            column[j] ^= (1 << digit);
            block[i / 3][j / 3] ^= (1 << digit);
        }
    }
}
