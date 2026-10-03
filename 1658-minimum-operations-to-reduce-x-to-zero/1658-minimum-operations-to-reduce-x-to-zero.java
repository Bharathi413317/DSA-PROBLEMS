class Solution {
    public int minOperations(int[] nums, int x) {
        if(x<0){
            return -1;
        }
        int len=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

        }
        sum-=x;
        if(sum<0) return -1;
        if(sum==0) return nums.length;
        int l=0,r=0;
        int k=0;
        while(r<nums.length){
              k+=nums[r];
              while(l<=r && k>sum){
                k-=nums[l];
                l++;
              }
              if(sum==k){
                len=Math.max(len,r-l+1);
              }
              r++;
        }
        return len==Integer.MIN_VALUE ? -1 :nums.length-len;

           
    }
}