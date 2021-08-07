package QuestionBank.No1_100;

public class No62UniquePaths {
    public int uniquePaths1(int m, int n) {
        int[][] gra = new int[m][n];
        gra[0][0] = 1;
        for (int i = 1; i < m; i++) {
            gra[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            gra[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                gra[i][j] = gra[i][j - 1] + gra[i - 1][j];
            }
        }
        return gra[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

    int result = 0;
    int[][] dire = new int[][]{{0, 1}, {1, 0}};

    public int uniquePaths3(int m, int n) {
        dfs(m, n, 0, 0);
        return result;
    }

    void dfs(int m, int n, int x, int y) {
        if (x == m - 1 && y == n - 1) {
            result++;
            return;
        }
        for (int[] di : dire) {
            int xx = x + di[0];
            int yy = y + di[1];
            if (xx >= m || yy >= n) {
                continue;
            }
            dfs(m, n, xx, yy);
        }
    }
}
