import QuestionBank.No456132Pattern;

public class Main {
    public static void main(String[] args) {
        int []nums1=new int[]{1,2,3,4};
        int []nums2=new int[]{3,1,4,2};
        int []nums3=new int[]{-1,3,2,0};
        No456132Pattern pp=new No456132Pattern();
        System.out.println(pp.find132pattern(nums1));
        System.out.println(pp.find132pattern(nums2));
        System.out.println(pp.find132pattern(nums3));
    }
}
