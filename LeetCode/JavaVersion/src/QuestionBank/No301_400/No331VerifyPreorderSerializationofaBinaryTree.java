package QuestionBank.No301_400;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class No331VerifyPreorderSerializationofaBinaryTree {
    // 自己写的，使用正则表达式
    // LeetCode无法编译通过
    public boolean isValidSerialization1(String preorder) {
        if (preorder.length() < 3) return false;
        Pattern p = Pattern.compile("\\d##");
        Matcher m = p.matcher(preorder);
        String str = preorder;
        while (m.find()) {
            str = m.replaceAll("#");
            m = p.matcher(str);
            System.out.println(str);
        }
        return str.length() == 1 && str.charAt(0) == '#';
    }

    // LeetCode 官方题解1
    public boolean isValidSerialization2(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    // LeetCode 官方题解2
    public boolean isValidSerialization3(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                slots--;
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++; // slots = slots - 1 + 2
            }
        }
        return slots == 0;
    }
}
