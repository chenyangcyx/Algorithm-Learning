package QuestionBank;

public class No303RangeSumQuery_Immutable {
    int N = 0;
    int[] sum;

    public No303RangeSumQuery_Immutable(int[] nums) {
        N = nums.length;
        sum = new int[N];
        sum[0] = nums[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) return sum[right];
        else return sum[right] - sum[left - 1];
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */
}

// CS-Note 参考代码
class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}