import QuestionBank.No31NextPermutation;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int []nums=new int[]{4,5,2,6,3,1};
        No31NextPermutation np=new  No31NextPermutation();
        np.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
