import CSNotes.Sort.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Cs Notes
        // Two Pointers
        // No 167
//        int[] numbers=new int[]{2,7,11,15};
//        int target=9;
//        System.out.println(Arrays.toString(new No167TwoSum().twoSum(numbers, target)));

        // No633

        // No 345
//        String test_str = "leetcode";
//        System.out.println(new No345ReverseVowelsofaString().reverseVowels(test_str));

        // No 680

        // No 88
//        int []nums1=new int[]{1,2,3,0,0,0};
//        int []nums2=new int[]{2,5,6};
//        int m=3;
//        int n=3;
//        int []nums1=new int[]{2,0};
//        int []nums2=new int[]{1};
//        int m=1;
//        int n=1;
//        int []nums1=new int[]{4,5,6,0,0,0};
//        int []nums2=new int[]{1,2,3};
//        int m=3;
//        int n=3;
//        new No88MergeSortedArray().merge2(nums1,m,nums2,n);
//        System.out.println(Arrays.toString(nums1));

        // QuickSorted
        int []nums=new int[]{100,90,80,70,60,50,40};
        new QuickSort().quickSort(nums,0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
