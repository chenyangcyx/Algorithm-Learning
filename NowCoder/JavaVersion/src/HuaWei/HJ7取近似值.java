package HuaWei;

import java.util.Scanner;

public class HJ7取近似值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double input = sc.nextDouble();
            System.out.println(Math.round(input));
        }
    }
}
