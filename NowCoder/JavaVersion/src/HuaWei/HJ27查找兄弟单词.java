package HuaWei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HJ27查找兄弟单词 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] input_arr = input.split(" ");
        int N = Integer.parseInt(input_arr[0]);
        ArrayList<String> word_list = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            word_list.add(input_arr[i]);
        }
        String search = input_arr[1 + N];
        int k = Integer.parseInt(input_arr[2 + N]);

        ArrayList<String> brother_list = new ArrayList<>(N);
        for (String word : word_list) {
            if (ifBrotherWord(search, word)) {
                brother_list.add(word);
            }
        }
        brother_list.sort((String::compareTo));
        System.out.println(brother_list.size());
        if (brother_list.size() != 0 && k - 1 <= brother_list.size()) {
            System.out.println(brother_list.get(k - 1));
        }
    }

    static boolean ifBrotherWord(String word1, String word2) {
        if (word1.length() != word2.length() || word1.equals(word2)) {
            return false;
        }
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        for (char ch : word1.toCharArray()) {
            hashMap1.put(ch, hashMap1.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        for (char ch : word2.toCharArray()) {
            hashMap2.put(ch, hashMap2.getOrDefault(ch, 0) + 1);
        }
        return hashMap1.toString().equals(hashMap2.toString());
    }
}
