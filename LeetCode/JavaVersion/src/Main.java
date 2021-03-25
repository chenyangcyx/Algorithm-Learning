import QuestionBank.No912SortanArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 快速排序
        int []nums1=new int[]{5,1,1,2,0,0};
        System.out.println(Arrays.toString(new No912SortanArray().sortArray_1_quicksort(nums1)));

        // 堆排序
        int []nums2=new int[]{5,1,1,2,0,0};
        System.out.println(Arrays.toString(new No912SortanArray().sortArray2_heapsort(nums2)));

        // 归并排序1
        int []nums3=new int[]{5,1,1,2,0,0};
        System.out.println(Arrays.toString(new No912SortanArray().sortArray3_mergesort1(nums3)));

        // 归并排序2
        int []nums4=new int[]{5,1,1,2,0,0};
        System.out.println(Arrays.toString(new No912SortanArray().sortArray3_mergesort2(nums4)));
    }
}
