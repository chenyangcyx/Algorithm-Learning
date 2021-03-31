import QuestionBank.No90SubsetsII;

public class Main {
    public static void main(String[] args) {
        int []nums1=new int[]{1,2,2};
        int []nums2=new int[]{0};
        int []nums3=new int[]{4,4,4,1,4};
        System.out.println(new No90SubsetsII().subsetsWithDup(nums1));
        System.out.println(new No90SubsetsII().subsetsWithDup(nums2));
        System.out.println(new No90SubsetsII().subsetsWithDup(nums3));
    }
}
