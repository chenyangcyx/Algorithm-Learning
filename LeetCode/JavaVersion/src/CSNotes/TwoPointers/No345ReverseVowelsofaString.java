package CSNotes.TwoPointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class No345ReverseVowelsofaString {
    private final HashSet<Character> yuanyin= new HashSet<>(){
        {
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }
    };

    public String reverseVowels(String s) {
        int i=0,j=s.length()-1;
        char []res=s.toCharArray();
        while (i<j){
            char i_char=s.charAt(i);
            char j_char=s.charAt(j);
            if(!yuanyin.contains(i_char)){
                i++;
            }
            else if(!yuanyin.contains(j_char)){
                j--;
            }
            else {
                res[i++]=j_char;
                res[j--]=i_char;
            }
        }
        return new String(res);
    }
}
