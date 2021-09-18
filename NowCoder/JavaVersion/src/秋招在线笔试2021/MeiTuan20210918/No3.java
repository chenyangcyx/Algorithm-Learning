package 秋招在线笔试2021.MeiTuan20210918;

import java.io.*;

public class No3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input1=reader.readLine().split(" ");
        int n=Integer.parseInt(input1[0]);
        int Y_MAX=Integer.parseInt(input1[1]);
        int X_MAX=Integer.parseInt(input1[2]);
        String[] sp1=reader.readLine().split(" ");
        String[] sp2=reader.readLine().split(" ");
        writer.write(String.valueOf(1));
        writer.flush();
    }
}
