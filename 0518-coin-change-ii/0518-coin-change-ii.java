class Solution {
    public int rec(int []coins,int amount,int i,int [][]dp){
        if(amount<0 || i >=coins.length ){
            return 0;
        }if(amount==0){
            return 1;
        }
        if(dp[i][amount]==-1){

        
        int stay=rec(coins,amount-coins[i],i,dp);
        int move=rec(coins,amount,i+1,dp);
        dp[i][amount]=stay+move;
        }
        return dp[i][amount];


    }
    public int change(int amount, int[] coins) {
        int [][]dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(coins,amount,0,dp);
        
    }
}