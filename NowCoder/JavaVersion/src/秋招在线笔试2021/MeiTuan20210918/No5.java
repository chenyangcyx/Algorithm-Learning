package 秋招在线笔试2021.MeiTuan20210918;

import java.io.*;
import java.util.HashSet;

public class No5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[] colors = new int[n + 1];
        String[] input2 = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            colors[i + 1] = Integer.parseInt(input2[i]);
        }
        HashSet<Integer> colorType = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            colorType.add(colors[i]);
        }
        if (colorType.size() != 4) {
            writer.write(String.valueOf(0));
        } else {
            writer.write(String.valueOf(n+1));
        }
        writer.flush();
    }
}
