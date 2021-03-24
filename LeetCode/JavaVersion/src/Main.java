import QuestionBank.No18_4Sum;

public class Main {
    public static void main(String[] args) {
        int []nums1=new int[]{0,0,0,0};
        int []nums2=new int[]{0,4,-5,2,-2,4,2,-1,4};
        No18_4Sum ss=new No18_4Sum();
        System.out.println(ss.fourSum(nums1,0));
        System.out.println(ss.fourSum(nums2,12));
    }
}
