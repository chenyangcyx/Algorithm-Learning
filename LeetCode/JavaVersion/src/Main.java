import QuestionBank.No101_200.No153FindMinimuminRotatedSortedArray;

public class Main {
    public static void main(String[] args) {
        int []nums1=new int[]{3,4,5,1,2};
        int []nums2=new int[]{4,5,6,7,0,1,2};
        int []nums3=new int[]{11,13,15,17};
        No153FindMinimuminRotatedSortedArray fmrs=new No153FindMinimuminRotatedSortedArray();
        System.out.println(fmrs.findMin(nums1));
        System.out.println(fmrs.findMin(nums2));
        System.out.println(fmrs.findMin(nums3));
    }
}
