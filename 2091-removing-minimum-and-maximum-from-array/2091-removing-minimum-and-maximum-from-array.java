class Solution {
    public int minimumDeletions(int[] nums) {
        int minindex=0;
        int maxindex=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[minindex]){
                minindex=i;
            }
        } for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[maxindex]){
                maxindex=i;
            }
        }if(minindex>maxindex){
            int temp=maxindex;
            maxindex=minindex;
            minindex=temp;
        }int front=maxindex+1;
        int back=nums.length-minindex;
        int both=n-maxindex+minindex+1;
        return Math.min(front,Math.min(back,both));
    }
}