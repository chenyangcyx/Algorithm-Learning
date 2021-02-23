package CSNotes.TwoPointers;

public class No680ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return ifPalindrom(s, i, j + 1) || ifPalindrom(s, i - 1, j);
            }
        }
        return true;
    }

    private boolean ifPalindrom(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

//    // 参考代码
//    public boolean validPalindrome(String s) {
//        int i = 0, j = s.length() - 1;
//        char[] chars = s.toCharArray();
//        while (i < j && chars[i] == chars[j]) {
//            i++;
//            j--;
//        }
//        // 至此有两种情况：
//        // ① i>=j s本身就是回文串
//        // ② i<j && s[i] != s[j]必须要删一个
//        //   要么删s[i]，判断s[i+1,j]是否是回文串
//        //   要么删s[j]，判断s[i,j-1]是否是回文串
//        return i >= j
//                || isPalindrome(chars, i + 1, j)
//                || isPalindrome(chars, i, j - 1);
//    }
//
//    private boolean isPalindrome(char[] chars, int i, int j) {
//        while(i<j && chars[i]==chars[j]) {
//            i++;
//            j--;
//        }
//        return i>=j;
//    }
}
