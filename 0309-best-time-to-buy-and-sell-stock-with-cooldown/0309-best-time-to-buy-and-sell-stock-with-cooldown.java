class Solution {
    public int maxProfit(int[] prices) {
        int [][]dp=new int[prices.length][3];
        int n=prices.length;
        dp[0][0]=-prices[0];
        for(int i=1;i<prices.length;i++){
            //buy
            int notbuy=dp[i-1][0];
            int buy=dp[i-1][2]-prices[i];
            dp[i][0]=Math.max(buy,notbuy);
            //sell
            int sell=dp[i-1][1];
            int notsell=dp[i-1][0]+prices[i];
            dp[i][1]=   Math.max(sell,notsell);
            //cooldown
            int prevcooldown=dp[i-1][2];
            dp[i][2]=Math.max(prevcooldown,sell);
        }
        return dp[n-1][1];
    }
}