import QuestionBank.No93RestoreIPAddresses;

public class Main {
    public static void main(String[] args) {
        String str1="25525511135";
        String str2="0000";
        String str3="1111";
        String str4="010010";
        String str5="101023";
        System.out.println(new No93RestoreIPAddresses().restoreIpAddresses(str1).toString());
        System.out.println(new No93RestoreIPAddresses().restoreIpAddresses(str2).toString());
        System.out.println(new No93RestoreIPAddresses().restoreIpAddresses(str3).toString());
        System.out.println(new No93RestoreIPAddresses().restoreIpAddresses(str4).toString());
        System.out.println(new No93RestoreIPAddresses().restoreIpAddresses(str5).toString());
    }
}
