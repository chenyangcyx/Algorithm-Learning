package QuestionBank.No1_100;

import java.util.HashMap;
import java.util.Map;

public class No8StringtoInteger_atoi {
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;
        char[] array = s.toCharArray();
        long result = 0, flag = 1;
        boolean getnum = false;
        for (char c : array) {
            if (c == ' ' && !getnum) continue;
            else if (c == '+' && !getnum) {
                flag = 1;
                getnum = true;
            } else if (c == '-' && !getnum) {
                flag = -1;
                getnum = true;
            } else if (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                if (result * flag > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (result * flag < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                getnum = true;
            } else break;
        }
        return (int) (result * flag);
    }

    // LeetCode 参考代码
    // 有限状态机
    class Solution {
        public int myAtoi(String str) {
            Automaton automaton = new Automaton();
            int length = str.length();
            for (int i = 0; i < length; ++i) {
                automaton.get(str.charAt(i));
            }
            return (int) (automaton.sign * automaton.ans);
        }
    }

    class Automaton {
        private final Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};
        public int sign = 1;
        public long ans = 0;
        private String state = "start";

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }
}
