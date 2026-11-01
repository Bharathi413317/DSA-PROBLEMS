
class Solution {

    

    public int minMoves(int[] nums) {
       int count=0;
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            count+=nums[i]-min
;        }
             return count;
       
    }
}