class Solution {
    public int rec(int n,int []dp){
       if(n==0 || n==1) return n;
       if(dp[n]!=0) return dp[n];
       dp[n]=rec(n-1,dp)+rec(n-2,dp);
       
       return dp[n];
    }
    public int fib(int n) {
        int []dp=new int[n+1];
        return rec(n,dp);
    }
}
