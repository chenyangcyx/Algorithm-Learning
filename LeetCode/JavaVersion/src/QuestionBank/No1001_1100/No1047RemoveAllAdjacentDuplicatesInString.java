package QuestionBank.No1001_1100;

import java.util.LinkedList;

public class No1047RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        char[] array = S.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (stack.size() == 0) stack.addLast(array[i]);
            else {
                char pre = stack.peekLast();
                if (array[i] == pre) stack.pollLast();
                else stack.addLast(array[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pollFirst());
        return sb.toString();
    }
}
