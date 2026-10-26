class Solution {
   public int rec(int n,int []dp){
    if (n==0 || n==1) return 1;
    if(dp[n]==0){
     dp[n]=rec(n-1,dp)+rec(n-2,dp);
    }
     return dp[n];
    
   }
    public int climbStairs(int n) {
        int []dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
       return rec(n,dp);
    }
}