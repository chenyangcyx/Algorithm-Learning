package QuestionBank.No101_200;

public class No122BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int length=prices.length;
        if(length==0 || (length==2&&prices[0]>prices[1])) return 0;
        int sum=0;
        int min=prices[0];
        for(int i=1;i<length;i++){
            if(prices[i]>min) sum+=prices[i]-min;
            min=prices[i];
        }
        return sum;
    }

    // LeetCode 题解1
    /*
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
     */

    // LeetCode 题解2
    /*
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
     */
}
