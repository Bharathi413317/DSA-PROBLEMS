class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int indx=Integer.MAX_VALUE;
        int n=nums.length;
        int []psmax=new int [n];
        int []smin=new int[n];
        psmax[0]=nums[0];
        smin[n-1]=nums[n-1];
        for(int i=1;i<nums.length;i++){
              psmax[i]=Math.max(nums[i],psmax[i-1]);
             
        }for(int i=n-2;i>=0;i--){
            smin[i]=Math.min(smin[i+1],nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(psmax[i]-smin[i]<=k){
                 return i;
            }
        }return -1;
    }
}