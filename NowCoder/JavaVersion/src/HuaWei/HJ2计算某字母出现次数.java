package HuaWei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class HJ2计算某字母出现次数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> hashMap = new HashMap<>();
        ArrayList<String> input = new ArrayList<>();
        while (sc.hasNext()) {
            input.add(sc.nextLine());
        }
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            if (line.length() == input.size() - 1) {
                System.out.println(hashMap.getOrDefault(line.toUpperCase(Locale.ROOT).charAt(0), 0));
                break;
            }
            for (char ch : line.toCharArray()) {
                char chara = String.valueOf(ch).toUpperCase(Locale.ROOT).charAt(0);
                hashMap.put(chara, hashMap.getOrDefault(chara, 0) + 1);
            }
        }
    }
}
