package QuestionBank.华为;

import java.util.HashSet;
import java.util.Scanner;

public class HJ9提取不重复的整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = String.valueOf(sc.nextInt());
            char[] array = input.toCharArray();
            HashSet<Character> set = new HashSet<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = array.length - 1; i >= 0; i--) {
                if (set.add(array[i])) {
                    stringBuilder.append(array[i]);
                }
            }
            System.out.println(stringBuilder);
        }
    }
}
