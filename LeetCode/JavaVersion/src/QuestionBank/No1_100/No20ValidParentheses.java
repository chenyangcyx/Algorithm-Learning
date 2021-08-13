package QuestionBank.No1_100;

import java.util.LinkedList;

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


// LeetCode 题解
/*
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
*/