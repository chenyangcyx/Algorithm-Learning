import QuestionBank.No150EvaluateReversePolishNotation;

public class Main {
    public static void main(String[] args) {
        String []token=new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new No150EvaluateReversePolishNotation().evalRPN(token));
    }
}
