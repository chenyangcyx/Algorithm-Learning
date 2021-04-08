import QuestionBank.No1_100.No81SearchinRotatedSortedArrayII;

public class Main {
    public static void main(String[] args) {
        int []nums=new int[]{2,5,6,0,0,1,2};
        No81SearchinRotatedSortedArrayII srsa=new No81SearchinRotatedSortedArrayII();
        System.out.println(srsa.search(nums,0));
        System.out.println(srsa.search(nums,3));
    }
}
