package Contest2;

import java.util.*;

public class No2_1 {
    public void No2_1() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            String str = sc.nextLine();
            String[] split = str.split(",");
            HashSet<Character> allnode_char = new HashSet<>();
            for (String _str : split) {
                char node1 = _str.charAt(0);
                char node2 = _str.charAt(2);
                allnode_char.add(node1);
                allnode_char.add(node2);
            }
            int node_num = allnode_char.size();
            int[][] graph = new int[node_num][node_num];
            int[] in_num = new int[node_num];
            for (String _str : split) {
                int node1 = _str.charAt(0) - 'a';
                int node2 = _str.charAt(2) - 'a';
                graph[node1][node2] = graph[node2][node1] = 1;
                in_num[node2]++;
            }
//            // 输出所有的map内容
//            for (int i = 0; i < node_num; i++) {
//                for (int j = 0; j < node_num; j++)
//                    System.out.print(graph[i][j] + " ");
//                System.out.println();
//            }
            // 开始进行拓扑排序
            ArrayList<LinkedList<Integer>> result = new ArrayList<>();
            boolean[] vis = new boolean[node_num];
            dfs(graph, in_num, vis, result, new LinkedList<>());
            System.out.println(result.size());
        }
    }

    private void dfs(int[][] graph, int[] in_num, boolean[] vis, ArrayList<LinkedList<Integer>> result, LinkedList<Integer> path) {
        if (path.size() >= graph.length) {
//            System.out.println("找到一个结果，加入！");
            result.add(new LinkedList<>(path));
            return;
        }
        // 获取所有入度为0的节点
        LinkedList<Integer> zeros = new LinkedList<>();
        LinkedList<Integer> deleted = new LinkedList<>();
        for (int i = 0; i < in_num.length; i++) {
            if (in_num[i] == 0 && !vis[i]) zeros.addLast(i);
        }
//        System.out.println("zeros的节点：" + zeros.toString());
        // 遍历所有节点，尝试
        for (int i = 0; i < zeros.size(); i++) {
            path.add(zeros.get(i));
            vis[zeros.get(i)] = true;
            for (int n = 0; n < in_num.length; n++) {
                if (graph[zeros.get(i)][n] == 1 || graph[n][zeros.get(i)] == 1) {
                    graph[zeros.get(i)][n] = graph[n][zeros.get(i)] = 0;
                    in_num[n]--;
                    deleted.addLast(n);
                }
            }
//            System.out.println("被删除入度的节点：" + deleted.toString());
            // 输出更新之后in_num矩阵
//            System.out.println("更新之后in_num矩阵：" + Arrays.toString(in_num));
//            System.out.println("此时的path：" + path.toString());
            dfs(graph, in_num, vis, result, path);
            vis[zeros.get(i)] = false;
            path.pollLast();
            for (int j = 0; j < deleted.size(); j++) {
                graph[zeros.get(i)][deleted.get(j)] = graph[deleted.get(j)][zeros.get(i)] = 1;
                in_num[deleted.get(j)]++;
            }
            deleted.pollLast();
        }
    }
}


//package SecondExercise;
//
//        import java.util.*;
//
//public class Problem0201 {
//    /*
//    拓扑排序解的个数
//    Description
//    给定有向无环图中所有边，计算图的拓扑排序解的个数。
//
//    Input
//    输入第一行为用例个数，后面每一行表示一个图中的所有边，边的起点和终点用空格隔开，边之间使用逗号隔开。
//
//    Output
//    输出拓扑排序解的个数。
//     */
//
//    /**
//     *
//     * @param graph 邻接矩阵
//     * @param indegree 入度数组
//     * @param zeros 入度为0的节点列表
//     * @param isVisited 标志节点是否已访问
//     * @param list 记录当前拓扑
//     * @param res 所有拓扑的列表
//     */
//    public static void topo(int[][] graph, int[] indegree, List<Integer> zeros, boolean[] isVisited, ArrayList<Integer> list, List<List<Integer>> res) {
//        if (list.size() >= graph.length) { //所有点都已访问
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = 0; i < zeros.size(); i++) {
//            int index = zeros.get(i);
//            if (!isVisited[index]) {
//                list.add(index); //将顶点插入拓扑排序中
//                isVisited[index] = true;
//                List<Integer> deleteEdge = new ArrayList<>(); //记录删去的边的终点
//                int cnt = 0; //记录新的入度为0的顶点个数
//                for (int j = 0; j < graph.length; j++) { //将index顶点出发的边删除
//                    if (graph[index][j] == 1) {
//                        deleteEdge.add(j);
//                        indegree[j]--;
//                        graph[index][j] = 0;
//                        if (indegree[j] == 0) {
//                            zeros.add(j);
//                            cnt++;
//                        }
//                    }
//                }
//                topo(graph, indegree, zeros, isVisited, list, res);
//                //将删除的边恢复，将点的访问状态重置
//                isVisited[index] = false;
//                list.remove(list.size() - 1);
//                for (int j = 0; j < cnt; j++) {
//                    zeros.remove(zeros.size() - 1);
//                }
//                for (Integer endIndex : deleteEdge) {
//                    graph[index][endIndex] = 1;
//                    indegree[endIndex]++;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int T = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < T; i++) {
//            String[] edges = scanner.nextLine().split(",");
//            Set<String> vertex = new HashSet<>();
//            for (String edge: edges) {
//                String[] v = edge.split(" ");
//                vertex.add(v[0]);
//                vertex.add(v[1]);
//            }
//            int n = vertex.size();
//            int[][] graph = new int[n][n]; //邻接矩阵
//            int[] indegree = new int[n]; //记录所有顶点的入度
//            for (String edge: edges) {
//                String[] v = edge.split(" ");
//                int x = v[0].charAt(0) - 'a';
//                int y = v[1].charAt(0) - 'a';
//                graph[x][y] = 1;
//                indegree[y]++;
//            }
//            List<Integer> zeros = new ArrayList<>(); //记录入度为0的点
//            for (int j = 0; j < n; j++) {
//                if (indegree[j] == 0) {
//                    zeros.add(j);
//                }
//            }
//            boolean[] isVisited = new boolean[n]; //标志节点是否访问，即是否已加入拓扑队列中
//            List<List<Integer>> res = new ArrayList<>();//存放所有拓扑排序结果
//            topo(graph, indegree, zeros, isVisited, new ArrayList<Integer>(), res);
//            System.out.println(res.size());
//        }
//    }
//}