import QuestionBank.No224BasicCalculator;

public class Main {
    public static void main(String[] args) {
        String str="( 1+ ( 4+ 5 +2 )- 3) + (6 +8)";
        String str2="-2 + 1";
        System.out.println(new No224BasicCalculator().calculate(str));
    }
}
