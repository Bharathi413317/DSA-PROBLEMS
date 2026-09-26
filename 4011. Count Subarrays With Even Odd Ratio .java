class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int count=0;
         for(int i=0;i<nums.length;i++){
            int even=0;
            int odd=0;
            for(int j=i;j<nums.length;j++){
                 if(nums[j]%2==0) even++;
                 else odd++;
                if(odd>0 && (long)(b*even)<=(long)(a*odd)){
                    count++;
                }

            }
         }return count;
    }
}
