package QuestionBank.No1101_1200;

public class No1137NthTribonacciNumber {
    public static void main(String[] args) {
        No1137NthTribonacciNumber no1137NthTribonacciNumber = new No1137NthTribonacciNumber();

        System.out.println(no1137NthTribonacciNumber.tribonacci(4));
        System.out.println(no1137NthTribonacciNumber.tribonacci(10));
        System.out.println(no1137NthTribonacciNumber.tribonacci(25));
    }

    public int tribonacci(int n) {
        int[] nums = new int[n + 1];
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            nums[0] = 0;
            nums[1] = nums[2] = 1;
            for (int i = 3; i < n + 1; i++) {
                nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
            }
        }
        return nums[n];
    }
}
