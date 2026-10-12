class Solution {
    public int sum(int num){
        int s=0;
        while(num>0){
            int rem=num%10;
            s+=rem;
            num=num/10;
        }
        return s;

    }
    public int smallestIndex(int[] nums) {
        int minIndex=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i==sum(nums[i])){
                minIndex=Math.min(minIndex,i);
            }
        }return minIndex==Integer.MAX_VALUE? -1 : minIndex;
    }
}