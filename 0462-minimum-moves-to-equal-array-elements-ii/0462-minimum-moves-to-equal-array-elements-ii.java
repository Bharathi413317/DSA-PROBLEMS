class Solution {
    public int minMoves2(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        int mid=nums.length/2;
        for(int num:nums){
            count+=Math.abs(num-nums[mid]);
        }
        return count;
        
    } 
}