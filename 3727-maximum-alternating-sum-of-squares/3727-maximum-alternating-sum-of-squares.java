class Solution {
    public long maxAlternatingSum(int[] nums) {
        int len=nums.length;  //length
        long ans=0;
        for(int i=0;i<len;i++){
            nums[i]=Math.abs(nums[i]-0);  // every element in nums positive
        }
        Arrays.sort(nums);
        for(int i=0;i<len/2;i++){
            int l=nums[i];
            int k=nums[len-i-1];
            ans+=(int)Math.pow(k,2);
            ans-=(int)Math.pow(l,2);
        }
        if(len%2==1){
            int j=nums[len/2];
            ans+=(int)Math.pow(j,2);
        }
        return ans;

    }
}