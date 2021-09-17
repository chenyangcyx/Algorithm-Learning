package QuestionBank.华为;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ8合并表记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> o1 - o2);
            for (int i = 0; i < N; i++) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                map.put(n1, map.getOrDefault(n1, 0) + n2);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
