class Solution {

    public long maxAlternatingSum(int[] nums) {
       long ans=0;
       int n=nums.length;
       for(int i=0;i<n;i++){
        if(nums[i]<0){
              nums[i]=Math.abs(nums[i]-0); 
    }
} Arrays.sort(nums);
for(int i=0;i<n/2;i++){
            int k=nums[i];
            int l=nums[n-i-1];
            ans +=(int)Math.pow(l,2);
            ans-=(int)Math.pow(k,2);
}if(n%2==1){
    int j=nums[n/2];
    ans+=(int)Math.pow(j,2);
}
    return ans;
        
    }
}