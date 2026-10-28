class Solution {
    public int rec(int []nums){
     int previnc=0;
     int prevexec=0;
     for(int i=0;i<nums.length;i++){
        int currinc=prevexec+nums[i];
        int currexc=Math.max(previnc,prevexec);
        previnc=currinc;
        prevexec=currexc;
     }
     return Math.max(previnc,prevexec);

    }
    public int rob(int[] nums) {
        
        return rec(nums);
    }
}