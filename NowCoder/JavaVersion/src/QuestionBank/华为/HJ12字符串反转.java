package QuestionBank.华为;

import java.util.Scanner;

public class HJ12字符串反转 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = input.length() - 1; i >= 0; i--) {
//            stringBuilder.append(input.charAt(i));
//        }
//        System.out.println(stringBuilder);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new StringBuilder(sc.nextLine()).reverse());
    }
}
