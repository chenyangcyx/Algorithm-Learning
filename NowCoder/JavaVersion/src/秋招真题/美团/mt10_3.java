//package 秋招真题.美团;
//
//import java.io.*;
//import java.util.Comparator;
//import java.util.TreeSet;
//
//public class mt10_3 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//        int T = Integer.parseInt(reader.readLine());
//        while (T-- > 0) {
//            int N = Integer.parseInt(reader.readLine());
//            String input2 = reader.readLine();
//            int M = Integer.parseInt(reader.readLine());
//            String input4 = reader.readLine();
//            // 处理所有座位信息
//            TreeSet<Integer> seats0 = new TreeSet<>(Comparator.comparingInt(o -> o));
//            TreeSet<Integer> seats1 = new TreeSet<>(Comparator.comparingInt(o -> o));
//            for (int i = 0; i < N; i++) {
//                int _num = Integer.parseInt(input2.substring(i, i + 1));
//                if (_num == 0) {
//                    seats0.add(i + 1);
//                } else if (_num == 1) {
//                    seats1.add(i + 1);
//                }
//            }
//            for (char ch : input4.toCharArray()) {
//                if (ch == 'M') {
//                    if (seats1.size() != 0) {
//                        int _s = seats1.pollFirst();
//                        writer.write(String.valueOf(_s));
//                        writer.newLine();
//                    } else {
//                        int _s = seats0.pollFirst();
//                        writer.write(String.valueOf(_s));
//                        writer.newLine();
//                        seats1.add(_s);
//                    }
//                } else {
//                    if (seats0.size() != 0) {
//                        int _s = seats0.pollFirst();
//                        writer.write(String.valueOf(_s));
//                        writer.newLine();
//                        seats1.add(_s);
//                    } else {
//                        int _s = seats1.pollFirst();
//                        writer.write(String.valueOf(_s));
//                        writer.newLine();
//                    }
//                }
//            }
//            writer.flush();
//        }
//    }
//}

// 写法2，使用PriorityQueue
package 秋招真题.美团;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class mt10_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(reader.readLine());
            String input2 = reader.readLine();
            int M = Integer.parseInt(reader.readLine());
            String input4 = reader.readLine();
            // 处理所有座位信息
            PriorityQueue<Integer> seats0 = new PriorityQueue<>(N, Comparator.comparingInt(o -> o));
            PriorityQueue<Integer> seats1 = new PriorityQueue<>(N, Comparator.comparingInt(o -> o));
            for (int i = 0; i < N; i++) {
                int _num = Integer.parseInt(input2.substring(i, i + 1));
                if (_num == 0) {
                    seats0.offer(i + 1);
                } else if (_num == 1) {
                    seats1.offer(i + 1);
                }
            }
            for (char ch : input4.toCharArray()) {
                if (ch == 'M') {
                    if (seats1.size() != 0) {
                        int _s = seats1.poll();
                        writer.write(String.valueOf(_s));
                        writer.newLine();
                    } else {
                        int _s = seats0.poll();
                        writer.write(String.valueOf(_s));
                        writer.newLine();
                        seats1.add(_s);
                    }
                } else {
                    if (seats0.size() != 0) {
                        int _s = seats0.poll();
                        writer.write(String.valueOf(_s));
                        writer.newLine();
                        seats1.add(_s);
                    } else {
                        int _s = seats1.poll();
                        writer.write(String.valueOf(_s));
                        writer.newLine();
                    }
                }
            }
            writer.flush();
        }
    }
}
