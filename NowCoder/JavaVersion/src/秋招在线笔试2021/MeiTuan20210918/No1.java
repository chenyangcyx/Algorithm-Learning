package 秋招在线笔试2021.MeiTuan20210918;

import java.io.*;
import java.util.HashSet;

public class No1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String input_line = reader.readLine();
            if (input_line.length() == 1) {
                writer.write("NO");
                continue;
            }
            HashSet<Character> hashSet = new HashSet<>();
            for (char ch : input_line.toCharArray()) {
                hashSet.add(ch);
            }
            if (hashSet.size() == 1) {
                writer.write("NO");
            } else {
                writer.write("YES");
            }
        }
        writer.flush();
    }
}
