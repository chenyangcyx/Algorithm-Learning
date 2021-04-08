package QuestionBank.No1_100;

public class No59SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int all_count = n * n, now_count = 0;
        int[][] dire = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] result = new int[n][n];
        boolean[][] vis = new boolean[n][n];
        int x = 0, y = 0, dir = 0;
        while (now_count < all_count) {
            result[x][y] = ++now_count;
//            System.out.print(now_count+" ");
            vis[x][y] = true;
            int next_x = x + dire[dir][0], next_y = y + dire[dir][1];
            if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= n || vis[next_x][next_y]) {
                dir = (dir + 1) % 4;
                x += dire[dir][0];
                y += dire[dir][1];
            } else {
                x = next_x;
                y = next_y;
            }
        }
//        System.out.println();
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++)
//                System.out.print(result[i][j]+"\t");
//            System.out.println();
//        }
        return result;
    }
}

// LeetCode 参考代码1
class Solution {
    public int[][] generateMatrix(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }
}

// LeetCode 参考代码2
class Solution2 {
    public int[][] generateMatrix(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                matrix[top][column] = num;
                num++;
            }
            for (int row = top + 1; row <= bottom; row++) {
                matrix[row][right] = num;
                num++;
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    matrix[bottom][column] = num;
                    num++;
                }
                for (int row = bottom; row > top; row--) {
                    matrix[row][left] = num;
                    num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }
}
