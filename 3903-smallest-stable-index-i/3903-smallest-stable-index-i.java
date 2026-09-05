class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
       
        
        for(int i=0;i<nums.length;i++){
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            for(int p=0;p<=i;p++){
                 max=Math.max(max,nums[p]);
            }for(int m=i;m<nums.length;m++){
                 min=Math.min(min,nums[m]);
            }
              int instability = max - min;

            if (instability <= k) {
                return i;
        }
        }
    return -1;
    }
}