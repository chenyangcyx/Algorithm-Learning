import QuestionBank.No227BasicCalculatorII;

public class Main {
    public static void main(String[] args) {
        String str1="3+2*2";
        String str2=" 3/2 ";
        String str3=" 3+5 / 2 ";
        String str4="1-1+1";
        System.out.println(new No227BasicCalculatorII().calculate(str4));
    }
}
