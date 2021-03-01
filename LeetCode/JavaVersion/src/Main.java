import CSNotes.BinarySearch.BinarySearch;
import CSNotes.Greedy.No53MaximumSubarray;
import CSNotes.Greedy.No605CanPlaceFlowers;
import CSNotes.Greedy.No665NondecreasingArray;
import CSNotes.Sort.No451SortCharactersByFrequency;

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

        // 快速排序
//        int []nums=new int[]{100,90,80,70,60,50,40};
//        new QuickSort().quickSort(nums,0, nums.length-1);
//        System.out.println(Arrays.toString(nums));

//        // 堆排序
//        int []nums=new int[]{10,60,22,85,50,20,40,58};
//        new HeapSort().heapSort(nums);
//        System.out.println(Arrays.toString(nums));

        // 桶排序
//        int []nums=new int[]{10,60,22,85,50,20,40,58};
//        new BucketSort().bucketSort(nums);
//        System.out.println(Arrays.toString(nums));

        // No 215
//        int []nums=new int[]{10,60,22,85,50,20,40,58};
//        System.out.println(new No215KthLargestElementinanArray().findKthLargest3(nums,2));

        // No 451
//        String str = "cccaaa";
//        System.out.println(new No451SortCharactersByFrequency().frequencySort1(str));

//        // No605
//        int[] flowers=new int[]{0,0,1,0,0};
//        System.out.println(new No605CanPlaceFlowers().canPlaceFlowers1(flowers,3));

//        // No 665
//        int []nums=new int[]{4,2,3,4};
//        System.out.println(new No665NondecreasingArray().checkPossibility(nums));

//        // No 53
//        int []nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(new No53MaximumSubarray().maxSubArray(nums));

        // 二分查找
        int []nums=new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(new BinarySearch().binarySearch(nums,7));
    }
}
