class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
       int n=nums.size();
       int ans=Integer.MAX_VALUE;
       for(int size=l;size<=r;size++){
        int sum=0;
        for(int i=0;i<size;i++){
            sum+=nums.get(i);
    
        }if(sum>0){
            ans=Math.min(ans,sum);
        }for(int j=size;j<n;j++){
            sum+=nums.get(j);
            sum-=nums.get(j-size);

        if(sum>0){
              ans=Math.min(ans,sum);
        }
        }
       }if(ans==Integer.MAX_VALUE)return -1;
       return ans;
    }
}   
