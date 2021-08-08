package QuestionBank.No101_200;

public class No121BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1 || (length == 2 && prices[0] > prices[1])) return 0;
        int[] left_min = new int[length];
        int[] right_max = new int[length];
        left_min[0] = prices[0];
        for (int i = 1; i < length; i++) left_min[i] = Math.min(left_min[i - 1], prices[i]);
        right_max[length - 1] = prices[length - 1];
        for (int i = length - 2; i >= 0; i--) right_max[i] = Math.max(right_max[i + 1], prices[i]);
        int max_value = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++)
            max_value = Math.max(max_value, right_max[i] >= left_min[i] ? right_max[i] - left_min[i] : Integer.MIN_VALUE);
        return max_value;
    }

    // LeetCode 官方题解1
    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    // 动态规划
    // dp[i]=max(dp[i−1],prices[i]−minprice)
    public int maxProfit3(int prices[]) {
        int len = prices.length;
        if (len == 0) return 0;
        int minprice = prices[0];
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            minprice = Math.min(minprice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minprice);
        }
        return dp[len - 1];
    }
}
