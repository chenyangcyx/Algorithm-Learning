import QuestionBank.No14LongestCommonPrefix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String []strs1=new String[]{"flower","flow","flight"};
        String []strs2=new String[]{"dog","racecar","car"};
        No14LongestCommonPrefix lcp=new No14LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(strs1));
        System.out.println(lcp.longestCommonPrefix(strs2));

        lcp.longestCommonPrefix2(strs1);
        lcp.longestCommonPrefix2(strs2);
        System.out.println(Arrays.toString(strs1));
        System.out.println(Arrays.toString(strs2));
    }
}
