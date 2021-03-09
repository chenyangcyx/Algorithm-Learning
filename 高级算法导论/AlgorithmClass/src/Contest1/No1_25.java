package Contest1;

import javafx.util.Pair;

import java.util.*;

public class No1_25 {
    public class NumCount {
        int num;
        int count = 0;

        public NumCount(int n, int c) {
            this.num = n;
            this.count = c;
        }

        public int getNum() {
            return num;
        }

        public int getCount() {
            return count;
        }
    }

    public void No1_25() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int read_num = sc.nextInt();
                map.put(read_num, map.getOrDefault(read_num, 0) + 1);
            }
            PriorityQueue<NumCount> queue = new PriorityQueue<>((o1, o2) -> {
                if (o1.getCount() == o2.getCount()) return o1.getNum() - o2.getNum();
                else return o2.getCount() - o1.getCount();
            });
            for (Integer in : map.keySet()) {
                queue.add(new NumCount(in, map.get(in)));
            }
            boolean if_first = true;
            while (!queue.isEmpty()) {
                NumCount nc = queue.poll();
                for (int i = 0; i < nc.count; i++) {
                    if (if_first) {
                        System.out.print(nc.num);
                        if_first = false;
                    } else System.out.print(" " + nc.num);
                }
            }
            System.out.println();
        }
    }
}
