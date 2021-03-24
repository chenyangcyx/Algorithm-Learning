import QuestionBank.No15_3Sum;

public class Main {
    public static void main(String[] args) {
        int []nums1=new int[]{-1,0,1,2,-1,-4};
        int []nums2=new int[0];
        int []nums3=new int[]{0};
        No15_3Sum sum=new No15_3Sum();
        System.out.println(sum.threeSum2(nums1));
        System.out.println(sum.threeSum2(nums2));
        System.out.println(sum.threeSum2(nums3));
    }
}
