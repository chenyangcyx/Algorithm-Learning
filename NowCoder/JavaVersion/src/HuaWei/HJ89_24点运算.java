package HuaWei;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HJ89_24点运算 {
    static HashMap<String, Integer> hashMap = new HashMap<String, Integer>() {
        {
            put("A", 1);
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6", 6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
            put("10", 10);
            put("J", 11);
            put("Q", 12);
            put("K", 13);
        }
    };
    static HashMap<Integer, String> opmap = new HashMap<Integer, String>() {
        {
            put(1, "+");
            put(2, "-");
            put(3, "*");
            put(4, "/");
        }
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr = input.split(" ");
        boolean flag = false;
        for (String item : arr) {
            if (item.equals("joker") || item.equals("JOKER")) {
                System.out.println("ERROR");
                flag = true;
                break;
            }
        }
        if (!flag) {
            List<List<String>> allsorts = new LinkedList<>();
            getAllSorts(arr, new boolean[4], allsorts, new LinkedList<>());
            System.out.println(findRight(allsorts));
        }
    }

    static void getAllSorts(String[] arr, boolean[] vis, List<List<String>> result, LinkedList<String> path) {
        if (path.size() == 4) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (!vis[i]) {
                path.addLast(arr[i]);
                vis[i] = true;
                getAllSorts(arr, vis, result, path);
                path.removeLast();
                vis[i] = false;
            }
        }
    }

    static int getResult(List<String> sort, List<Integer> fuhao) {
        int sum = hashMap.get(sort.get(0));
        for (int i = 0; i < 3; i++) {
            int fh = fuhao.get(i);
            int next = hashMap.get(sort.get(i + 1));
            switch (fh) {
                case 1:
                    sum += next;
                    break;
                case 2:
                    sum -= next;
                    break;
                case 3:
                    sum *= next;
                    break;
                case 4:
                    sum /= next;
                    break;
                default:
                    break;
            }
        }
        return sum;
    }

    static String findRight(List<List<String>> allsorts) {
        for (List<String> sort_item : allsorts) {
            for (int a1 = 1; a1 <= 4; a1++) {
                for (int a2 = 1; a2 <= 4; a2++) {
                    for (int a3 = 1; a3 <= 4; a3++) {
                        List<Integer> fuhao = new LinkedList<>();
                        fuhao.add(a1);
                        fuhao.add(a2);
                        fuhao.add(a3);
                        if (getResult(sort_item, fuhao) == 24) {
                            return sort_item.get(0) + opmap.get(a1) + sort_item.get(1) + opmap.get(a2) + sort_item.get(2) + opmap.get(a3) + sort_item.get(3);
                        }
                    }
                }
            }
        }
        return "NONE";
    }
}
