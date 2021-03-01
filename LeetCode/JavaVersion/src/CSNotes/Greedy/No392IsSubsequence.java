package CSNotes.Greedy;

public class No392IsSubsequence {
    // 自己写的代码
    public boolean isSubsequence1(String s, String t) {
        if (s.length() == 0) return true;
        int index1 = 0, index2 = 0;
        while (index1 < s.length() && index2 < t.length()) {
            if (s.charAt(index1) == t.charAt(index2++)) index1++;
        }
        return index1 >= s.length();
    }

    // CS-Note参考代码
    public boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
