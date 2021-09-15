package HuaWei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class HJ44_Sudoku {
    static HashSet<Integer> allnumLine = new HashSet<>();
    static HashSet<Integer>[] row_exist = new HashSet[9];
    static HashSet<Integer>[] column_exist = new HashSet[9];
    static boolean succ = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 9; i++) {
            allnumLine.add(i);
            row_exist[i - 1] = new HashSet<>();
            column_exist[i - 1] = new HashSet<>();
        }
        int[][] matrix = new int[9][9];
        ArrayList<int[]> to_fill = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int input_num = sc.nextInt();
                matrix[i][j] = input_num;
                if (input_num == 0) {
                    to_fill.add(new int[]{i, j});
                } else {
                    row_exist[i].add(input_num);
                    column_exist[j].add(input_num);
                }
            }
        }
        dfs(matrix, 0, to_fill);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j != 8) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    static HashSet<Integer> getLossNumInLine(int[] line) {
        HashSet<Integer> result = new HashSet<>(allnumLine);
        for (int num : line) {
            result.remove(num);
        }
        return result;
    }

    static void dfs(int[][] matrix, int pos, ArrayList<int[]> to_fill) {
        if (pos == to_fill.size()) {
            succ = true;
            return;
        }
        int now_x = to_fill.get(pos)[0];
        int now_y = to_fill.get(pos)[1];
        HashSet<Integer> line_left = getLossNumInLine(matrix[now_x]);
        for (int num : line_left) {
            if (row_exist[now_x].contains(num) || column_exist[now_y].contains(num)) {
                continue;
            }
            matrix[now_x][now_y] = num;
            row_exist[now_x].add(num);
            column_exist[now_y].add(num);
            dfs(matrix, pos + 1, to_fill);
            if (succ) {
                break;
            } else {
                matrix[now_x][now_y] = 0;
                row_exist[now_x].remove(num);
                column_exist[now_y].remove(num);
            }
        }
    }
}
