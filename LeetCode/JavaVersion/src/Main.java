import QuestionBank.No201_300.No283MoveZeroes;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        No283MoveZeroes mz = new No283MoveZeroes();
        mz.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
