package Contest1;

import java.util.ArrayList;
import java.util.Scanner;

public class No1_23 {
    int L_chess_num;
    ArrayList<Integer> result_x = new ArrayList<>(), result_y = new ArrayList<>();
    int[] dire_x = new int[]{0, -1, 1, 0}, dire_y = new int[]{-1, 0, 0, 1};
    boolean[][] vis;

    public void No1_23() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int special_x = sc.nextInt();
            int special_y = sc.nextInt();
            int check_x = sc.nextInt();
            int check_y = sc.nextInt();
            int chessboard_size = (int) Math.pow(2, N);
            // 初始化棋盘
            int[][] chess = new int[chessboard_size][chessboard_size];
            vis = new boolean[chessboard_size][chessboard_size];
            // 填充特定位置
            L_chess_num = 1;
            result_x.clear();
            result_y.clear();
            chess[special_x][special_y] = L_chess_num;
            // 分治法填充棋盘
            fillChessBoard(chess, 0, 0, special_x, special_y, chessboard_size);
            // 开始查找相应的点
            vis[check_x][check_y] = true;
            findResult(chess, check_x, check_y, chess[check_x][check_y]);
            // 输出结果点
            int res_x1 = result_x.get(0);
            int res_y1 = result_y.get(0);
            int res_x2 = result_x.get(1);
            int res_y2 = result_y.get(1);
            if ((res_x1 < res_x2) || ((res_x1 == res_x2) && (res_y1 <= res_y2)))
                System.out.println(res_x1 + " " + res_y1 + "," + res_x2 + " " + res_y2);
            else System.out.println(res_x2 + " " + res_y2 + "," + res_x1 + " " + res_y1);
        }
    }

    private void fillChessBoard(int[][] chess, int row, int column, int x, int y, int size) {
        if (size == 1) return;
        int subsize = size / 2;
        int t = ++L_chess_num;
        int centerRow = row + subsize;
        int centerColumn = column + subsize;
        // 黑色方格在左上子棋盘
        if (x < centerRow && y < centerColumn) fillChessBoard(chess, row, column, x, y, subsize);
        else {
            // 不在则填充左上子棋盘的右下角
            chess[centerRow - 1][centerColumn - 1] = t;
            fillChessBoard(chess, row, column, centerRow - 1, centerColumn - 1, subsize);
        }
        // 黑色方格在右上子棋盘
        if (x < centerRow && y >= centerColumn) fillChessBoard(chess, row, centerColumn, x, y, subsize);
        else {
            // 不在则填充左上子棋盘的右下角
            chess[centerRow - 1][centerColumn] = t;
            fillChessBoard(chess, row, centerColumn, centerRow - 1, centerColumn, subsize);
        }
        // 黑色方格在左下子棋盘
        if (x >= centerRow && y < centerColumn) fillChessBoard(chess, centerRow, column, x, y, subsize);
        else {
            // 不在则填充左上子棋盘的右下角
            chess[centerRow][centerColumn - 1] = t;
            fillChessBoard(chess, centerRow, column, centerRow, centerColumn - 1, subsize);
        }
        // 黑色方格在右下子棋盘
        if (x >= centerRow && y >= centerColumn) fillChessBoard(chess, centerRow, centerColumn, x, y, subsize);
        else {
            // 不在则填充左上子棋盘的右下角
            chess[centerRow][centerColumn] = t;
            fillChessBoard(chess, centerRow, centerColumn, centerRow, centerColumn, subsize);
        }
    }

    private void findResult(int[][] chess, int check_x, int check_y, int checknum) {
        if (result_x.size() == 2 && result_y.size() == 2) return;
        for (int i = 0; i < 4; i++) {
            int res_x = check_x + dire_x[i];
            int res_y = check_y + dire_y[i];
            if (!(res_x < 0 || res_y < 0 || res_x >= chess.length || res_y >= chess.length)) {
                if (chess[res_x][res_y] == checknum && !vis[res_x][res_y]) {
                    result_x.add(res_x);
                    result_y.add(res_y);
                    vis[res_x][res_y] = true;
                    findResult(chess, res_x, res_y, checknum);
                }
            }
        }
    }
}
