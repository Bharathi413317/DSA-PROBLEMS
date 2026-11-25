class Solution {
    public int rec(int []prices,int i,int state,int [][]dp){
        if(i==0){
            if(state==0){
                return -prices[i];
            }
            return 0;
        }if(dp[i][state]==-1){
        if(state==0){
            int buy= -prices[i]+rec(prices,i-1,2,dp);
            int notbuy=rec(prices,i-1,state,dp);
           return  dp[i][state]=Math.max(buy,notbuy);

        }else if(state==1){
            int sell=prices[i]+rec(prices,i-1,0,dp);
            int notsell=rec(prices,i-1,state,dp);
           return  dp[i][state]= Math.max(sell,notsell);
        }else{
            int cooldown=rec(prices,i-1,1,dp);
            int notcooldown=rec(prices,i-1,state,dp);
          return  dp[i][state]= Math.max(cooldown,notcooldown);

        }
        }return dp[i][state];
    }
    public int maxProfit(int[] prices) {
        int [][]dp=new int[prices.length][3];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(prices,prices.length-1,1,dp);
    }
}