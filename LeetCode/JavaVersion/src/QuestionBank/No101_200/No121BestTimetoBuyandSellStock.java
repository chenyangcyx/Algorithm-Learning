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
    public int maxProfit2(int[] prices) {
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
    public int maxProfit3(int[] prices) {
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

    // 动态规划1
    public int maxProfit_1(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    // 动态规划2：滚动数组
    public int maxProfit_2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] + prices[i]);
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], -prices[i]);
        }
        return dp[(len - 1) & 1][0];
    }

    // 动态规划3：空间优化
    public int maxProfit_3(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }

    // 股票买卖问题 题解
    // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
}
