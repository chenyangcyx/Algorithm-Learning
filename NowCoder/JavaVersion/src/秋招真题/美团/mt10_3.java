package 秋招真题.美团;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class mt10_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            int N = Integer.parseInt(sc.nextLine());
            String input2 = sc.nextLine();
            int M = Integer.parseInt(sc.nextLine());
            String input4 = sc.nextLine();
            // 处理所有座位信息
            TreeSet<Integer> seats0 = new TreeSet<>(Comparator.comparingInt(o -> o));
            TreeSet<Integer> seats1 = new TreeSet<>(Comparator.comparingInt(o -> o));
            TreeSet<Integer> seats2 = new TreeSet<>(Comparator.comparingInt(o -> o));
            for (int i = 0; i < N; i++) {
                int _num = Integer.parseInt(input2.substring(i, i + 1));
                if (_num == 0) {
                    seats0.add(i + 1);
                } else if (_num == 1) {
                    seats1.add(i + 1);
                } else {
                    seats2.add(i + 1);
                }
            }
            for (char ch : input4.toCharArray()) {
                if (ch == 'M') {
                    if (seats1.size() != 0) {
                        int _s = seats1.pollFirst();
                        System.out.println(_s);
                        seats2.add(_s);
                    } else {
                        int _s = seats0.pollFirst();
                        System.out.println(_s);
                        seats1.add(_s);
                    }
                } else {
                    if (seats0.size() != 0) {
                        int _s = seats0.pollFirst();
                        System.out.println(_s);
                        seats1.add(_s);
                    } else {
                        int _s = seats1.pollFirst();
                        System.out.println(_s);
                        seats2.add(_s);
                    }
                }
            }
        }
    }
}
