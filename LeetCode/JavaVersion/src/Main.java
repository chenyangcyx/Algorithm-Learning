import QuestionBank.No8StringtoInteger_atoi;

public class Main {
    public static void main(String[] args) {
        String str1="42";
        String str2="-42";
        String str3="4193 with words";
        String str4="words and 987";
        String str5="-91283472332";
        String str6="00000-42a1234";
        No8StringtoInteger_atoi si=new No8StringtoInteger_atoi();
        System.out.println(si.myAtoi(str1));
        System.out.println(si.myAtoi(str2));
        System.out.println(si.myAtoi(str3));
        System.out.println(si.myAtoi(str4));
        System.out.println(si.myAtoi(str5));
        System.out.println(si.myAtoi(str6));
    }
}
