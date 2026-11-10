class Solution {
    public int rec(int i,int n,int []costs,int []dp){
        if(i==n) return 0;

        if(dp[i]!=-1) return dp[i];

        int ans=Integer.MAX_VALUE;

        for(int j=1;j<=3;j++){
            if(i+j<=n){
                int cost=costs[i+j-1]+j*j;

                ans=Math.min(ans,
                    cost+rec(i+j,n,costs,dp));
            }
        }

        return dp[i]=ans;
    }

    public int climbStairs(int n, int[] costs) {
        int []dp=new int[n+1];

        Arrays.fill(dp,-1);

        return rec(0,n,costs,dp);
    }
}