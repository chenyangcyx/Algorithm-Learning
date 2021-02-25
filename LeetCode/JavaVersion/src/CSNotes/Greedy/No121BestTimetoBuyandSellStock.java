package CSNotes.Greedy;

public class No121BestTimetoBuyandSellStock {
    // 自己写的
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            max = Integer.max(max, prices[i] - min);
        }
        return max;
    }

    // 参考代码
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int soFarMin = prices[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (soFarMin > prices[i]) soFarMin = prices[i];
            else max = Math.max(max, prices[i] - soFarMin);
        }
        return max;
    }
}
