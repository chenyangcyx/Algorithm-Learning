import QuestionBank.No331VerifyPreorderSerializationofaBinaryTree;

public class Main {
    public static void main(String[] args) {
        String str1="934##1##2#6##";
        String str2="1#";
        String str3="9##1";
        System.out.println(new No331VerifyPreorderSerializationofaBinaryTree().isValidSerialization1(str1));
        System.out.println(new No331VerifyPreorderSerializationofaBinaryTree().isValidSerialization2(str2));
        System.out.println(new No331VerifyPreorderSerializationofaBinaryTree().isValidSerialization3(str3));
    }
}
