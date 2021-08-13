package QuestionBank.No101_200;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class No200NumberofIslands {
    int m, n;
    int[][] dire = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        No200NumberofIslands no200NumberofIslands = new No200NumberofIslands();

        char[][] grid1 = new char[][]
                {{'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}};
        char[][] grid2 = new char[][]
                {{'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}};

//        System.out.println(no200NumberofIslands.numIslands(grid1));
//        System.out.println(no200NumberofIslands.numIslands(grid2));

        System.out.println(no200NumberofIslands.myBFS(grid1));
        System.out.println(no200NumberofIslands.myBFS(grid2));
    }

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    myDfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    void myDfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        for (int[] di : dire) {
            int xx = x + di[0];
            int yy = y + di[1];
            if (xx < 0 || yy < 0 || xx >= m || yy >= n || grid[xx][yy] == '0') {
                continue;
            }
            myDfs(grid, xx, yy);
        }
    }

    int myBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int gm = grid.length;
        int gn = grid[0].length;
        int[][] bfs_dire = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int result = 0;
        for (int i = 0; i < gm; i++) {
            for (int j = 0; j < gn; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    grid[i][j] = '0';
                    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                    queue.offer(new Pair<>(i, j));
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> now_node = queue.poll();
                        for (int[] di : bfs_dire) {
                            int xx = now_node.getKey() + di[0];
                            int yy = now_node.getValue() + di[1];
                            if (xx < 0 || yy < 0 || xx >= gm || yy >= gn || grid[xx][yy] == '0') {
                                continue;
                            }
                            queue.offer(new Pair<>(xx, yy));
                            grid[xx][yy] = '0';
                        }
                    }
                }
            }
        }
        return result;
    }

    // LeetCode题解1：DFS
    class Solution1 {
        void dfs(char[][] grid, int r, int c) {
            int nr = grid.length;
            int nc = grid[0].length;

            if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
                return;
            }

            grid[r][c] = '0';
            dfs(grid, r - 1, c);
            dfs(grid, r + 1, c);
            dfs(grid, r, c - 1);
            dfs(grid, r, c + 1);
        }

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            int num_islands = 0;
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        ++num_islands;
                        dfs(grid, r, c);
                    }
                }
            }

            return num_islands;
        }
    }

    // LeetCode题解2：BFS
    class Solution2 {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            int num_islands = 0;

            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        ++num_islands;
                        grid[r][c] = '0';
                        Queue<Integer> neighbors = new LinkedList<>();
                        neighbors.add(r * nc + c);
                        while (!neighbors.isEmpty()) {
                            int id = neighbors.remove();
                            int row = id / nc;
                            int col = id % nc;
                            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                                neighbors.add((row - 1) * nc + col);
                                grid[row - 1][col] = '0';
                            }
                            if (row + 1 < nr && grid[row + 1][col] == '1') {
                                neighbors.add((row + 1) * nc + col);
                                grid[row + 1][col] = '0';
                            }
                            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                                neighbors.add(row * nc + col - 1);
                                grid[row][col - 1] = '0';
                            }
                            if (col + 1 < nc && grid[row][col + 1] == '1') {
                                neighbors.add(row * nc + col + 1);
                                grid[row][col + 1] = '0';
                            }
                        }
                    }
                }
            }

            return num_islands;
        }
    }

    // LeetCode题解3：并查集
    class Solution3 {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            int num_islands = 0;
            UnionFind uf = new UnionFind(grid);
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        grid[r][c] = '0';
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            uf.union(r * nc + c, (r - 1) * nc + c);
                        }
                        if (r + 1 < nr && grid[r + 1][c] == '1') {
                            uf.union(r * nc + c, (r + 1) * nc + c);
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            uf.union(r * nc + c, r * nc + c - 1);
                        }
                        if (c + 1 < nc && grid[r][c + 1] == '1') {
                            uf.union(r * nc + c, r * nc + c + 1);
                        }
                    }
                }
            }

            return uf.getCount();
        }

        class UnionFind {
            int count;
            int[] parent;
            int[] rank;

            public UnionFind(char[][] grid) {
                count = 0;
                int m = grid.length;
                int n = grid[0].length;
                parent = new int[m * n];
                rank = new int[m * n];
                for (int i = 0; i < m; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (grid[i][j] == '1') {
                            parent[i * n + j] = i * n + j;
                            ++count;
                        }
                        rank[i * n + j] = 0;
                    }
                }
            }

            public int find(int i) {
                if (parent[i] != i) parent[i] = find(parent[i]);
                return parent[i];
            }

            public void union(int x, int y) {
                int rootx = find(x);
                int rooty = find(y);
                if (rootx != rooty) {
                    if (rank[rootx] > rank[rooty]) {
                        parent[rooty] = rootx;
                    } else if (rank[rootx] < rank[rooty]) {
                        parent[rootx] = rooty;
                    } else {
                        parent[rooty] = rootx;
                        rank[rootx] += 1;
                    }
                    --count;
                }
            }

            public int getCount() {
                return count;
            }
        }
    }
}
