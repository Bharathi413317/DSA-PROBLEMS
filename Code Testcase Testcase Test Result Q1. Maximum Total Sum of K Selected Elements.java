class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long ans=0;
        for(int i=nums.length-1;i>=nums.length-k;i--){
            ans+=nums[i];
        }int t=Math.min(k,mul-1);
        for(int j=0;j<t;j++){
            int val=nums[nums.length-1-j];
            ans+=1L*val*(mul-1-j);
        }
        return ans;
    }
}
