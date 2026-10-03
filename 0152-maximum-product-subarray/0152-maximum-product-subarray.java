class Solution {
    public int maxProduct(int[] nums) {
      int res=nums[0];
      int maxprod=nums[0];
      int minprod=nums[0];
      for(int i=1;i<nums.length;i++){
        int curr=nums[i];
        if(curr<0){
            int temp=maxprod;
            maxprod=minprod;
            minprod=temp;
        }maxprod=Math.max(curr,curr*maxprod);
        minprod=Math.min(curr,curr*minprod);
        res=Math.max(res,maxprod);
      }return res;
    }
}