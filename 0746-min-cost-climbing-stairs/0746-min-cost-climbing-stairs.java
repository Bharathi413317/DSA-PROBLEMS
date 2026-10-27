class Solution {
    public int rec(int []cost,int []dp,int i){
        if(i==cost.length) return 0;
        if(i>cost.length) return Integer.MAX_VALUE;
        if(dp[i]==-1){
        int a=rec(cost,dp,i+1);
        int b=rec(cost,dp,i+2);
        dp[i]=Math.min(a,b)+cost[i];
        }

        return dp[i];
    }

    public int minCostClimbingStairs(int[] cost) {
        int []dp=new int[cost.length];
        Arrays.fill(dp,-1);
       return Math.min(rec(cost,dp,0),rec(cost,dp,1));
    }
}