class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int mod=1000000007;
        int []count=new int[32];
        int n=nums.size();
        for(int num: nums){
            for(int i=0;i<32;i++){
                if((num & (1<<i))!=0){
                    count[i]++;
                }
            }
        }
        long ans=0;
        for(int i=0;i<k;i++){
            long num=0;
            for(int b=0;b<32;b++){
                if(count[b]>0){
                    num|=(1L<<b);
                    count[b]--;
                }
            }
            ans=(ans+(num*num))%mod;
        }return (int)ans;
    }
}