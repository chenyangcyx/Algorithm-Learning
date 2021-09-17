package 秋招在线笔试2021.HuaWei20210915;

import java.util.*;

public class No3 {
    static HashMap<String, int[]> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] sp = input.split(",");
            hashMap.put(sp[0], new int[]{Integer.parseInt(sp[1]), Integer.parseInt(sp[2])});
        }
        LinkedList<LinkedList<String>> result = new LinkedList<>();
        dfs(result, new ArrayList<>(hashMap.keySet()), 0, new LinkedList<>());
        result.sort((o1, o2) -> {
            if (o1.size() != o2.size()) {
                return o2.size() - o1.size();
            } else {
                return o1.toString().compareTo(o2.toString());
            }
        });
        int max_value = Integer.MIN_VALUE;
        List<String> max_result = null;
        for (List<String> item : result) {
            if (ifCanSell(item)) {
                int feiyong = calFeiyong(item);
                if (feiyong > max_value) {
                    max_value = feiyong;
                    max_result = item;
                }
            }
        }
        System.out.println(String.join(" ", max_result));
    }

    static void dfs(LinkedList<LinkedList<String>> result, ArrayList<String> names, int index, LinkedList<String> path) {
        if (path.size() != 0) {
            result.addFirst(new LinkedList<>(path));
        }
        for (int i = index; i < names.size(); i++) {
            path.addLast(names.get(i));
            dfs(result, names, i + 1, path);
            path.pollLast();
        }
    }

    static boolean ifCanSell(List<String> list) {
        if (list.size() == 1) {
            return true;
        }
        List<int[]> qujian = new ArrayList<>();
        for (String item : list) {
            qujian.add(new int[]{hashMap.get(item)[0], hashMap.get(item)[1]});
        }
        qujian.sort(((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }));
        for (int i = 1; i < qujian.size(); i++) {
//            int st0=qujian.get(i-1)[0];
            int en0 = qujian.get(i - 1)[1];
            int st1 = qujian.get(i)[0];
//            int en1=qujian.get(i)[1];
            if (st1 < en0) {
                return false;
            }
        }
        return true;
    }

    static int calFeiyong(List<String> list) {
        int sum = 0;
        for (String item : list) {
            int st = hashMap.get(item)[0];
            int en = hashMap.get(item)[1];
            sum += calOneFeiYong(st, en);
        }
        return sum;
    }

    static int calOneFeiYong(int st, int en) {
        int diff = en - st;
        switch (diff) {
            case 2:
                return 180;
            case 3:
                return 240;
            case 4:
                return 280;
            case 1:
                return 100;
        }
        return 100 * diff;
    }
}
