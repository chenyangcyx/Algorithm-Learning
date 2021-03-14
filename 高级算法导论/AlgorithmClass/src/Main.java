import java.util.*;

public class Main {
    public static void main(String[] args) {
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

    private static void dfs(int[][] graph, int[] in_num, boolean[] vis, ArrayList<LinkedList<Integer>> result, LinkedList<Integer> path) {
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