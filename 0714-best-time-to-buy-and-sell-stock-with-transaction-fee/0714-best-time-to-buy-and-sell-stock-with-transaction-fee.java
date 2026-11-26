class Solution {
    public int rec(int[] prices, int fee, int[][] dp) {
        for (int i = 0; i < prices.length; i++) {
            for (int state = 0; state < 2; state++) {

                if (i == 0) {
                    if (state == 0)
                        dp[i][state] = 0;
                    else
                        dp[i][state] = -prices[i];

                    continue;
                }

                if (state == 0) {
                    int sell = prices[i] - fee + dp[i - 1][1];
                    int notsell = dp[i - 1][0];

                    dp[i][state] = Math.max(sell, notsell);

                } else {
                    int buy = -prices[i] + dp[i - 1][0];
                    int notbuy = dp[i - 1][1];

                    dp[i][state] = Math.max(buy, notbuy);
                }
            }
        }

        return dp[prices.length - 1][0];
    }

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        return rec(prices, fee, dp);
    }
}