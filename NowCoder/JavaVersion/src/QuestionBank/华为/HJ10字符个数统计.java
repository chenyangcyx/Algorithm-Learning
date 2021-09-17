package QuestionBank.华为;

import java.util.HashSet;
import java.util.Scanner;

public class HJ10字符个数统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        HashSet<Character> hashSet = new HashSet<>();
        for (char ch : input.toCharArray()) {
            hashSet.add(ch);
        }
        System.out.println(hashSet.size());
    }
}
