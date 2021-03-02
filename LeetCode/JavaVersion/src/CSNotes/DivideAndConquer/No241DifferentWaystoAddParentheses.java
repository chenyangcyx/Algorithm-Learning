package CSNotes.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class No241DifferentWaystoAddParentheses {
    // 自己写的代码
    public List<Integer> diffWaysToCompute1(String input) {
        List<Integer> result_list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String str1 = input.substring(0, i);
                String str2 = input.substring(i + 1);
                List<Integer> value1 = diffWaysToCompute1(str1);
                List<Integer> value2 = diffWaysToCompute1(str2);
                for (int v1 : value1) {
                    for (int v2 : value2) {
                        switch (c) {
                            case '+':
                                result_list.add(v1 + v2);
                                break;
                            case '-':
                                result_list.add(v1 - v2);
                                break;
                            case '*':
                                result_list.add(v1 * v2);
                                break;
                        }
                    }
                }

            }
        }
        if(result_list.size()==0) result_list.add(Integer.valueOf(input));
        return result_list;
    }

    // CS-Note参考代码
    public List<Integer> diffWaysToCompute2(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute2(input.substring(0, i));
                List<Integer> right = diffWaysToCompute2(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
}
