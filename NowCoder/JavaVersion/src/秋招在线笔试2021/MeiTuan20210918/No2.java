package 秋招在线笔试2021.MeiTuan20210918;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class No2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input1 = reader.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        HashSet<Integer>[] bian = new HashSet[n+1];
        for (int i = 1; i <= n; i++) {
            bian[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) {
            String[] input_line = reader.readLine().split(" ");
            int node1 = Integer.parseInt(input_line[0]);
            int node2 = Integer.parseInt(input_line[1]);
            bian[node1].add(node2);
            bian[node2].add(node1);
        }
        HashSet<String> result = new HashSet<>();
        for (int node1 = 1; node1 <= n; node1++) {
            for (int node2 = 1; node2 <= n; node2++) {
                for (int node3 = 1; node3 <= n; node3++) {
                    for (int node4 = 1; node4 <= n; node4++) {
                        for (int node5 = 1; node5 <= n; node5++) {
                            HashSet<Integer> types=new HashSet<>();
                            types.add(node1);
                            types.add(node2);
                            types.add(node3);
                            types.add(node4);
                            types.add(node5);
                            if(types.size()!=5){
                                continue;
                            }
                            ArrayList<Integer> _r = new ArrayList<>(5);
                            _r.add(node1);
                            _r.add(node2);
                            _r.add(node3);
                            _r.add(node4);
                            _r.add(node5);
                            _r.sort(Comparator.comparingInt(o->o));
                            if (result.contains(_r.toString())) {
                                continue;
                            }
                            if (checkIfConnect(node1, node2, bian)
                                    && checkIfConnect(node2, node3, bian)
                                    && checkIfConnect(node3, node4, bian)
                                    && checkIfConnect(node4, node5, bian)) {
                                result.add(_r.toString());
                            }
                        }
                    }
                }
            }
        }
        writer.write(String.valueOf(result.size()));
        writer.flush();
    }

    static boolean checkIfConnect(int node1, int node2, HashSet<Integer>[] con) {
        return con[node1].contains(node2) || con[node2].contains(node1);
    }
}
