class Solution {
    public int rec(int []coins,int amount,int []dp){
        int ans=100000;
        if(amount<0){
            return 100000;
        }if(amount==0){
            return 0;
        } 
         if(dp[amount]!=-1){
            return dp[amount];
         }
        for(int i=0;i<coins.length;i++){
            int coin=coins[i];
       
            int remsum=amount-coin;
            int cmr=rec(coins,remsum,dp);
            if(cmr!=100000)
            ans=Math.min(ans,cmr+1);
           
            }
        
         dp[amount]=ans;
        return dp[amount];
    }
    public int coinChange(int[] coins, int amount) {
        int []dp=new int[amount+1];
        Arrays.fill(dp,-1);
         int res= rec(coins,amount,dp);
         return res==100000?-1:res;
    }
}
