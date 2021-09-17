package QuestionBank.华为;

import java.util.Scanner;

public class HJ4字符串分隔 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            for (int start = 0; start < input.length(); start += 8) {
                outputOneLine(input.substring(start, Math.min(start + 8, input.length())));
            }
        }
    }

    static void outputOneLine(String line) {
        System.out.print(line);
        for (int i = 0; i < 8 - line.length(); i++) {
            System.out.print('0');
        }
        System.out.println();
    }
}
