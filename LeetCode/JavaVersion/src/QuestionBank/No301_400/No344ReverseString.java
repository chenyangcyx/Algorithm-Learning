package QuestionBank.No301_400;

public class No344ReverseString {
    public void reverseString(char[] s) {
        int n = s.length;
        if (n <= 1) return;
        int i = 0, j = n - 1;
        while (i < j) {
            s[i] = (char) (s[i] ^ s[j]);
            s[j] = (char) (s[i] ^ s[j]);
            s[i] = (char) (s[i] ^ s[j]);
            i++;
            j--;
        }
    }

    // LeetCode 参考代码
    public void reverseString2(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
