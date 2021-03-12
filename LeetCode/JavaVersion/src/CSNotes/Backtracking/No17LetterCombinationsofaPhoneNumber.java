package CSNotes.Backtracking;

import java.util.*;

public class No17LetterCombinationsofaPhoneNumber {
    char[][] chars = new char[][]{{}, {}, {'a', 'b', 'c'},
            {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        StringBuilder sb = new StringBuilder();
        dfs(digits, digits.length(), 0, result, sb);
        return result;
    }

    private void dfs(String digits, int length, int depth, ArrayList<String> result, StringBuilder sb) {
        if (depth == length) {
            result.add(sb.toString());
            return;
        }
        char[] allchar = chars[digits.charAt(depth) - '0'];
        for (char c : allchar) {
            sb.append(c);
            dfs(digits, length, depth + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // CS-Note参考代码
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations2(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        doCombination(new StringBuilder(), combinations, digits);
        return combinations;
    }

    private void doCombination(StringBuilder prefix, List<String> combinations, final String digits) {
        if (prefix.length() == digits.length()) {
            combinations.add(prefix.toString());
            return;
        }
        int curDigits = digits.charAt(prefix.length()) - '0';
        String letters = KEYS[curDigits];
        for (char c : letters.toCharArray()) {
            prefix.append(c);                         // 添加
            doCombination(prefix, combinations, digits);
            prefix.deleteCharAt(prefix.length() - 1); // 删除
        }
    }
}
