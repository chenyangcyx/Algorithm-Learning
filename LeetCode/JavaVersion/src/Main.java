import QuestionBank.No215KthLargestElementinanArray;

public class Main {
    public static void main(String[] args) {
        int []nums1=new int[]{3,2,1,5,6,4};
        int []nums2=new int[]{3,2,3,1,2,4,5,5,6};
        int []nums3=new int[]{-1,-1};
        System.out.println(new No215KthLargestElementinanArray().findKthLargest1(nums1,2));
        System.out.println(new No215KthLargestElementinanArray().findKthLargest1(nums2,4));
        System.out.println(new No215KthLargestElementinanArray().findKthLargest1(nums3,2));
        System.out.println(new No215KthLargestElementinanArray().findKthLargest2(nums1,2));
        System.out.println(new No215KthLargestElementinanArray().findKthLargest2(nums2,4));
        System.out.println(new No215KthLargestElementinanArray().findKthLargest2(nums3,2));
    }
}
