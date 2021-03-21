package QuestionBank;

import java.util.LinkedList;

public class No150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String to : tokens) {
            char c = to.charAt(0);
            if (to.length() == 1 && (c < '0' || c > '9')) {
                int num2 = stack.pollLast(), num1 = stack.pollLast(), result = 0;
                switch (c) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    default:
                        break;
                }
                stack.addLast(result);
            } else {
                stack.addLast(Integer.parseInt(to));
            }
        }
        return stack.pollLast();
    }
}
