class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,int k1, int k2) {
        int n=nums1.length;
        long ans=Long.MAX_VALUE;
        long summ=0L;
        int[] diff=new int[n];  //difff array
        long total=0L;
        int maxDiff=0;
        for(int i=0;i<n;i++){
            diff[i]=Math.abs(nums1[i]-nums2[i]);
            maxDiff=Math.max(maxDiff,diff[i]);
            total+=diff[i];
        }
        // for(int i=0;i<n;i++){
        //     summ+=(long)diff[i]*diff[i];
        // }
        long kk=k1+k2;
        if(total<=kk) return 0;

        int low=0,high=maxDiff;
        while(low<high){
            int mid=low+(high-low)/2;
            total=0;
            for(int i=0;i<n;i++){
                if(diff[i]>mid){
                    total+=diff[i]-mid;
                }
            }
            if(total<=kk){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        long k=kk;
        for(int i=0;i<n;i++){
            if(diff[i]>low){
                k-=diff[i]-low;
                diff[i]=low;
            }
        }
        for(int i=0;i<n && k>0;i++){
            if(diff[i]==low && low>0){
                diff[i]--;
                k--;
            }
        }
        ans=0;
        for(int i=0;i<n;i++){
            ans+=(long)diff[i]*diff[i];
        }

return ans;

    }
}