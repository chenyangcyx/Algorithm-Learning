package QuestionBank;

import java.util.*;

public class No20ValidParentheses {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        LinkedList<Integer> stack = new LinkedList<>();
        for (char c : array) {
            if (c == '(') stack.addLast(1);
            else if (c == '{') stack.addLast(2);
            else if (c == '[') stack.addLast(3);
            else if (c == ')') {
                if (stack.isEmpty()) return false;
                int top = stack.pollLast();
                if (top != 1) return false;
            } else if (c == '}') {
                if (stack.isEmpty()) return false;
                int top = stack.pollLast();
                if (top != 2) return false;
            } else if (c == ']') {
                if (stack.isEmpty()) return false;
                int top = stack.pollLast();
                if (top != 3) return false;
            }
        }
        return stack.isEmpty();
    }
}
