package QuestionBank.JianZhiOffer;

public class No63股票的最大利润 {
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

    // LeetCode 官方题解
    /*
    public int maxProfit(int prices[]) {
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
    */
}
