package 秋招在线笔试2021.MeiTuan20210918;

import java.io.*;
import java.util.Arrays;

public class No4 {
    static char[][] pan = new char[][]{{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String input = reader.readLine();
            char[] arr = input.toCharArray();
            int[] pos = new int[10];
            char lastChar = 0;
            int now_num = -1, heng_times = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == '0') {
                    writer.write('-');
                    flushNumPos(pos);
                    lastChar = '0';
                } else if (arr[i] == '-') {
                    continue;
                } else {
                    int this_num = arr[i] - '0';
                    // 如果是第一个字符
                    if (i == 0) {
                        lastChar = arr[i];
                        now_num = this_num;
                        continue;
                    }
                    // 如果不是第一个字符，和上一个字符相同
                    if (lastChar == arr[i]) {
                        pos[this_num] = (pos[this_num] + 1) % pan[this_num].length;
                        lastChar = arr[i];
                    }
                    // 和上一个字符不同
                    // 输出上一个字符
                    else {
                        if (lastChar != '0') {
                            writer.write(pan[lastChar - '0'][pos[lastChar - '0']]);
                            flushNumPos(pos);
                            lastChar = arr[i];
                        } else {
                            if (i != n - 1) {
                                writer.write(pan[this_num][pos[this_num]]);
                            }
                            flushNumPos(pos);
                            lastChar = arr[i];
                        }
                    }
                    if (i == n - 1) {
                        writer.write(pan[this_num][pos[this_num]]);
                    }
                }
            }
            writer.newLine();
            writer.flush();
        }
    }

    static void flushNumPos(int[] pos) {
        Arrays.fill(pos, 0);
    }
}
