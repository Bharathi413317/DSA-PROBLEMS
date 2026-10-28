class Solution {
    public int rec(int []nums,int []dp,int i){
        if(i>=nums.length) return 0;
        if(dp[i]==-1){
        int inc=rec(nums,dp,i+2)+nums[i];
        int exc=rec(nums,dp,i+1);
        dp[i]=Math.max(inc,exc);
        }
        return dp[i];
        
    }
    public int rob(int[] nums) {
        int []dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return rec(nums,dp,0);
    }
}