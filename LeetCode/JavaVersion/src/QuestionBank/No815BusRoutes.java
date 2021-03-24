package QuestionBank;

import java.util.*;

public class No815BusRoutes {
    class Node {
        int bus_index;
        int station_index;
        int level;

        public Node(int b, int s, int l) {
            this.bus_index = b;
            this.station_index = s;
            this.level = l;
        }
    }

    boolean[][] vis;
    LinkedList<Node> queue;

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        // 初始化boolean数组
        vis = new boolean[routes.length][];
        for (int i = 0; i < routes.length; i++) vis[i] = new boolean[routes[i].length];
        queue = new LinkedList<>();
        // 将含有出发站台的公交站台全部都加入到队列
        for (int i = 0; i < routes.length; i++) {
            int _res = hasThisStation(source, routes[i]);
            if (_res != -1) {
                queue.add(new Node(i, _res, 1));
                vis[i][_res] = true;
            }
        }
        // 开始进行BFS
        return bfs(routes, target);
    }

    private int bfs(int[][] routes, int target) {
        while (!queue.isEmpty()) {
            Node curnode = queue.pollFirst();
//            System.out.println("现在遍历的是" + curnode.bus_index + "车的第" + curnode.station_index + "个节点：" + routes[curnode.bus_index][curnode.station_index] + "，level：" + curnode.level);
            if (routes[curnode.bus_index][curnode.station_index] == target) {
                return curnode.level;
            }
            // 优先选择这一趟公交车的所有站台
            for (int i = 0; i < routes[curnode.bus_index].length; i++) {
                if (!vis[curnode.bus_index][i]) {
                    queue.addLast(new Node(curnode.bus_index, i, curnode.level));
                    vis[curnode.bus_index][i] = true;
                }
            }
            // 查看是否有其他公交车路线经过该站台
            for (int i = 0; i < routes.length; i++) {
                if (i != curnode.bus_index) {
                    int _res = hasThisStation(routes[curnode.bus_index][curnode.station_index], routes[i]);
                    if (_res != -1 && !vis[i][_res]) {
                        queue.addLast(new Node(i, _res, curnode.level + 1));
                        vis[i][_res] = true;
                    }
                }
            }
        }
        return -1;
    }

    private int hasThisStation(int station_no, int[] bus_no) {
        for (int i = 0; i < bus_no.length; i++) {
            if (bus_no[i] == station_no) return i;
        }
        return -1;
    }
}

// LeetCode 参考代码
/*
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S==T) return 0;
        int N = routes.length;

        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < N; ++i) {
            Arrays.sort(routes[i]);
            graph.add(new ArrayList());
        }
        Set<Integer> seen = new HashSet();
        Set<Integer> targets = new HashSet();
        Queue<Point> queue = new ArrayDeque();

        // Build the graph.  Two buses are connected if
        // they share at least one bus stop.
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j)
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }

        // Initialize seen, queue, targets.
        // seen represents whether a node has ever been enqueued to queue.
        // queue handles our breadth first search.
        // targets is the set of goal states we have.
        for (int i = 0; i < N; ++i) {
            if (Arrays.binarySearch(routes[i], S) >= 0) {
                seen.add(i);
                queue.offer(new Point(i, 0));
            }
            if (Arrays.binarySearch(routes[i], T) >= 0)
                targets.add(i);
        }

        while (!queue.isEmpty()) {
            Point info = queue.poll();
            int node = info.x, depth = info.y;
            if (targets.contains(node)) return depth+1;
            for (Integer nei: graph.get(node)) {
                if (!seen.contains(nei)) {
                    seen.add(nei);
                    queue.offer(new Point(nei, depth+1));
                }
            }
        }

        return -1;
    }

    public boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) return true;
            if (A[i] < B[j]) i++; else j++;
        }
        return false;
    }
}
*/