package CSNotes.TwoPointers;

import java.util.HashSet;

public class No345ReverseVowelsofaString {
    private final HashSet<Character> yuanyin = new HashSet<>();

    public String reverseVowels(String s) {
        yuanyin.add('a');
        yuanyin.add('e');
        yuanyin.add('i');
        yuanyin.add('o');
        yuanyin.add('u');
        yuanyin.add('A');
        yuanyin.add('E');
        yuanyin.add('I');
        yuanyin.add('O');
        yuanyin.add('U');
        int i = 0, j = s.length() - 1;
        char[] res = s.toCharArray();
        while (i < j) {
            char i_char = s.charAt(i);
            char j_char = s.charAt(j);
            if (!yuanyin.contains(i_char)) {
                i++;
            } else if (!yuanyin.contains(j_char)) {
                j--;
            } else {
                res[i++] = j_char;
                res[j--] = i_char;
            }
        }
        return new String(res);
    }
}
