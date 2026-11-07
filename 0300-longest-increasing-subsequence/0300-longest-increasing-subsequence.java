class Solution {
    public int rec(int []nums,int i,int next,int [][]dp){
        if(i<0){
            return 0;
        }
        if(dp[i][next]==-1){
        int exc=rec(nums,i-1,next,dp);
        int inc=0;
        if(next==nums.length || nums[i]<nums[next]){
            inc=rec(nums,i-1,i,dp)+1;
        }
        dp[i][next]=Math.max(inc,exc);
        }
        return dp[i][next];
    }
    public int lengthOfLIS(int[] nums) {
       
       int n=nums.length;
       int [][]dp=new int[n][n+1];
       for(int i=0;i<nums.length;i++){
        Arrays.fill(dp[i],-1);
       }
     
       return rec(nums,n-1,n,dp);

    }
}