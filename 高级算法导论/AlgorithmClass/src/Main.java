import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
        Arrays.sort(nums);
//        LinkedList<Integer> stack = new LinkedList<>();
//        int left = 0, right = N-1;
//        stack.addLast(left);
//        stack.addLast(right);
//        while (!stack.isEmpty()) {
//            int _right = stack.pollLast();
//            int _left = stack.pollLast();
//            int index = Partition(nums, _left, _right);
//            if (_left < index-1) {
//                stack.addLast(_left);
//                stack.addLast(index - 1);
//            }
//            if (_right > index+1) {
//                stack.addLast(index + 1);
//                stack.addLast(_right);
//            }
//        }
        for (int i = 0; i < N; i++) {
            if (i == 0) System.out.print(nums[i]);
            else System.out.print(" " + nums[i]);
        }
        System.out.println();
    }

    private static int Partition(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > temp) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] < temp) left++;
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }
}
