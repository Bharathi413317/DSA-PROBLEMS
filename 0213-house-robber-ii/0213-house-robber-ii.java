class Solution {
    public int rec(int []nums,int sum,int i,int n,int [][]dp){
        if(i>=n){
            return sum;
        }
        if(dp[i][sum]!=-1){
            return dp[i][sum];
        }
        int inc=rec(nums,sum+nums[i],i+2,n,dp);
      
        int exc=rec(nums,sum,i+1,n,dp);

       return dp[i][sum]=Math.max(inc,exc);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[][] dp1 = new int[n][100000];
        int[][] dp2 = new int[n][100000];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp1[i], -1);
            Arrays.fill(dp2[i], -1);
        }

        int first=rec(nums,0,0,n-1,dp1);
        int second=rec(nums,0,1,n,dp2);
       return Math.max(first,second);
        
    }
}