package HuaWei;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class HJ3明明的随机数 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int N = sc.nextInt();
//            HashSet<Integer> data = new HashSet<>();
//            for (int i = 0; i < N; i++) {
//                data.add(sc.nextInt());
//            }
//            ArrayList<Integer> result = new ArrayList<>(data);
//            result.sort(Comparator.comparingInt(o -> o));
//            for (Integer item : result) {
//                System.out.println(item);
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            TreeSet<Integer> treeSet = new TreeSet<>(Comparator.comparingInt(o -> o));
            for (int i = 0; i < N; i++) {
                treeSet.add(sc.nextInt());
            }
            for (Integer item : treeSet) {
                System.out.println(item);
            }
        }
    }
}
