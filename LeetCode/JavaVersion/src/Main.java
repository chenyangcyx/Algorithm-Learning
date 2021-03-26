import QuestionBank.No344ReverseString;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char []s="hello".toCharArray();
        No344ReverseString rs=new No344ReverseString();
        rs.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
