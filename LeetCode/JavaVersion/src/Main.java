import QuestionBank.No11ContainerWithMostWater;

public class Main {
    public static void main(String[] args) {
        int []nums1=new int[]{1,8,6,2,5,4,8,3,7};
        int []nums2=new int[]{1,1};
        int []nums3=new int[]{4,3,2,1,4};
        int []nums4=new int[]{1,2,1};
        int []nums5=new int[]{1,2,4,3};
        No11ContainerWithMostWater cww=new No11ContainerWithMostWater();
        System.out.println(cww.maxArea(nums1));
        System.out.println(cww.maxArea(nums2));
        System.out.println(cww.maxArea(nums3));
        System.out.println(cww.maxArea(nums4));
        System.out.println(cww.maxArea(nums5));
    }
}
