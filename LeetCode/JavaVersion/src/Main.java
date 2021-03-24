import QuestionBank.No9PalindromeNumber;

public class Main {
    public static void main(String[] args) {
        int x1=121;
        int x2=-121;
        int x3=10;
        int x4=-101;
        No9PalindromeNumber pn=new No9PalindromeNumber();
        System.out.println(pn.isPalindrome(x1));
        System.out.println(pn.isPalindrome(x2));
        System.out.println(pn.isPalindrome(x3));
        System.out.println(pn.isPalindrome(x4));
    }
}
