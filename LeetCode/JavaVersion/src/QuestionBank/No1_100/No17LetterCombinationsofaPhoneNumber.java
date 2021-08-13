package QuestionBank.No1_100;

import java.util.*;

public class No17LetterCombinationsofaPhoneNumber {
    String[] num_chars = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String digits1 = "23";
        String digits2 = "";
        String digits3 = "2";

        No17LetterCombinationsofaPhoneNumber no17LetterCombinationsofaPhoneNumber = new No17LetterCombinationsofaPhoneNumber();

        List<String> result1 = no17LetterCombinationsofaPhoneNumber.letterCombinations(digits1);
        List<String> result2 = no17LetterCombinationsofaPhoneNumber.letterCombinations(digits2);
        List<String> result3 = no17LetterCombinationsofaPhoneNumber.letterCombinations(digits3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        dfs(result, digits, 0, new StringBuilder());
        return result;
    }

    private void dfs(List<String> result, String digits, int index, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < num_chars[digits.charAt(index) - '0'].length(); i++) {
            sb.append(num_chars[digits.charAt(index) - '0'].charAt(i));
            dfs(result, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // LeetCode 题解
    class Solution1 {
        public List<String> letterCombinations(String digits) {
            List<String> combinations = new ArrayList<String>();
            if (digits.length() == 0) {
                return combinations;
            }
            Map<Character, String> phoneMap = new HashMap<Character, String>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};
            backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
            return combinations;
        }

        public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
            if (index == digits.length()) {
                combinations.add(combination.toString());
            } else {
                char digit = digits.charAt(index);
                String letters = phoneMap.get(digit);
                int lettersCount = letters.length();
                for (int i = 0; i < lettersCount; i++) {
                    combination.append(letters.charAt(i));
                    backtrack(combinations, phoneMap, digits, index + 1, combination);
                    combination.deleteCharAt(index);
                }
            }
        }
    }
}
