class Solution {
    public int rec(int n,int []dp){
        if(n==2 ||n==1) return n;
        if(dp[n]==-1){
      
        dp[n]=rec(n-1,dp)+(n-1)*rec(n-2,dp);
        }
    
        return dp[n];
    }
    public int countFriendsPairings(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return rec(n,dp);
    }
}
