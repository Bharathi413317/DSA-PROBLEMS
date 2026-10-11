class Solution {
    public int sumOfSquares(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(n%(i+1) ==0){
                int s=(int) Math.pow(nums[i],2);
                count+=s;
                
            }
        }return count;
    }
}