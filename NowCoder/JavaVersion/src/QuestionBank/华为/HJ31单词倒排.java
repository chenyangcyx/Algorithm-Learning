package QuestionBank.华为;

import java.util.ArrayList;
import java.util.Scanner;

public class HJ31单词倒排 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // 去除无关字符
        input = input.replaceAll("[^a-zA-Z]", " ");
        // 以空格分割字符串
        String[] arr = input.split(" ");

        ArrayList<String> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                list.add(arr[i]);
            }
        }
        System.out.println(String.join(" ", list));
    }
}
