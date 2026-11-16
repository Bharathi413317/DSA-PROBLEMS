class Solution {
    public int maxProfit(int[] prices) {
           int low=prices[0];
           int profit=0;
           for(int i=0;i<prices.length;i++){
            int temp=prices[i]-low;
            low=Math.min(low,prices[i]);
            profit=Math.max(profit,temp);
           }
           return profit;
        
    }
}