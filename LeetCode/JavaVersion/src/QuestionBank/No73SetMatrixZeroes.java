package QuestionBank;

public class No73SetMatrixZeroes {
    int[][] dire = new int[][]{{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

    public void setZeroes(int[][] matrix) {
        int row_num = matrix.length;
        int column_num = matrix[0].length;
        boolean[] row_flag = new boolean[row_num];
        boolean[] column_flag = new boolean[column_num];
        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < column_num; j++) {
                if (matrix[i][j] == 0) row_flag[i] = column_flag[j] = true;
            }
        }
        // 行填充
        for (int i = 0; i < row_num; i++) {
            if (row_flag[i]) {
                for (int j = 0; j < column_num; j++) matrix[i][j] = 0;
            }
        }
        // 列填充
        for (int j = 0; j < column_num; j++) {
            if (column_flag[j]) {
                for (int i = 0; i < row_num; i++) matrix[i][j] = 0;
            }
        }
    }

    // LeetCode 参考代码1
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // LeetCode 参考代码2
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    // LeetCode 参考代码3
    public void setZeroes3(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }
}
