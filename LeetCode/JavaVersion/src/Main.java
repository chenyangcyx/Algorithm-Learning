import QuestionBank.No26RemoveDuplicatesfromSortedArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        No26RemoveDuplicatesfromSortedArray rdsa=new No26RemoveDuplicatesfromSortedArray();
        int []nums1=new int[]{0,1,1,2,2,2,3,3,3,3,4,5,6,8,8,8,8};
        int []nums2=new int[]{1,1,2};
        int []nums3=new int[]{0,0,1,1,1,2,2,3,3,4};
        rdsa.removeDuplicates(nums1);
        rdsa.removeDuplicates(nums2);
        rdsa.removeDuplicates(nums3);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }
}
