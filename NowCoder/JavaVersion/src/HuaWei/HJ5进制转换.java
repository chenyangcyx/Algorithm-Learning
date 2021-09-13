package HuaWei;

import java.util.HashMap;
import java.util.Scanner;

public class HJ5进制转换 {
    public static void main(String[] args) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>() {
            {
                put('0', 0);
                put('1', 1);
                put('2', 2);
                put('3', 3);
                put('4', 4);
                put('5', 5);
                put('6', 6);
                put('7', 7);
                put('8', 8);
                put('9', 9);
                put('A', 10);
                put('B', 11);
                put('C', 12);
                put('D', 13);
                put('E', 14);
                put('F', 15);
            }
        };
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine().substring(2);
            Integer result = 0;
            char[] array = input.toCharArray();
            int pow = 1;
            for (int i = array.length - 1; i >= 0; i--) {
                char ch = array[i];
                result += hashMap.get(ch) * pow;
                pow <<= 4;
            }
            System.out.println(result);
        }
    }
}
