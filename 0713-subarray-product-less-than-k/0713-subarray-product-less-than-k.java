class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l=0;
       int count=0;
       int prod=1;
       if(k<=1){
        return 0;
       }int r=0;
       while(r<nums.length ){
        prod*=nums[r];
        while(prod>=k && l<nums.length){
            prod/=nums[l];
            l++;
        }
        if(prod<k)
            count+=r-l+1;
            r++;
         

       }
       return count;
    }
}
