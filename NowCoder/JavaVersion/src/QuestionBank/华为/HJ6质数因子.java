package QuestionBank.华为;

import java.util.Scanner;

public class HJ6质数因子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println(num == 1 ? "" : num + " ");
    }
}
