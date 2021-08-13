package QuestionBank.No1_100;

import java.util.ArrayList;
import java.util.List;

public class No54SpiralMatrix {
    int row_num = 0, column_num = 0, all_count = 0;
    boolean[][] vis;
    int[][] dire_matrix = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int fill_count = 0;

    public List<Integer> spiralOrder1(int[][] matrix) {
        row_num = matrix.length;
        column_num = matrix[0].length;
        all_count = row_num * column_num;
        vis = new boolean[row_num][column_num];
        List<Integer> result = new ArrayList<>();
        dfs(matrix, result, 0, 0, 0);
//        System.out.println(result.toString());
        return result;
    }

    private void dfs(int[][] matrix, List<Integer> result, int dire, int x, int y) {
        int next_x = x;
        int next_y = y;
        while (true) {
            if (!vis[next_x][next_y]) {
                result.add(matrix[next_x][next_y]);
                vis[next_x][next_y] = true;
                fill_count++;
            }
            if (fill_count == all_count) return;
            next_x += dire_matrix[dire][0];
            next_y += dire_matrix[dire][1];
            if (next_x < 0 || next_x >= row_num || next_y < 0 || next_y >= column_num || vis[next_x][next_y]) {
                dfs(matrix, result, (dire + 1) % 4, next_x - dire_matrix[dire][0], next_y - dire_matrix[dire][1]);
            }
            if (fill_count == all_count) return;
        }
    }

    // 方法2-大循环写法
    // 有问题
    public List<Integer> spiralOrder2(int[][] matrix) {
        int row_num = matrix.length;
        int column_num = matrix[0].length;
        int all_count = row_num * column_num;
        int now_count = 0;
        List<Integer> result = new ArrayList<>();
        int line = 0;
        while (now_count < all_count) {
            for (int y = line; y < column_num - line - 1; y++) {
                result.add(matrix[line][y]);
                System.out.print(matrix[line][y] + " ");
                now_count++;
            }
//            System.out.println();
            for (int x = line; x < row_num - line - 1; x++) {
                result.add(matrix[x][column_num - line - 1]);
                System.out.print(matrix[x][column_num - line - 1] + " ");
                now_count++;
            }
//            System.out.println();
            for (int y = column_num - line - 1; y > line; y--) {
                result.add(matrix[row_num - line - 1][y]);
                System.out.print(matrix[row_num - line - 1][y] + " ");
                now_count++;
            }
//            System.out.println();
            for (int x = row_num - line - 1; x > line; x--) {
                result.add(matrix[x][line]);
                System.out.print(matrix[x][line] + " ");
                now_count++;
            }
//            System.out.println();
            line++;
        }
//        System.out.println(result.toString());
        return result;
    }

    // LeetCode 参考代码
    // 模拟螺旋矩阵的路径
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> order = new ArrayList<Integer>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return order;
            }
            int rows = matrix.length, columns = matrix[0].length;
            boolean[][] visited = new boolean[rows][columns];
            int total = rows * columns;
            int row = 0, column = 0;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int directionIndex = 0;
            for (int i = 0; i < total; i++) {
                order.add(matrix[row][column]);
                visited[row][column] = true;
                int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
                if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                    directionIndex = (directionIndex + 1) % 4;
                }
                row += directions[directionIndex][0];
                column += directions[directionIndex][1];
            }
            return order;
        }
    }

    // LeetCode参考代码
    // 按层模拟
    class Solution2 {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> order = new ArrayList<Integer>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return order;
            }
            int rows = matrix.length, columns = matrix[0].length;
            int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
            while (left <= right && top <= bottom) {
                for (int column = left; column <= right; column++) {
                    order.add(matrix[top][column]);
                }
                for (int row = top + 1; row <= bottom; row++) {
                    order.add(matrix[row][right]);
                }
                if (left < right && top < bottom) {
                    for (int column = right - 1; column > left; column--) {
                        order.add(matrix[bottom][column]);
                    }
                    for (int row = bottom; row > top; row--) {
                        order.add(matrix[row][left]);
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return order;
        }
    }
}
