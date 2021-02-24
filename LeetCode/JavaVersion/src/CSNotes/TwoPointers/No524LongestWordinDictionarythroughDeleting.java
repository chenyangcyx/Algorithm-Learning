package CSNotes.TwoPointers;

import java.util.List;

public class No524LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String longest_str = "";
        for (String str : d) {
            if (str.length() < longest_str.length() || s.length() < str.length() || (str.length() == longest_str.length() && longest_str.compareTo(str) < 0)) {
                continue;
            }
            if (isSubString2(s, str)) {
                longest_str = str;
            }
        }
        return longest_str;
    }

    private boolean isSubString1(String str, String target) {
        int str_index = 0, target_index = 0;
        while (str_index < str.length() && target_index < target.length()) {
            if (str.charAt(str_index) == target.charAt(target_index)) {
                target_index++;
            }
            str_index++;
        }
        return target_index == target.length();
    }

    public boolean isSubString2(String str, String target) {
        int index = -1;
        for (int i = 0; i < target.length(); i++) {
            index = str.indexOf(target.charAt(i), index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
