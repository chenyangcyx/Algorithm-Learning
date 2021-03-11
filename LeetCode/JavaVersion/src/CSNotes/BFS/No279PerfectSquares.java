package CSNotes.BFS;

import java.util.*;

public class No279PerfectSquares {
    public int numSquares1(int n) {
        // 构造出1-n之间的平方和
        ArrayList<Integer> pownum = new ArrayList<>();
        int squre = 1, diff = 3;
        while (squre <= n) {
            pownum.add(squre);
            squre += diff;
            diff += 2;
        }
        // 记录该结果是否已经被记录，剪枝
        HashMap<Integer, Boolean> vis = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(n);
        int level = 0;
        vis.put(n, true);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int q = queue.pollFirst();
                if (pownum.contains(q)) return level;
                for (int num : pownum) {
                    int p = q - num;
                    if (p < 0) break;
                    if (!vis.getOrDefault(p, false)) {
                        queue.addLast(p);
                        vis.put(p, true);
                    }
                }
            }
        }
        return 0;
    }

    // CS-Note参考代码
    public int numSquares2(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return level;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    /**
     * 生成小于 n 的平方数序列
     *
     * @return 1, 4, 9, ...
     */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}
